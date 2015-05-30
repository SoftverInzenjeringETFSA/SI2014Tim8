

package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import ba.tim8.kvizbiz.dao.KlijentDao;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Spol;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromjenaKlijenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmPromjenaKlijenta;
	final static Logger logger = Logger.getLogger(PromjenaLicnihPodataka.class);

	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textAdresa;
	private JTextField textDatumRodjena;
	private JTextField textEmail;
	private JTextField textTelefon;
	private JTextField textDatumPrijave;
	private JLabel lblStatus;

	public JFrame get_frmPromjenaKlijenta() {
		return frmPromjenaKlijenta;
	}

	/**
	 * Create the application.
	 */
	public PromjenaKlijenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPromjenaKlijenta = new JFrame();
		frmPromjenaKlijenta.setTitle("Promjena klijenta");
		frmPromjenaKlijenta.setBounds(100, 100, 470, 520);
		frmPromjenaKlijenta.setLocationRelativeTo(null);
		frmPromjenaKlijenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPromjenaKlijenta.getContentPane().setLayout(new BorderLayout(0, 0));
		frmPromjenaKlijenta.setResizable(false);

		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmPromjenaKlijenta);

		lblStatus = new JLabel("Uredu");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmPromjenaKlijenta.getContentPane().add(lblStatus, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		frmPromjenaKlijenta.getContentPane().add(panel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Pretraga klijenata",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(30, 30, 390, 70);
		panel.add(panel_1);

		JLabel lblIzaberiteKlijenta = new JLabel("Izaberite klijenta:");
		lblIzaberiteKlijenta.setBounds(22, 35, 140, 14);
		panel_1.add(lblIzaberiteKlijenta);

		JButton btnObriiKlijenta = new JButton("Promjeni klijenta");
		btnObriiKlijenta.setBounds(241, 382, 180, 23);
		panel.add(btnObriiKlijenta);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Li\u010Dni podaci",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(30, 111, 390, 261);
		panel.add(panel_2);

		JLabel label = new JLabel("Prezime:");
		label.setBounds(30, 62, 50, 14);
		panel_2.add(label);

		JLabel label_1 = new JLabel("Ime:");
		label_1.setBounds(30, 37, 52, 14);
		panel_2.add(label_1);

		textIme = new JTextField();
		textIme.setEditable(false);
		textIme.setColumns(10);
		textIme.setBounds(140, 34, 230, 20);
		panel_2.add(textIme);

		textPrezime = new JTextField();
		textPrezime.setEditable(false);
		textPrezime.setColumns(10);
		textPrezime.setBounds(140, 59, 230, 20);
		panel_2.add(textPrezime);

		JLabel label_2 = new JLabel("Datum ro\u0111enja:");
		label_2.setBounds(30, 140, 100, 14);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Adresa:");
		label_3.setBounds(30, 115, 52, 14);
		panel_2.add(label_3);

		textAdresa = new JTextField();
		textAdresa.setColumns(10);
		textAdresa.setBounds(140, 112, 230, 20);
		panel_2.add(textAdresa);

		textDatumRodjena = new JTextField();
		textDatumRodjena.setEditable(false);
		textDatumRodjena.setColumns(10);
		textDatumRodjena.setBounds(140, 137, 230, 20);
		panel_2.add(textDatumRodjena);

		JLabel label_4 = new JLabel("Spol:");
		label_4.setBounds(30, 87, 50, 14);
		panel_2.add(label_4);

		final JRadioButton radioButton = new JRadioButton("Mu\u0161ki");
		radioButton.setEnabled(false);
		radioButton.setBounds(140, 86, 74, 23);
		panel_2.add(radioButton);

		final JRadioButton radioButton_1 = new JRadioButton("\u017Denski");
		radioButton_1.setEnabled(false);
		radioButton_1.setBounds(220, 86, 74, 23);
		panel_2.add(radioButton_1);

		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(140, 162, 230, 20);
		panel_2.add(textEmail);

		JLabel label_5 = new JLabel("Email:");
		label_5.setBounds(30, 165, 50, 14);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel("Telefon:");
		label_6.setBounds(30, 191, 52, 14);
		panel_2.add(label_6);

		textTelefon = new JTextField();
		textTelefon.setColumns(10);
		textTelefon.setBounds(140, 188, 230, 20);
		panel_2.add(textTelefon);

		JLabel label_7 = new JLabel("Datum prijave:");
		label_7.setBounds(30, 216, 100, 14);
		panel_2.add(label_7);

		textDatumPrijave = new JTextField();
		textDatumPrijave.setEditable(false);
		textDatumPrijave.setColumns(10);
		textDatumPrijave.setBounds(140, 213, 230, 20);
		panel_2.add(textDatumPrijave);

		// LOGIKA

		final KlijentDao kdao = KlijentDao.get();
		Collection<Klijent> klijenti = kdao.readAll();
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 32, 195, 20);
		panel_1.add(comboBox);

		Klijent klijent = new Klijent();
		for (Iterator<Klijent> iterator = klijenti.iterator(); iterator
				.hasNext();) {
			klijent = (Klijent) iterator.next();
			comboBox.addItem(klijent.toString());
		}
		comboBox.setSelectedIndex(-1);

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				KlijentDao klijentdao = KlijentDao.get();
				String neki = comboBox.getSelectedItem().toString();
				Collection<Klijent> klijent = klijentdao.dajKlijenta(neki);
				Klijent trazeniKlijent = new Klijent();
				for (Iterator<Klijent> iterator = klijent.iterator(); iterator
						.hasNext();) {
					trazeniKlijent = (Klijent) iterator.next();
				}
				textIme.setText(trazeniKlijent.get_ime());
				textPrezime.setText(trazeniKlijent.get_prezime());
				textAdresa.setText(trazeniKlijent.get_adresa());
				textDatumRodjena.setText(trazeniKlijent.get_datumRodjenja()
						.toString().substring(0, 10));
				textEmail.setText(trazeniKlijent.get_eMail());
				textTelefon.setText(trazeniKlijent.get_telefon());
				textDatumPrijave.setText(trazeniKlijent.get_datumPrijave()
						.toString().substring(0, 10));
				if (trazeniKlijent.get_spol() == Spol.muski)
					radioButton.setSelected(true);
				else
					radioButton_1.setSelected(true);
			}
		});

		btnObriiKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean dodaj = true;
				if (comboBox.getSelectedIndex() == -1) {
					dodaj = false;
					JOptionPane.showMessageDialog(null, "Izaberite klijenta!",
							"Promjena klijenta", JOptionPane.WARNING_MESSAGE);
				} else

				{
					KlijentDao klijentdao = KlijentDao.get();
					Collection<Klijent> klijent = klijentdao
							.dajKlijenta(comboBox.getSelectedItem().toString());
					Klijent trazeniKlijent = new Klijent();
					for (Iterator<Klijent> iterator = klijent.iterator(); iterator
							.hasNext();) {
						trazeniKlijent = (Klijent) iterator.next();
					}


					// telefon validacija
					if (textTelefon.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Telefon mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					} else{
						String regx = "^[0-9]*$";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textTelefon.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus
									.setText("Polje Telefon mora sadržavati samo brojeve!");
							lblStatus.setForeground(Color.red);

						}
						else if(textTelefon.getText().length()<6 || textTelefon.getText().length()>13)
						{
							dodaj = false;
							lblStatus
									.setText("Polje Telefon mora sadržavati između 6 i 13 cifara!");
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
							lblStatus
									.setText("Polje Email mora biti u pravilnom formatu!");
							lblStatus.setForeground(Color.red);
						}
					}

					// datum rodjenja validacija
					if (textDatumRodjena.getText().isEmpty()) {
						dodaj = false;
						lblStatus
								.setText("Polje Datum rođenja mora biti popunjeno!");
					} else {
						String regx = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textDatumRodjena
								.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus
									.setText("Polje Datum rođenja mora biti ispravno i u formatu yyyy-mm-dd(2015-01-01)!");
						} else {
							ZonedDateTime danasnji = ZonedDateTime.now();
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd");
							try {
								Date uneseni = sdf.parse(textDatumRodjena
										.getText());
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

					} 
					else if(textPrezime.getText().length()<3){
						dodaj=false;
						lblStatus.setText("Polje Prezime mora sadržavati barem 3 slova!");
						lblStatus.setForeground(Color.red);
						
					}
					else {
						String regx = "[a-žA-Ž]+\\.?";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textPrezime.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus
									.setText("Polje Prezime mora sadržavati samo slova!");
							lblStatus.setForeground(Color.red);
						}
					}

					// ime validacija
					if (textIme.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setForeground(Color.red);
						lblStatus.setText("Polje Ime mora biti popunjeno!");

					} 
					else if(textIme.getText().length()<2){
						dodaj=false;
						lblStatus.setText("Polje Ime mora sadržavati barem 2 slova!");
						lblStatus.setForeground(Color.red);
						
					}
					else {
						String regx = "[a-žA-Ž]+\\.?";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textIme.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus
									.setText("Polje Ime mora sadržavati samo slova!");
							lblStatus.setForeground(Color.red);

						}
					}

					DateFormat format_1 = new SimpleDateFormat("yyyy-MM-dd");
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					if (comboBox.getSelectedIndex() == -1) {
						dodaj = false;
						lblStatus.setText("Izaberite klijenta!");
						lblStatus.setForeground(Color.red);

					}

					if (dodaj == true) {
						if (radioButton.isSelected())
							trazeniKlijent.set_spol(Spol.muski);
						else if (radioButton_1.isSelected())
							trazeniKlijent.set_spol(Spol.zenski);
						trazeniKlijent.set_ime(textIme.getText());
						trazeniKlijent.set_prezime(textPrezime.getText());
						try {
							trazeniKlijent.set_datumRodjenja(format
									.parse(textDatumRodjena.getText()));
							trazeniKlijent.set_datumPrijave(format_1
									.parse(textDatumPrijave.getText()));

						} catch (Exception e1) {
							lblStatus.setText(e1.getMessage());
							lblStatus.setForeground(Color.red);

							logger.error("Greska: ", e1);

							return;

						}
						trazeniKlijent.set_adresa(textAdresa.getText());
						trazeniKlijent.set_eMail(textEmail.getText());
						trazeniKlijent.set_telefon(textTelefon.getText());
						try {
							kdao.update(trazeniKlijent);
						} catch (Exception e1) {
							lblStatus
									.setText("Došlo je do greško prilikom upisa u bazu");
							lblStatus.setForeground(Color.red);
							logger.error("Greska: ", e1);
							return;
						}
						lblStatus.setText("Uredu");
						lblStatus.setForeground(Color.blue);
						JOptionPane.showMessageDialog(null,
								"Klijent je uspješno promjenjen!",
								"Promjena klijenta",
								JOptionPane.INFORMATION_MESSAGE);
						PromjenaKlijenta noviProzor = new PromjenaKlijenta();
						JFrame noviFrame = noviProzor.get_frmPromjenaKlijenta();
						noviFrame.setVisible(true);
						frmPromjenaKlijenta.dispose();
					}
				}
			}
		});
	}
}