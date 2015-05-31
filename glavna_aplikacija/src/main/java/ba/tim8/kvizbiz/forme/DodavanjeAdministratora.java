package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JPasswordField;

import org.apache.log4j.Logger;
import javax.swing.JFormattedTextField;

public class DodavanjeAdministratora extends JFrame {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(DodavanjeAdministratora.class);
	private JFrame frmDodavanjeAdministratora;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JLabel lblStatus;
	private JPasswordField passwordField;

	public JFrame get_frmDodavanjeAdministratora() {
		return frmDodavanjeAdministratora;
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
		frmDodavanjeAdministratora.setResizable(false);
		frmDodavanjeAdministratora.setLocationRelativeTo(null);
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

		passwordField = new JPasswordField();
		passwordField.setBounds(135, 54, 230, 20);
		panel_1.add(passwordField);

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
		frmDodavanjeAdministratora.getContentPane().add(lblStatus,
				BorderLayout.SOUTH);

		btnObriiKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministratorDao adao = AdministratorDao.get();
				boolean dodaj = true;

				// telefon validacija
				if (textField_7.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje Telefon mora biti popunjeno!");
					lblStatus.setForeground(Color.red);

				} else{
					String regx = "^[0-9]*$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_7.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus
								.setText("Polje Telefon mora sadržavati samo brojeve!");
						lblStatus.setForeground(Color.red);

					}
					else if(textField_7.getText().length()<6 || textField_7.getText().length()>13)
					{
						dodaj = false;
						lblStatus
								.setText("Polje Telefon mora sadržavati između 6 i 13 cifara!");
						lblStatus.setForeground(Color.red);
					}
				}
				
				

				// email validacija
				if (textField_4.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje Email mora biti popunjeno!");
					lblStatus.setForeground(Color.red);
				} else {
					String regx = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_4.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus
								.setText("Polje Email mora biti u pravilnom formatu!");
						lblStatus.setForeground(Color.red);
					}
				}

				// datum rodjenja validacija
				if (textField_3.getText().isEmpty()) {
					dodaj = false;
					lblStatus
							.setText("Polje Datum rođenja mora biti popunjeno!");
					lblStatus.setForeground(Color.red);
				} else {
					String regx = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_3.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus.setText("Polje Datum rođenja mora biti ispravno i u formatu yyyy-mm-dd(2015-01-01)!");
						lblStatus.setForeground(Color.red);
					} else {
						ZonedDateTime danasnji = ZonedDateTime.now();
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						try {
							Date uneseni = sdf.parse(textField_3.getText());
							Date sadasnji = sdf.parse(danasnji.toString());

							if (uneseni.after(sadasnji)) {

								dodaj = false;
								lblStatus
										.setText("Polje Datum rođenja ne smije biti veće od današnjeg dana!");
								lblStatus.setForeground(Color.red);
							}
						} catch (ParseException e1) {
							logger.error("Greska: ", e1);
						}
					}
				}

				// adresa samo ne smije bit prazna
				if (textField_2.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje Adresa mora biti popunjeno!");
					lblStatus.setForeground(Color.red);
				}

				// prezime validacija
				if (textField_1.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje Prezime mora biti popunjeno!");
					lblStatus.setForeground(Color.red);
				} 
				else if(textField_1.getText().length()<3){
					dodaj=false;
					lblStatus.setText("Polje Prezime mora sadržavati barem 3 slova!");
					lblStatus.setForeground(Color.red);
					
				}
				else {
					String regx = "^[\\a-žA-Ž .'-]+$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_1.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus
								.setText("Polje Prezime mora sadržavati samo slova!");
						lblStatus.setForeground(Color.red);
					}
				}

				// ime validacija
				if (textField.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje Ime mora biti popunjeno!");
					lblStatus.setForeground(Color.red);
				} 
				else if(textField.getText().length()<2){
					dodaj=false;
					lblStatus.setText("Polje Ime mora sadržavati barem 2 slova!");
					lblStatus.setForeground(Color.red);
					
				}
				else {
					String regx = "^[\\a-žA-Ž .'-]+$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField.getText());
					if (!matcher.matches()) {
						dodaj = false;
						lblStatus
								.setText("Polje Ime mora sadržavati samo slova!");
						lblStatus.setForeground(Color.red);
					}
				}

				// password valdiacija
				if (passwordField.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje Password mora biti popunjeno!");
				}

				// username validacija
				if (textField_5.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje Username mora biti popunjeno!");
				} else if (adao.pretraziPoUsernamu(textField_5.getText())) {
					dodaj = false;
					lblStatus.setText("Polje Username mora biti jedinstveno!");
				}
				
				
				if (dodaj == true) {
					JOptionPane.showMessageDialog(null,
							"Administrator je uspješno dodan!",
							"Dodavanje administratora",
							JOptionPane.INFORMATION_MESSAGE);
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					if (radioButton.isSelected()) {
						try {
							Administrator a = new Administrator((long) 2,
									textField.getText(), textField_1.getText(),
									Spol.muski, textField_2.getText(), format
											.parse(textField_3.getText()),
									textField_7.getText(), textField_4
											.getText(), textField_5.getText(),
									passwordField.getText());
							adao.create(a);
							adao.updatePass(a);						
						} catch (ParseException e1) {
							logger.error("Greska: ", e1);
						}

					} else {

						try {
							Administrator a = new Administrator((long) 1,
									textField.getText(), textField_1.getText(),
									Spol.zenski, textField_2.getText(), format
											.parse(textField_3.getText()),
									textField_7.getText(), textField_4
											.getText(), textField_5.getText(),
									passwordField.getText());
							adao.create(a);
							adao.updatePass(a);
						} catch (Exception e1) {
							logger.error("Greska: ", e1);
						}

					}
					DodavanjeAdministratora noviProzor = new DodavanjeAdministratora();
					JFrame noviFrame = noviProzor
							.get_frmDodavanjeAdministratora();
					noviFrame.setVisible(true);
					frmDodavanjeAdministratora.dispose();
				}
			}
		});
	}
}