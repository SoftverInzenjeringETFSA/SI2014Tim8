package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Spol;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DodavanjeAdministratora extends JFrame {

	private JFrame frmDodavanjeAdministratora;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JLabel lblStatus;

	public JFrame get_frmDodavanjeAdministratora() {
		return frmDodavanjeAdministratora;
	}

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
		frmDodavanjeAdministratora.setBounds(100, 100, 470, 510);
		frmDodavanjeAdministratora
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeAdministratora.getContentPane().setLayout(
				new BorderLayout(0, 0));

		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmDodavanjeAdministratora);

		JPanel panel = new JPanel();
		frmDodavanjeAdministratora.getContentPane().add(panel,
				BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnObriiKlijenta = new JButton("Dodaj administratora");
		btnObriiKlijenta.setBounds(240, 380, 180, 23);
		panel.add(btnObriiKlijenta);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Podaci o korisni\u010Dkom ra\u010Dunu", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(30, 30, 390, 90);
		panel.add(panel_1);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 57, 70, 14);
		panel_1.add(lblPassword);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(30, 32, 70, 14);
		panel_1.add(lblUsername);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(135, 29, 230, 20);
		panel_1.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(135, 54, 230, 20);
		panel_1.add(textField_6);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Li\u010Dni podaci",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(30, 140, 390, 230);
		panel.add(panel_2);

		JLabel label = new JLabel("Prezime:");
		label.setBounds(30, 62, 90, 14);
		panel_2.add(label);

		JLabel label_1 = new JLabel("Ime:");
		label_1.setBounds(30, 37, 90, 14);
		panel_2.add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(135, 34, 230, 20);
		panel_2.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 59, 230, 20);
		panel_2.add(textField_1);

		JLabel label_2 = new JLabel("Datum ro\u0111enja:");
		label_2.setBounds(30, 140, 90, 14);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Adresa:");
		label_3.setBounds(30, 115, 90, 14);
		panel_2.add(label_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 112, 230, 20);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 137, 230, 20);
		panel_2.add(textField_3);

		JLabel label_4 = new JLabel("Spol:");
		label_4.setBounds(30, 87, 90, 14);
		panel_2.add(label_4);

		final JRadioButton radioButton = new JRadioButton("Mu\u0161ki");
		radioButton.setSelected(true);
		radioButton.setBounds(135, 83, 71, 23);
		panel_2.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("\u017Denski");
		radioButton_1.setBounds(225, 82, 78, 23);
		panel_2.add(radioButton_1);

		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(135, 162, 230, 20);
		panel_2.add(textField_4);

		JLabel label_5 = new JLabel("Email:");
		label_5.setBounds(30, 165, 90, 14);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel("Telefon:");
		label_6.setBounds(30, 191, 90, 14);
		panel_2.add(label_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(135, 188, 230, 20);
		panel_2.add(textField_7);

		lblStatus = new JLabel("Uredu");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmDodavanjeAdministratora.getContentPane().add(lblStatus, BorderLayout.SOUTH);

		btnObriiKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratorDao adao = new AdministratorDao();
				boolean dodaj = true;

				// username validacija
				if (textField_5.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Username mora biti popunjeno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				} else if (adao.pretraziPoUsernamu(textField_5.getText())) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Username mora biti jedinstveno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				}

				// password valdiacija
				if (textField_6.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Password mora biti popunjeno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				}

				// ime validacija
				if (textField.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Ime mora biti popunjeno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String regx = "[a-zA-Z]+\\.?";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus.setText("Greska");
						JOptionPane
								.showMessageDialog(
										null,
										"Polje Ime mora sadržavati samo slova!",
										"Dodavanje administratora",
										JOptionPane.ERROR_MESSAGE);
					}
				}

				// prezime validacija
				if (textField_1.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Prezime mora biti popunjeno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String regx = "[a-zA-Z]+\\.?";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_1.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus.setText("Greska");
						JOptionPane
								.showMessageDialog(
										null,
										"Polje Prezime mora sadržavati samo slova!",
										"Dodavanje administratora",
										JOptionPane.ERROR_MESSAGE);
					}
				}

				// adresa samo ne smije bit prazna
				if (textField_2.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Adresa mora biti popunjeno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				}

				// datum rodjenja validacija
				if (textField_3.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Datum rođenja mora biti popunjeno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String regx = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_3.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus.setText("Greska");
						JOptionPane
								.showMessageDialog(
										null,
										"Polje Datum rođenja mora biti u formatu yyyy-mm-dd(2015-01-01)!",
										"Dodavanje administratora",
										JOptionPane.ERROR_MESSAGE);
					}
				}

				// email validacija
				if (textField_4.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Email mora biti popunjeno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String regx = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_4.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus.setText("Greska");
						JOptionPane.showMessageDialog(null,
								"Polje Email mora biti u pravilnom formatu!",
								"Dodavanje administratora",
								JOptionPane.ERROR_MESSAGE);
						;
					}
				}

				// telefon validacija
				if (textField_7.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Telefon mora biti popunjeno!",
							"Dodavanje administratora",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					String regx = "^[0-9]*$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_7.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus.setText("Greska");
						JOptionPane.showMessageDialog(null,
								"Polje Telefon mora sadržavati samo brojeve!",
								"Dodavanje administratora",
								JOptionPane.ERROR_MESSAGE);
						;
					}
				}
				
				
				
				
				if (dodaj == true) {
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					if (radioButton.isSelected()) {
						try {
							Administrator a = new Administrator((long) 2,
									textField.getText(), textField_1.getText(),
									Spol.muski, textField_2.getText(), format
											.parse(textField_4.getText()),
									textField_3.getText(), textField_7
											.getText(), textField_5.getText(),
									textField_6.getText());
							adao.create(a);
							JOptionPane.showMessageDialog(null,
									"Administrator je uspješno dodan!",
									"Dodavanje administratora",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}

					} else {

						try {
							Administrator a = new Administrator((long)1,
									textField.getText(), textField_1.getText(),
									Spol.zenski, textField_2.getText(), format
											.parse(textField_3.getText()),
									textField_4.getText(), textField_7
											.getText(), textField_5.getText(),
									textField_6.getText());
							adao.create(a);
							JOptionPane.showMessageDialog(null,
									"Administrator je uspješno dodan!",
									"Dodavanje administratora",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e1) {
							
						}

					}
					DodavanjeAdministratora noviProzor = new DodavanjeAdministratora();
					JFrame noviFrame = noviProzor.get_frmDodavanjeAdministratora();
					noviFrame.setVisible(true);
					frmDodavanjeAdministratora.dispose();
				}
			}
		});
	}
}		
