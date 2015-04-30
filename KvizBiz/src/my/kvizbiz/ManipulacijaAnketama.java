package my.kvizbiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ManipulacijaAnketama extends JFrame {

	private JPanel contentPane;
	private JTable tblAnkete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManipulacijaAnketama frame = new ManipulacijaAnketama();
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
	public ManipulacijaAnketama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdmnistratori = new JMenu("Administratori");
		menuBar.add(mnAdmnistratori);
		
		JMenuItem mntmDodavanjeAdministratora = new JMenuItem("Dodavanje");
		mnAdmnistratori.add(mntmDodavanjeAdministratora);
		
		JMenuItem mntmBrisanjeAdministratora = new JMenuItem("Brisanje");
		mnAdmnistratori.add(mntmBrisanjeAdministratora);
		
		JMenuItem mntmPregledAdministratora = new JMenuItem("Pregled");
		mnAdmnistratori.add(mntmPregledAdministratora);
		
		JMenu mnKlijenti = new JMenu("Klijenti");
		menuBar.add(mnKlijenti);
		
		JMenuItem mntmPromjenaKlijenta = new JMenuItem("Promjena");
		mnKlijenti.add(mntmPromjenaKlijenta);
		
		JMenuItem mntmBrisanjeKlijenta = new JMenuItem("Brisanje");
		mnKlijenti.add(mntmBrisanjeKlijenta);
		
		JMenuItem mntmPregledKlijenata = new JMenuItem("Pregled");
		mnKlijenti.add(mntmPregledKlijenata);
		
		JMenu mnAnkete = new JMenu("Ankete");
		menuBar.add(mnAnkete);
		
		JMenuItem mntmDodavanje = new JMenuItem("Dodavanje");
		mnAnkete.add(mntmDodavanje);
		
		JMenuItem mntmManipulacija = new JMenuItem("Manipulacija");
		mnAnkete.add(mntmManipulacija);
		
		JMenu mnStatistika = new JMenu("Statistika");
		menuBar.add(mnStatistika);
		
		JMenu mnProfil = new JMenu("Profil");
		menuBar.add(mnProfil);
		
		JMenuItem mntmPromjenaLicnihPodataka = new JMenuItem("Promjena li\u010Dnih podataka");
		mnProfil.add(mntmPromjenaLicnihPodataka);
		
		JMenuItem mntmPromjenaPassworda = new JMenuItem("Promjena passworda");
		mnProfil.add(mntmPromjenaPassworda);
		
		JMenuItem mntmOdjava = new JMenuItem("Odjava");
		mnProfil.add(mntmOdjava);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ozna\u010Dite akciju i manipuli\u0161ite anketama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 579, 282);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 26, 402, 245);
		panel.add(scrollPane);
		
		// Testni podaci
		Object[] naziviKolona = new Object[]{"Broj", "Naziv", "Stats", "Broj pitanja", "Ogranièenjes"};
		Object[][] podaci = new Object[][]{
				{new Integer(1), "Studentska", "Arhivirana", "10", "10"},
				{new Integer(2), "Programiranje", "Otvorena", "12", "15"}
		};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(podaci, naziviKolona);
		
		tblAnkete = new JTable(model);
		tblAnkete.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane.setViewportView(tblAnkete);
		
		JButton btnObriiOznaenu = new JButton("Obri\u0161i ozna\u010Denu");
		btnObriiOznaenu.setBounds(10, 92, 147, 23);
		panel.add(btnObriiOznaenu);
		
		JButton btnModifikujOznaenu = new JButton("Modifikuj ozna\u010Denu");
		btnModifikujOznaenu.setBounds(10, 126, 147, 23);
		panel.add(btnModifikujOznaenu);
		
		JButton btnArhivirajOznaenu = new JButton("Arhiviraj ozna\u010Denu");
		btnArhivirajOznaenu.setBounds(10, 160, 147, 23);
		panel.add(btnArhivirajOznaenu);
		
		JButton btnPregledajOznaenu = new JButton("Pregledaj ozna\u010Denu");
		btnPregledajOznaenu.setBounds(10, 58, 127, 23);
		panel.add(btnPregledajOznaenu);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(500, 304, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnOtkai = new JButton("Otka\u017Ei");
		btnOtkai.setBounds(401, 304, 89, 23);
		contentPane.add(btnOtkai);
	}

}
