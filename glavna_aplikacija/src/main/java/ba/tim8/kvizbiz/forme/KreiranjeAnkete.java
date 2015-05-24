package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

public class KreiranjeAnkete extends JFrame {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(KreiranjeAnkete.class);
	
	public static long trenutniKvizID = -1;
	
	private JPanel contentPane;
	private JTextField tbxNaslov;
	private JTable tblPitanja;
	private JLabel lblStatus;
	private JSpinner spiVrijeme;
	private JComboBox<Integer> cbbID;
	private JButton btnDodaj;
	private JButton btnObrisi;
	private JButton btnPromjeni;

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
		
		JPanel pnlPodaci = new JPanel(new MigLayout("", "[grow][fill][220px][grow]", "[fill][fill][fill]"));
		pnlPodaci.setBorder(new TitledBorder("Unesite osnovne podatke o anketi:"));
		kontejner.add(pnlPodaci, "cell 0 0 3 1,growx");
		
		pnlPodaci.add(new JLabel("Nalov ankete: "), "cell 1 0,alignx right");
		pnlPodaci.add(new JLabel("Vremensko ograničenje: "), "cell 1 1,alignx right");
		
		tbxNaslov = new JTextField();
		pnlPodaci.add(tbxNaslov, "cell 2 0,growx");
		
		spiVrijeme = new JSpinner();
		spiVrijeme.setModel(new SpinnerNumberModel(10, 1, 30, 1));
		pnlPodaci.add(spiVrijeme, "cell 2 1,alignx left");
		
		JButton btnPotvrdi = new JButton("Potvrdi osnovne podatke");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KvizDao kdao = KvizDao.get();
				try {
					trenutniKvizID = kdao.create(new Kviz(0, tbxNaslov.getText(), (Integer)spiVrijeme.getValue(), false, false));
					lblStatus.setText("Uspjesan unos početnih podataka");
					lblStatus.setForeground(Color.green);
					
					btnDodaj.setEnabled(true);
					btnObrisi.setEnabled(true);
					btnPromjeni.setEnabled(true);
					cbbID.setEnabled(true);
				}
				catch(Exception e1) {
					lblStatus.setText("Greska: " + e1.getMessage());
					lblStatus.setForeground(Color.red);
					
					logger.error("Greska: ", e1);
				}
			}
		});
		pnlPodaci.add(btnPotvrdi, "cell 2 2, alignx right");
		
		JPanel pnlPitanja = new JPanel(new MigLayout("", "[fill][grow]", "[fill][fill][fill][fill][grow]"));
		pnlPitanja.setBorder(new TitledBorder("Unesite pitanja:"));
		kontejner.add(pnlPitanja, "cell 0 1 3 1,growx,growy");
		
		btnDodaj = new JButton("Dodaj novo pitanje");
		btnDodaj.setEnabled(false);
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
		cbbID = new JComboBox<Integer>();
		cbbID.setEnabled(false);
		PitanjeDao pdao = PitanjeDao.get();
		if (trenutniKvizID != -1)
			for(long id : pdao.DajSveIdZaKviz(trenutniKvizID))
				cbbID.addItem((int)id);
		pnlPitanja.add(cbbID, "cell 0 1,alignx left");
		
		btnPromjeni = new JButton("Promjeni odabrano pitanje");
		btnPromjeni.setEnabled(false);
		btnPromjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				ModifikacijaPitanja forma = new ModifikacijaPitanja((JFrame) SwingUtilities.getRoot(component), (Integer) cbbID.getSelectedItem());
				forma.setVisible(true);
				dispose();
			}
		});
		pnlPitanja.add(btnPromjeni, "cell 0 2");
		
		btnObrisi = new JButton("Obriši odabrano pitanje");
		btnObrisi.setEnabled(false);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int odabraniId = (Integer) cbbID.getSelectedItem();
				PitanjeDao pdao = PitanjeDao.get();
				try {
					pdao.delete((long) odabraniId);
					lblStatus.setText("Pitanje je uspješno obrisano.");
					lblStatus.setForeground(Color.green);
					
					refresh();
				}
				catch (Exception e1) {
					lblStatus.setText("Greska: " + e1.getMessage());
					lblStatus.setForeground(Color.red);
					
					logger.error("Greska: ", e1);
				}
			}
		});
		pnlPitanja.add(btnObrisi, "cell 0 3");
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PocetnaKlijent forma = new PocetnaKlijent();
				forma.setVisible(true);
				dispose();
			}
		});
		kontejner.add(btnOk, "flowx,cell 2 2,growx");
		
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
				"ID", "Tekst pitanja", "Tip pitnja"
			}
		)
		{
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		tblPitanja.getColumnModel().getColumn(0).setPreferredWidth(10);
		
		lblStatus = new JLabel("Pomoć: Kako biste pristupili neaktivnim buttonima, prvo potvrdite osnovne podatke.");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		
		if (trenutniKvizID != -1)
			ucitajSvaPitanja();
	}
	
	private void ucitajSvaPitanja()
	{
		PitanjeDao pdao = PitanjeDao.get();
		Collection<Pitanje> pitanja = pdao.DajSveZaKviz(trenutniKvizID);
		//DefaultTableModel model = (DefaultTableModel) tblPitanja.getModel();
		
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
	
	public void refresh() {
		removeAllRows();
		ucitajSvaPitanja();
		
		cbbID.removeAllItems();
		PitanjeDao pdao = PitanjeDao.get();
		if (trenutniKvizID != -1)
			for(long id : pdao .DajSveIdZaKviz(trenutniKvizID))
				cbbID.addItem((int)id);
		
		contentPane.revalidate();
	    contentPane.repaint();
	}
}
