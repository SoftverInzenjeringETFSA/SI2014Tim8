package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class LoginAdmin extends JFrame {

	//TODO: Dodati dugme vrati se nazad
	
	private JPanel contentPane;
	private JTextField textField;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnPomo;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginAdmin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mnPomo = new JMenu("Pomo\u0107");
		menuBar.add(mnPomo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{20, 0, 0, 20};
		gbl_contentPane.rowHeights = new int[]{20, 0, 0, 0, 20, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		GridBagConstraints gbc_lblKorisnikoIme = new GridBagConstraints();
		gbc_lblKorisnikoIme.anchor = GridBagConstraints.EAST;
		gbc_lblKorisnikoIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblKorisnikoIme.gridx = 1;
		gbc_lblKorisnikoIme.gridy = 1;
		contentPane.add(lblKorisnikoIme, gbc_lblKorisnikoIme);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		GridBagConstraints gbc_lblLozinka = new GridBagConstraints();
		gbc_lblLozinka.anchor = GridBagConstraints.EAST;
		gbc_lblLozinka.insets = new Insets(0, 0, 5, 5);
		gbc_lblLozinka.gridx = 1;
		gbc_lblLozinka.gridy = 3;
		contentPane.add(lblLozinka, gbc_lblLozinka);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		contentPane.add(passwordField, gbc_passwordField);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				JOptionPane.showMessageDialog(null,"Username koji ste unijeli je: " + textField.getText() + ", a password je: " + passwordField.getPassword() + " ... vec hashiran","Porukica",JOptionPane.WARNING_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnPotvrdi = new GridBagConstraints();
		gbc_btnPotvrdi.gridx = 2;
		gbc_btnPotvrdi.gridy = 5;
		gbc_btnPotvrdi.anchor = GridBagConstraints.SOUTHEAST;
		contentPane.add(btnPotvrdi, gbc_btnPotvrdi);
	}

}
