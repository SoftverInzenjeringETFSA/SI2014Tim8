package helloworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class DodavanjeAdministratora {

	private JFrame frmDodavanjeAdministratora;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeAdministratora window = new DodavanjeAdministratora();
					window.frmDodavanjeAdministratora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeAdministratora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeAdministratora = new JFrame();
		frmDodavanjeAdministratora.setTitle("Dodavanje administratora");
		frmDodavanjeAdministratora.setBounds(100, 100, 430, 480);
		frmDodavanjeAdministratora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeAdministratora.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frmDodavanjeAdministratora.setJMenuBar(menuBar);
		
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
		
		JPanel panel = new JPanel();
		frmDodavanjeAdministratora.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Li\u010Dni podaci", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(30, 139, 350, 200);
		panel.add(panel_2);
		
		JLabel label_2 = new JLabel("Prezime:");
		label_2.setBounds(30, 62, 50, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Ime:");
		label_3.setBounds(30, 37, 52, 14);
		panel_2.add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 34, 200, 20);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 59, 200, 20);
		panel_2.add(textField_1);
		
		JLabel label_4 = new JLabel("Telefon:");
		label_4.setBounds(30, 140, 50, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Adresa:");
		label_5.setBounds(30, 115, 52, 14);
		panel_2.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 112, 200, 20);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(120, 137, 200, 20);
		panel_2.add(textField_3);
		
		JLabel label_6 = new JLabel("Spol:");
		label_6.setBounds(30, 87, 50, 14);
		panel_2.add(label_6);
		
		JRadioButton radioButton = new JRadioButton("Mu\u0161ki");
		radioButton.setBounds(120, 83, 52, 23);
		panel_2.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u017Denski");
		radioButton_1.setBounds(174, 83, 64, 23);
		panel_2.add(radioButton_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(120, 162, 200, 20);
		panel_2.add(textField_4);
		
		JLabel label_7 = new JLabel("Email:");
		label_7.setBounds(30, 165, 50, 14);
		panel_2.add(label_7);
		
		JButton btnObriiKlijenta = new JButton("Dodaj administratora");
		btnObriiKlijenta.setBounds(230, 350, 150, 23);
		panel.add(btnObriiKlijenta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o korisni\u010Dkom ra\u010Dunu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(30, 31, 350, 90);
		panel.add(panel_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 57, 50, 14);
		panel_1.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(30, 32, 52, 14);
		panel_1.add(lblUsername);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(120, 29, 200, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(120, 54, 200, 20);
		panel_1.add(textField_6);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmDodavanjeAdministratora.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
}

