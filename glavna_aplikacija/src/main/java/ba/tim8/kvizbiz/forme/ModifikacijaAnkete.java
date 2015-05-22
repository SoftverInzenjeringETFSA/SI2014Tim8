package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;

public class ModifikacijaAnkete extends JFrame {

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
					ModifikacijaAnkete frame = new ModifikacijaAnkete();
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
	public ModifikacijaAnkete() {
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
		pnlPodaci.setBorder(new TitledBorder("Unesite nove podatke o anketi:"));
		kontejner.add(pnlPodaci, "cell 0 0 3 1,growx");
		
		pnlPodaci.add(new JLabel("Naslov ankete: "), "cell 1 0,alignx right");
		pnlPodaci.add(new JLabel("Vremensko ograničenje: "), "cell 1 1,alignx right");
		
		tbxNaslov = new JTextField();
		pnlPodaci.add(tbxNaslov, "cell 2 0,growx");
		
		spiVrijeme = new JSpinner();
		spiVrijeme.setModel(new SpinnerNumberModel(10, 1, 30, 1));
		pnlPodaci.add(spiVrijeme, "cell 2 1,alignx left");
		
		JPanel pnlPitanja = new JPanel();
		pnlPitanja.setBorder(new TitledBorder("Unesite pitanja:"));
		kontejner.add(pnlPitanja, "cell 0 1 3 1,growx,growy");
		
		JButton btnDodaj = new JButton("Dodaj novo pitanje");
		btnDodaj.setBounds(13, 23, 159, 23);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				frmDodavanjePitanja_v2 forma = new frmDodavanjePitanja_v2((JFrame) SwingUtilities.getRoot(component));
				forma.setVisible(true);
				dispose();
			}
		});
		pnlPitanja.setLayout(null);
		pnlPitanja.add(btnDodaj);
		
		JLabel label = new JLabel("Odaberite ID:");
		label.setBounds(13, 50, 97, 20);
		pnlPitanja.add(label);
		final JComboBox<Integer> cbbID = new JComboBox<Integer>();
		cbbID.setBounds(114, 50, 58, 20);
		PitanjeDao pdao = PitanjeDao.get();
		for(long id : pdao.DajSveIdZaKviz(1))
			cbbID.addItem((int)id);
		pnlPitanja.add(cbbID);
		
		JButton btnPromjeni = new JButton("Promjeni odabrano pitanje");
		btnPromjeni.setBounds(13, 74, 159, 23);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Component component = (Component) e.getSource();
				//forma.setVisible(true);
				//dispose();
			}
		});
		pnlPitanja.add(btnPromjeni);
		
		JButton btnObrisi = new JButton("Obriši odabrano pitanje");
		btnObrisi.setBounds(13, 101, 159, 23);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int odabraniId = (Integer) cbbID.getSelectedItem();
				PitanjeDao pdao = PitanjeDao.get();
				try {
					pdao.delete((long) odabraniId);
					lblStatus.setText("Pitanje je uspješno obrisano.");
					lblStatus.setForeground(Color.green);
					
					removeAllRows();
					ucitajSvaPitanja();
					
					cbbID.removeAllItems();
					for(long id : pdao.DajSveIdZaKviz(1))
						cbbID.addItem((int)id);
					
					contentPane.revalidate();
					contentPane.repaint();
				}
				catch (Exception e1) {
					lblStatus.setText("Greska: " + e1.getMessage());
					lblStatus.setForeground(Color.red);
				}
			}
		});
		pnlPitanja.add(btnObrisi);
		
		JButton btnOk = new JButton("OK");
		kontejner.add(btnOk, "flowx,cell 2 2,growx");
		
		JButton btnOtkazi = new JButton("Otkaži");
		kontejner.add(btnOtkazi, "cell 1 2,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 23, 381, 283);
		pnlPitanja.add(scrollPane);
			
		tblPitanja = new JTable();
		scrollPane.setViewportView(tblPitanja);
		tblPitanja.setColumnSelectionAllowed(true);
		tblPitanja.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblPitanja.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID pitanja", "Tekst pitanja", "Tip pitnja", "Status ankete"
			}
		)
		{
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		
		
		
		JButton btnNewButton = new JButton("Promjena statusa ankete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(13, 174, 159, 23);
		pnlPitanja.add(btnNewButton);
		
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
