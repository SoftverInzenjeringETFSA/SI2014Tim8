package ba.tim8.kvizbiz.forme;

import java.awt.Color;
import java.awt.BorderLayout;

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

import org.apache.log4j.Logger;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Spol;
import net.miginfocom.swing.MigLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;


public class PromjenaLicnihPodataka extends JFrame {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final static Logger logger = Logger.getLogger(PromjenaLicnihPodataka.class);

	private JFrame frmPromjenaLicnihPodataka;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textAdresa;
	private JTextField textDatumRodjena;
	private JTextField textEmail;
	private JTextField textTelefon;
	private JLabel lblStatus;

	
	public JFrame get_frmPromjenaLicnihPodataka () {
		return frmPromjenaLicnihPodataka;
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
		
		textIme = new JTextField();
		textIme.setColumns(10);
		panel_1.add(textIme, "cell 1 0 3 1,growx,aligny top");
		
		textPrezime = new JTextField();
		textPrezime.setColumns(10);
		panel_1.add(textPrezime, "cell 1 1 3 1,growx,aligny top");
		
		JLabel label_2 = new JLabel("Datum rođenja:");
		label_2.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_2, "cell 0 4,growx,aligny center");
		
		JLabel label_3 = new JLabel("Adresa:");
		label_3.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_3, "cell 0 3,growx,aligny center");
		
		textAdresa = new JTextField();
		textAdresa.setColumns(10);
		panel_1.add(textAdresa, "cell 1 3 3 1,growx,aligny top");
		
		textDatumRodjena = new JTextField();
		textDatumRodjena.setColumns(10);
		panel_1.add(textDatumRodjena, "cell 1 4 3 1,growx,aligny top");
		
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
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		panel_1.add(textEmail, "cell 1 5 3 1,growx,aligny top");
		
		JLabel label_5 = new JLabel("Email:");
		label_5.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_5, "cell 0 5,growx,aligny center");
		
		JLabel label_6 = new JLabel("Telefon:");
		label_6.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_6, "cell 0 6,growx,aligny center");
		
		textTelefon= new JTextField();
		textTelefon.setColumns(10);
		panel_1.add(textTelefon, "cell 1 6 3 1,grow");
			
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
		textIme.setText(trazeniAdministrator.get_ime());
		textPrezime.setText(trazeniAdministrator.get_prezime());
		textAdresa.setText(trazeniAdministrator.get_adresa());
		textDatumRodjena.setText(trazeniAdministrator.get_datumRodjenja()
				.toString().substring(0, 10));
		textEmail.setText(trazeniAdministrator.get_eMail());
		textTelefon.setText(trazeniAdministrator.get_telefon());
		
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
					if (textTelefon.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Telefon mora biti popunjeno");
						lblStatus.setForeground(Color.red);
						
					} else {
						String regx = "^[0-9]*$";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textTelefon.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Telefon mora sadržavati samo brojeve!");
							lblStatus.setForeground(Color.red);
						
						}
					}

					// email validacija
					if (textEmail.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Email mora biti popunjeno!");
						lblStatus.setForeground(Color.red);
						
					} else {
						String regx = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textEmail.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Email mora biti u pravilnom formatu!");
							lblStatus.setForeground(Color.red);
							
						}
					}
 
					

					// datum rodjenja validacija
					if (textDatumRodjena.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Datum rođenja mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					} else {
						String regx = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textDatumRodjena.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Datum rođenja mora biti u formatu yyyy-mm-dd(2015-01-01)!");
							lblStatus.setForeground(Color.red);

						}
					}			
				    // adresa samo ne smije bit prazna
					if (textAdresa.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Adresa mora biti popunjeno!");
						lblStatus.setForeground(Color.red);
						
					}
					
					// prezime validacija
					if (textPrezime.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Prezime mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					} else {
						String regx = "[a-zA-Z]+\\.?";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textPrezime.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Prezime mora sadržavati samo slova!");
							lblStatus.setForeground(Color.red);
						}
					}
					
					// ime validacija
					if (textIme.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Ime mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					} else {
						String regx = "[a-zA-Z]+\\.?";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textIme.getText());
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
						trazeniAdministrator.set_ime(textIme.getText());
						trazeniAdministrator.set_prezime(textPrezime.getText());
						try {
							trazeniAdministrator.set_datumRodjenja(format.parse(textDatumRodjena.getText()));
						} catch (Exception e1) {
							lblStatus.setText(e1.getMessage());
							lblStatus.setForeground(Color.red);
							
							logger.error("Greska: ", e1);
							
							return;
						}
						trazeniAdministrator.set_adresa(textAdresa.getText());
						trazeniAdministrator.set_eMail(textEmail.getText());
						trazeniAdministrator.set_telefon(textTelefon.getText());
						try {
						adao.update(trazeniAdministrator);
						}
						catch (Exception e1) {
							lblStatus.setText("Došlo je do greško prilikom upisa u bazu");
							lblStatus.setForeground(Color.red);
							
							logger.error("Greska: ", e1);
							
							return;
						}
						
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
