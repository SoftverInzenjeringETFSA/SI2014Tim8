package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
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

public class PromjenaPassworda extends JFrame {

	//TODO: Rename textField u smislena imena
	
	private JFrame frmPromjenaPassworda;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public JFrame get_frmPromjenaPassworda () {
		return frmPromjenaPassworda;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromjenaPassworda window = new PromjenaPassworda();
					window.frmPromjenaPassworda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PromjenaPassworda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPromjenaPassworda = new JFrame();
		frmPromjenaPassworda.setTitle("Promjena passworda");
		frmPromjenaPassworda.setBounds(100, 100, 500, 320);
		frmPromjenaPassworda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPromjenaPassworda.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmPromjenaPassworda);
		
		JPanel panel = new JPanel();
		frmPromjenaPassworda.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o korisni\u010Dkom ra\u010Dunu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(30, 30, 430, 150);
		panel.add(panel_2);
		
		JLabel lblTrenutniPassword = new JLabel("Trenutni password:");
		lblTrenutniPassword.setBounds(30, 62, 118, 14);
		panel_2.add(lblTrenutniPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(30, 37, 118, 14);
		panel_2.add(lblUsername);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(194, 34, 210, 20);
		panel_2.add(textField);
		
		JLabel lblPonoviteNoviPassword = new JLabel("Ponovite novi password:");
		lblPonoviteNoviPassword.setBounds(30, 115, 140, 14);
		panel_2.add(lblPonoviteNoviPassword);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 59, 210, 20);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(194, 112, 210, 20);
		panel_2.add(textField_3);
		
		JLabel lblNoviPassword = new JLabel("Novi password:");
		lblNoviPassword.setBounds(30, 87, 118, 14);
		panel_2.add(lblNoviPassword);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(194, 84, 210, 20);
		panel_2.add(textField_4);
		
		
		JButton btnPromjeniLinePodatke = new JButton("Promjeni password");
		btnPromjeniLinePodatke.setBounds(280, 191, 180, 23);
		panel.add(btnPromjeniLinePodatke);
			
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmPromjenaPassworda.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	
	}
}
