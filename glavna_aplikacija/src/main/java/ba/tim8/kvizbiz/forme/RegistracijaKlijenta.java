package ba.tim8.kvizbiz.forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class RegistracijaKlijenta {

	public JFrame frmRegistracijaKlijenta;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtJmbg;
	private JTextField txtEmail;
	private JTextField txtBrojTelefona;
	private JTextField txtAdresa;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistracijaKlijenta window = new RegistracijaKlijenta();
					window.frmRegistracijaKlijenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public RegistracijaKlijenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistracijaKlijenta = new JFrame();
		frmRegistracijaKlijenta.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MuhamedMujic\\Desktop\\ikonaKviz.png"));
		frmRegistracijaKlijenta.setTitle("Registracija klijenta");
		frmRegistracijaKlijenta.setBounds(100, 100, 450, 386);
		frmRegistracijaKlijenta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistracijaKlijenta.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelRegistracija = new JPanel();
		panelRegistracija.setBorder(new TitledBorder(null, "Registracija", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		SpringLayout sl_panelRegistracija = new SpringLayout();
		panelRegistracija.setLayout(sl_panelRegistracija);
		
		JLabel lblIme = new JLabel("Ime:");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, lblIme, 40, SpringLayout.NORTH, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, lblIme, 121, SpringLayout.WEST, panelRegistracija);
		panelRegistracija.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, lblPrezime, 17, SpringLayout.SOUTH, lblIme);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, lblPrezime, 102, SpringLayout.WEST, panelRegistracija);
		panelRegistracija.add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, lblJmbg, 20, SpringLayout.SOUTH, lblPrezime);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, lblJmbg, 113, SpringLayout.WEST, panelRegistracija);
		panelRegistracija.add(lblJmbg);
		
		JLabel lblEmail = new JLabel("E-mail:");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, lblEmail, 19, SpringLayout.SOUTH, lblJmbg);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, lblEmail, 111, SpringLayout.WEST, panelRegistracija);
		panelRegistracija.add(lblEmail);
		
		txtIme = new JTextField();
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, txtIme, -3, SpringLayout.NORTH, lblIme);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, txtIme, -99, SpringLayout.EAST, panelRegistracija);
		panelRegistracija.add(txtIme);
		txtIme.setColumns(10);
		
		txtPrezime = new JTextField();
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, txtIme, 0, SpringLayout.WEST, txtPrezime);
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, txtPrezime, 68, SpringLayout.NORTH, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, txtPrezime, 161, SpringLayout.WEST, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, txtPrezime, -99, SpringLayout.EAST, panelRegistracija);
		panelRegistracija.add(txtPrezime);
		txtPrezime.setColumns(10);
		
		txtJmbg = new JTextField();
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, txtJmbg, -3, SpringLayout.NORTH, lblJmbg);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, txtJmbg, 161, SpringLayout.WEST, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, txtJmbg, -99, SpringLayout.EAST, panelRegistracija);
		panelRegistracija.add(txtJmbg);
		txtJmbg.setColumns(10);
		
		txtEmail = new JTextField();
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, txtEmail, -3, SpringLayout.NORTH, lblEmail);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, txtEmail, 161, SpringLayout.WEST, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, txtEmail, -99, SpringLayout.EAST, panelRegistracija);
		panelRegistracija.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, lblBrojTelefona, 22, SpringLayout.SOUTH, lblEmail);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, lblBrojTelefona, 77, SpringLayout.WEST, panelRegistracija);
		panelRegistracija.add(lblBrojTelefona);
		
		txtBrojTelefona = new JTextField();
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, txtBrojTelefona, 0, SpringLayout.NORTH, lblBrojTelefona);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, txtBrojTelefona, 161, SpringLayout.WEST, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, txtBrojTelefona, -99, SpringLayout.EAST, panelRegistracija);
		panelRegistracija.add(txtBrojTelefona);
		txtBrojTelefona.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, lblAdresa, 0, SpringLayout.EAST, lblIme);
		panelRegistracija.add(lblAdresa);
		
		txtAdresa = new JTextField();
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, txtAdresa, 161, SpringLayout.WEST, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, txtAdresa, -99, SpringLayout.EAST, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, lblAdresa, 3, SpringLayout.NORTH, txtAdresa);
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, txtAdresa, 12, SpringLayout.SOUTH, txtBrojTelefona);
		panelRegistracija.add(txtAdresa);
		txtAdresa.setColumns(10);
		
		JButton btnOtkazi = new JButton("Otka\u017Ei");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, btnOtkazi, 24, SpringLayout.SOUTH, txtAdresa);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, btnOtkazi, -99, SpringLayout.EAST, panelRegistracija);
		panelRegistracija.add(btnOtkazi);
		
		JButton btnRegistrujSe = new JButton("Registruj se");
		btnRegistrujSe.setMargin(new Insets(2, 5, 2, 5));
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, btnRegistrujSe, -204, SpringLayout.EAST, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, btnOtkazi, 8, SpringLayout.EAST, btnRegistrujSe);
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, btnRegistrujSe, 0, SpringLayout.NORTH, btnOtkazi);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, btnRegistrujSe, 0, SpringLayout.WEST, lblIme);
		panelRegistracija.add(btnRegistrujSe);
		frmRegistracijaKlijenta.getContentPane().add(panelRegistracija);
		
		JLabel lblpoljeJeObavezno = new JLabel("*Polje je obavezno");
		sl_panelRegistracija.putConstraint(SpringLayout.SOUTH, lblpoljeJeObavezno, 0, SpringLayout.SOUTH, panelRegistracija);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, lblpoljeJeObavezno, -156, SpringLayout.EAST, panelRegistracija);
		lblpoljeJeObavezno.setForeground(new Color(255, 0, 0));
		panelRegistracija.add(lblpoljeJeObavezno);
		
		JSeparator separator = new JSeparator();
		sl_panelRegistracija.putConstraint(SpringLayout.SOUTH, separator, -6, SpringLayout.NORTH, lblpoljeJeObavezno);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, separator, -175, SpringLayout.EAST, panelRegistracija);
		panelRegistracija.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, separator_1, 0, SpringLayout.EAST, txtIme);
		separator_1.setPreferredSize(new Dimension(200, 2));
		sl_panelRegistracija.putConstraint(SpringLayout.SOUTH, separator_1, -6, SpringLayout.NORTH, lblpoljeJeObavezno);
		panelRegistracija.add(separator_1);
		
		JLabel label = new JLabel("*");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, label, -2, SpringLayout.NORTH, lblIme);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, label, -1, SpringLayout.WEST, lblPrezime);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, lblIme);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setForeground(new Color(255, 0, 0));
		panelRegistracija.add(label);
		
		JLabel label_1 = new JLabel("*");
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, lblAdresa, 0, SpringLayout.WEST, label_1);
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, lblPrezime);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, label_1, -6, SpringLayout.WEST, lblPrezime);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelRegistracija.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, lblJmbg);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, label_2, -6, SpringLayout.WEST, lblJmbg);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelRegistracija.add(label_2);
		
		JLabel label_3 = new JLabel("*");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, txtEmail);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, label_3, -6, SpringLayout.WEST, lblEmail);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelRegistracija.add(label_3);
	}
}
