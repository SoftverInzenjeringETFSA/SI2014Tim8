package ba.tim8.kvizbiz.forme;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.BorderLayout;

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


import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Spol;
import net.miginfocom.swing.MigLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromjenaLicnihPodataka extends JFrame {

	//TODO: Rename textField u smislene nazive
	
	private JFrame frmPromjenaLicnihPodataka;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblStatus;

	
	public JFrame get_frmPromjenaLicnihPodataka () {
		return frmPromjenaLicnihPodataka;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromjenaLicnihPodataka window = new PromjenaLicnihPodataka();
					window.frmPromjenaLicnihPodataka.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/* Za kad budes imao administratora
	public PromjenaLicnihPodataka(Administrator logiraniAdministrator) {
		initialize();
		logiraniAdministrator.get_id();
	}
	*/
	
	public PromjenaLicnihPodataka() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPromjenaLicnihPodataka = new JFrame();
		frmPromjenaLicnihPodataka.setTitle("Promjena li\u010Dnih podataka");
		frmPromjenaLicnihPodataka.setBounds(100, 100, 600, 500);
		frmPromjenaLicnihPodataka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPromjenaLicnihPodataka.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmPromjenaLicnihPodataka);
		
		lblStatus = new JLabel("Uredu");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmPromjenaLicnihPodataka.getContentPane().add(lblStatus, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		frmPromjenaLicnihPodataka.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow]", "[grow][20px]"));
		
		JButton btnPromjeniLinePodatke = new JButton("Promjeni li\u010Dnih podatke");
		panel.add(btnPromjeniLinePodatke, "cell 0 1,alignx right,aligny center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Li\u010Dni podaci", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[grow][fill][fill][150px][grow]", "[fill][fill][fill][fill][fill][fill][fill]"));
		
		JLabel label = new JLabel("Prezime:");
		label.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label, "cell 0 1,growx,aligny center");
		
		JLabel label_1 = new JLabel("Ime:");
		label_1.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_1, "cell 0 0,growx,aligny center");
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_1.add(textField, "cell 1 0 3 1,growx,aligny top");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1, "cell 1 1 3 1,growx,aligny top");
		
		JLabel label_2 = new JLabel("Datum rođenja:");
		label_2.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_2, "cell 0 4,growx,aligny center");
		
		JLabel label_3 = new JLabel("Adresa:");
		label_3.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_3, "cell 0 3,growx,aligny center");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_1.add(textField_2, "cell 1 3 3 1,growx,aligny top");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_1.add(textField_3, "cell 1 4 3 1,growx,aligny top");
		
		JLabel label_4 = new JLabel("Spol:");
		label_4.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_4, "cell 0 2,growx,aligny top");
		
		final JRadioButton radioButton = new JRadioButton("Muški");
		panel_1.add(radioButton, "cell 1 2,growx,aligny top");
		
		final JRadioButton radioButton_1 = new JRadioButton("Ženski");
		panel_1.add(radioButton_1, "cell 3 2,alignx left,aligny top");
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_1.add(textField_4, "cell 1 5 3 1,growx,aligny top");
		
		JLabel label_5 = new JLabel("Email:");
		label_5.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_5, "cell 0 5,growx,aligny center");
		
		JLabel label_6 = new JLabel("Telefon:");
		label_6.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_6, "cell 0 6,growx,aligny center");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_1.add(textField_5, "cell 1 6 3 1,grow");
			
		/*JButton btnNewButton = new JButton("Uredu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmPromjenaLicnihPodataka.getContentPane().add(btnNewButton, BorderLayout.SOUTH);*/
		
		final AdministratorDao adao = AdministratorDao.get();
		Collection<Administrator> administratori = adao.readAll();
		
		 
		AdministratorDao administratordao = AdministratorDao.get();
		String neki = LoginAdmina.usernameLogiranogAdmina;
		Collection<Administrator> administrator = administratordao.dajPoUsernamu(neki);
		Administrator trazeniAdministrator = new Administrator();
		for (Iterator<Administrator> iterator = administrator.iterator(); iterator
				.hasNext();) {
			trazeniAdministrator = (Administrator) iterator.next();
		}
		textField.setText(trazeniAdministrator.get_ime());
		textField_1.setText(trazeniAdministrator.get_prezime());
		textField_2.setText(trazeniAdministrator.get_adresa());
		textField_3.setText(trazeniAdministrator.get_datumRodjenja()
				.toString().substring(0, 10));
		textField_4.setText(trazeniAdministrator.get_eMail());
		textField_5.setText(trazeniAdministrator.get_telefon());
		
		if (trazeniAdministrator.get_spol() == Spol.muski)
			radioButton.setSelected(true);
		else
			radioButton_1.setSelected(true);		
		
		
		 	 
		btnPromjeniLinePodatke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean dodaj = true;
				
			    AdministratorDao administratordao = AdministratorDao.get();
				String neki = LoginAdmina.usernameLogiranogAdmina;
				Collection<Administrator> administrator = administratordao.dajPoUsernamu(neki);
		        Administrator trazeniAdministrator = new Administrator();
		         for (Iterator<Administrator> iterator = administrator.iterator(); iterator
				      .hasNext();) {
			       trazeniAdministrator = (Administrator) iterator.next();
		        }
		  
		      // telefon validacija
					if (textField_5.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Telefon mora biti popunjeno");
						lblStatus.setForeground(Color.red);
						
					} else {
						String regx = "^[0-9]*$";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textField_5.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Telefon mora sadržavati samo brojeve!");
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
							lblStatus.setText("Polje Email mora biti u pravilnom formatu!");
							lblStatus.setForeground(Color.red);
							
						}
					}
 
					

					// datum rodjenja validacija
					if (textField_3.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Datum rođenja mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					} else {
						String regx = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textField_3.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Datum rođenja mora biti u formatu yyyy-mm-dd(2015-01-01)!");
							lblStatus.setForeground(Color.red);

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

					} else {
						String regx = "[a-zA-Z]+\\.?";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textField_1.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Prezime mora sadržavati samo slova!");
							lblStatus.setForeground(Color.red);
						}
					}
					
					// ime validacija
					if (textField.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Ime mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					} else {
						String regx = "[a-zA-Z]+\\.?";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textField.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Ime mora sadržavati samo slova!");
							lblStatus.setForeground(Color.red);

						}
					}

					DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
					if (dodaj == true) {
						if (radioButton.isSelected()) 
							trazeniAdministrator.set_spol(Spol.muski);
						else if(radioButton_1.isSelected())
							trazeniAdministrator.set_spol(Spol.zenski);
						trazeniAdministrator.set_ime(textField.getText());
						trazeniAdministrator.set_prezime(textField_1.getText());
						try {
							trazeniAdministrator.set_datumRodjenja(format.parse(textField_3.getText()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						trazeniAdministrator.set_adresa(textField_2.getText());
						trazeniAdministrator.set_eMail(textField_4.getText());
						trazeniAdministrator.set_telefon(textField_5.getText());
						adao.update(trazeniAdministrator);
						lblStatus.setText("Uredu");
						lblStatus.setForeground(Color.blue);
						int rezultatDijaloga = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite promijeniti podatke " , "Promjena ličnih podataka", JOptionPane.YES_NO_OPTION);
						if (rezultatDijaloga == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null,
								"Podaci su uspješno promijenjeni!",
								"Promjena licnih podataka",
								JOptionPane.INFORMATION_MESSAGE);
						PromjenaLicnihPodataka noviProzor = new PromjenaLicnihPodataka();
						JFrame noviFrame = noviProzor.get_frmPromjenaLicnihPodataka();
						noviFrame.setVisible(true);
						frmPromjenaLicnihPodataka.dispose();
						}
					}
				}
			});
	}
}
