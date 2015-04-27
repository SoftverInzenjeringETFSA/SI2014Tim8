package my.kvizbiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javafx.scene.paint.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.GridBagLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JTable;

public class KreiranjeAnkete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tblPitanja;

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
		setBounds(100, 100, 569, 401);
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 533, 99);
		panel.setBorder(new TitledBorder(null, "Unesite osnovne podatke:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(153, 31, 144, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(102, 34, 41, 14);
		panel.add(lblNaziv);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinner.setBounds(153, 62, 76, 20);
		panel.add(spinner);
		
		JLabel lblVremeskoOgranienje = new JLabel("Vremesko ograni\u010Denje:");
		lblVremeskoOgranienje.setBounds(10, 65, 133, 14);
		panel.add(lblVremeskoOgranienje);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(448, 307, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btnOtkazi = new JButton("Otka\u017Ei");
		btnOtkazi.setBounds(349, 307, 89, 23);
		getContentPane().add(btnOtkazi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Unesite pitanja:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 121, 533, 175);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		// Testni podaci
		Object[] naziviKolona = new Object[]{"Broj", "Tekst", "Tip"};
		Object[][] podaci = new Object[][]{
				{new Integer(1), "Koliko je 2+2?", "Ponuðeni odgovori"},
				{new Integer(2), "Šta je polimorfizam?", "Otvoren odgovor"}
		};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(podaci, naziviKolona);
		
		JButton btnDodajNovo = new JButton("Dodaj novo");
		btnDodajNovo.setBounds(10, 30, 155, 23);
		panel_1.add(btnDodajNovo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 25, 348, 139);
		panel_1.add(scrollPane);
		
		tblPitanja = new JTable(model);
		tblPitanja.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane.setViewportView(tblPitanja);
		
		JButton btnObrisiOznaceno = new JButton("Obrisi oznaceno");
		btnObrisiOznaceno.setBounds(10, 64, 155, 23);
		panel_1.add(btnObrisiOznaceno);
		
		JButton btnPromjeniOznaceno = new JButton("Promjeni oznaceno");
		btnPromjeniOznaceno.setBounds(10, 98, 155, 23);
		panel_1.add(btnPromjeniOznaceno);
	}
}
