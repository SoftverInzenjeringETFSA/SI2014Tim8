package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
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
		
		// Testni podaci
		Object[] naziviKolona = new Object[]{"Broj", "Tekst", "Tip"};
		Object[][] podaci = new Object[][]{
				{new Integer(1), "Koliko je 2+2?", "Ponu�eni odgovori"},
				{new Integer(2), "šta je polimorfizam?", "Otvoren odgovor"}
		};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(podaci, naziviKolona);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 25, 348, 139);
		pnlPitanja.add(scrollPane, "cell 1 0 1 5,growx");
		
		tblPitanja = new JTable(model);
		tblPitanja.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane.setViewportView(tblPitanja);
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
	}

}
