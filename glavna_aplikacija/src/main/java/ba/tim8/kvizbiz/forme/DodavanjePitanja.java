package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class DodavanjePitanja extends JFrame {

	private JFrame frmDodavanjePitanja;
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
					DodavanjePitanja window = new DodavanjePitanja();
					window.frmDodavanjePitanja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjePitanja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjePitanja = new JFrame();
		frmDodavanjePitanja.setTitle("Dodavanje pitanja");
		frmDodavanjePitanja.setBounds(100, 100, 490, 447);
		frmDodavanjePitanja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjePitanja.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmDodavanjePitanja);		
		
		JPanel panel1 = new JPanel();
		frmDodavanjePitanja.getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Unesite podatke o pitanju:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 30, 420, 280);
		panel1.add(panel);
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
		panel_1.setBorder(new TitledBorder(null, "Unesite novo pitanje s ponu\u0111enim odgovorima:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 107, 400, 160);
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
		btnOk.setBounds(360, 321, 90, 23);
		panel1.add(btnOk);
		
		JButton btnOtkai = new JButton("Otka\u017Ei");
		btnOtkai.setBounds(260, 321, 90, 23);
		panel1.add(btnOtkai);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setEnabled(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		frmDodavanjePitanja.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}

}
