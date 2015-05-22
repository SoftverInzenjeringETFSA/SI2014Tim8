package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import net.miginfocom.swing.MigLayout;

public class KreiranjeAnkete extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static Kviz trenutniKviz;
	
	private JPanel contentPane;
	private JTextField tbxNaslov;
	private JTable tblPitanja;
	private JLabel lblStatus;
	private JSpinner spiVrijeme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KreiranjeAnkete frame = new KreiranjeAnkete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KreiranjeAnkete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JPanel kontejner = new JPanel(new MigLayout("", "[grow][100px][100px]", "[fill][grow][fill]"));
		kontejner.setBorder(null);
		contentPane.add(kontejner, BorderLayout.CENTER);
		
		JPanel pnlPodaci = new JPanel(new MigLayout("", "[grow][fill][220px][grow]", "[fill][fill]"));
		pnlPodaci.setBorder(new TitledBorder("Unesite osnovne podatke o anketi:"));
		kontejner.add(pnlPodaci, "cell 0 0 3 1,growx");
		
		pnlPodaci.add(new JLabel("Nalov ankete: "), "cell 1 0,alignx right");
		pnlPodaci.add(new JLabel("Vremensko ograničenje: "), "cell 1 1,alignx right");
		
		tbxNaslov = new JTextField();
		pnlPodaci.add(tbxNaslov, "cell 2 0,growx");
		
		spiVrijeme = new JSpinner();
		spiVrijeme.setModel(new SpinnerNumberModel(10, 1, 30, 1));
		pnlPodaci.add(spiVrijeme, "cell 2 1,alignx left");
		
		JPanel pnlPitanja = new JPanel(new MigLayout("", "[fill][grow]", "[fill][fill][fill][fill][grow]"));
		pnlPitanja.setBorder(new TitledBorder("Unesite pitanja:"));
		kontejner.add(pnlPitanja, "cell 0 1 3 1,growx,growy");
		
		JButton btnDodaj = new JButton("Dodaj novo pitanje");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				frmDodavanjePitanja_v2 forma = new frmDodavanjePitanja_v2((JFrame) SwingUtilities.getRoot(component));
				forma.setVisible(true);
				dispose();
			}
		});
		pnlPitanja.add(btnDodaj, "cell 0 0");
		
		pnlPitanja.add(new JLabel("Odaberite ID:"), "cell 0 1,alignx left");
		JComboBox<Integer> cbbID = new JComboBox<Integer>();
		PitanjeDao pdao = PitanjeDao.get();
		for(long id : pdao.DajSveIdZaKviz(1))
			cbbID.addItem((int)id);
		pnlPitanja.add(cbbID, "cell 0 1,alignx left");
		
		JButton btnPromjeni = new JButton("Promjeni odabrano pitanje");
		pnlPitanja.add(btnPromjeni, "cell 0 2");
		
		JButton btnObrisi = new JButton("Obriši odabrano pitanje");
		pnlPitanja.add(btnObrisi, "cell 0 3");
		
		JButton btnOk = new JButton("OK");
		kontejner.add(btnOk, "flowx,cell 2 2,growx");
		
		JButton btnOtkazi = new JButton("Otkaži");
		kontejner.add(btnOtkazi, "cell 1 2,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 145, 580, 127);
		pnlPitanja.add(scrollPane, "cell 1 0 1 5,growx");
			
		tblPitanja = new JTable();
		scrollPane.setViewportView(tblPitanja);
		tblPitanja.setColumnSelectionAllowed(true);
		tblPitanja.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblPitanja.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID pitanja", "Tekst pitanja", "Tip pitnja"
			}
		)
		{
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		
		ucitajSvaPitanja();
	}
	
	private void ucitajSvaPitanja()
	{
		PitanjeDao pdao = PitanjeDao.get();
		Collection<Pitanje> pitanja = pdao.readAll();
		DefaultTableModel model = (DefaultTableModel) tblPitanja.getModel();
		
		ucitajPitanja(pitanja);
	}	
	
	private void ucitajPitanja(Collection<Pitanje> pitanja)
	{
		DefaultTableModel model = (DefaultTableModel) tblPitanja.getModel();
		removeAllRows();
		
		for(Pitanje p : pitanja)
		{
			model.addRow(new Object[]{p.get_id(), p.get_tekstPitanja(), p.get_tipPitanja()});
		}
	}
	
	private void removeAllRows()
	{
		DefaultTableModel dm = (DefaultTableModel) tblPitanja.getModel();
		int rowCount = dm.getRowCount();
	
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
}
