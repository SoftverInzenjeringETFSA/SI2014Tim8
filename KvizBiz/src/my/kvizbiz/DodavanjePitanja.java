package my.kvizbiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class DodavanjePitanja extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjePitanja frame = new DodavanjePitanja();
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
	public DodavanjePitanja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 381);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Unesite podatke o pitanju:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTekst = new JLabel("Tekst:");
		lblTekst.setBounds(10, 28, 46, 14);
		panel.add(lblTekst);
		
		textField = new JTextField();
		textField.setBounds(66, 25, 338, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTip = new JLabel("Tip:");
		lblTip.setBounds(20, 53, 31, 14);
		panel.add(lblTip);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Uneiste novo pitanje s ponu\u0111enim odgovorima:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 107, 394, 147);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblA = new JLabel("a)");
		lblA.setBounds(33, 34, 23, 14);
		panel_1.add(lblA);
		
		JLabel lblB = new JLabel("b)");
		lblB.setBounds(33, 59, 23, 14);
		panel_1.add(lblB);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 31, 318, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 56, 318, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblC = new JLabel("c)");
		lblC.setBounds(33, 84, 23, 14);
		panel_1.add(lblC);
		
		JButton btnDodajJoOdgovora = new JButton("Dodaj jo\u0161 odgovora");
		btnDodajJoOdgovora.setBounds(33, 113, 158, 23);
		panel_1.add(btnDodajJoOdgovora);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 81, 318, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Otvoren odgovor", "Ponu\u0111eni odgovor", "Da/Ne", "Vi\u0161estruki izbor", "Ta\u010Dno/Neta\u010Dno"}));
		comboBox.setBounds(66, 50, 154, 20);
		panel.add(comboBox);
		
		JCheckBox chckbxObavezno = new JCheckBox("Obavezno");
		chckbxObavezno.setBounds(66, 77, 97, 23);
		panel.add(chckbxObavezno);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(335, 287, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnOtkai = new JButton("Otka\u017Ei");
		btnOtkai.setBounds(236, 287, 89, 23);
		contentPane.add(btnOtkai);
	}
}
