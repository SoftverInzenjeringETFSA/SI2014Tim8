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
import ba.tim8.kvizbiz.dao.KlijentDao;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.OdgovorDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Spol;

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

public class PromjenaKlijenta extends JFrame {

	// TODO: Rename textField u smislene izraze

	private JFrame frmPromjenaKlijenta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblStatus;

	public JFrame get_frmPromjenaKlijenta() {
		return frmPromjenaKlijenta;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromjenaKlijenta window = new PromjenaKlijenta();
					window.frmPromjenaKlijenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmPromjenaKlijenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPromjenaKlijenta.getContentPane().setLayout(new BorderLayout(0, 0));

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

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 34, 230, 20);
		panel_2.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 59, 230, 20);
		panel_2.add(textField_1);

		JLabel label_2 = new JLabel("Datum ro\u0111enja:");
		label_2.setBounds(30, 140, 100, 14);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Adresa:");
		label_3.setBounds(30, 115, 52, 14);
		panel_2.add(label_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 112, 230, 20);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 137, 230, 20);
		panel_2.add(textField_3);

		JLabel label_4 = new JLabel("Spol:");
		label_4.setBounds(30, 87, 50, 14);
		panel_2.add(label_4);

		final JRadioButton radioButton = new JRadioButton("Mu\u0161ki");
		radioButton.setBounds(140, 86, 74, 23);
		panel_2.add(radioButton);

		final JRadioButton radioButton_1 = new JRadioButton("\u017Denski");
		radioButton_1.setBounds(220, 86, 74, 23);
		panel_2.add(radioButton_1);

		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(140, 162, 230, 20);
		panel_2.add(textField_4);

		JLabel label_5 = new JLabel("Email:");
		label_5.setBounds(30, 165, 50, 14);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel("Telefon:");
		label_6.setBounds(30, 191, 52, 14);
		panel_2.add(label_6);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(140, 188, 230, 20);
		panel_2.add(textField_5);

		JLabel label_7 = new JLabel("Datum prijave:");
		label_7.setBounds(30, 216, 100, 14);
		panel_2.add(label_7);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(140, 213, 230, 20);
		panel_2.add(textField_6);

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
				textField.setText(trazeniKlijent.get_ime());
				textField_1.setText(trazeniKlijent.get_prezime());
				textField_2.setText(trazeniKlijent.get_adresa());
				textField_3.setText(trazeniKlijent.get_datumRodjenja()
						.toString().substring(0, 10));
				textField_4.setText(trazeniKlijent.get_eMail());
				textField_5.setText(trazeniKlijent.get_telefon());
				textField_6.setText(trazeniKlijent.get_datumPrijave()
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
					JOptionPane.showMessageDialog(null,
							"Izaberite klijenta!",
							"Promjena klijenta",
							JOptionPane.WARNING_MESSAGE);
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
					
					// datum prijave validacija
					if (textField_6.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Datum prijave mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					} else {
						String regx = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
						Pattern pattern = Pattern.compile(regx,
								Pattern.CASE_INSENSITIVE);
						Matcher matcher = pattern.matcher(textField_6.getText());
						if (!matcher.matches()) {
							dodaj = false;
							lblStatus.setText("Polje Datum prijave mora biti u formatu yyyy-mm-dd(2015-01-01)!");
							lblStatus.setForeground(Color.red);

						}
					}		
					

					// telefon validacija
					if (textField_5.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Telefon mora biti popunjeno!");
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

					DateFormat format_1 = new SimpleDateFormat("yyyy-mm-dd");
					DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
					if (comboBox.getSelectedIndex() == -1) {
						dodaj = false;
						lblStatus.setText("Izaberite klijenta!");
						lblStatus.setForeground(Color.red);

					}

					if (dodaj == true) {
						if (radioButton.isSelected()) 
							trazeniKlijent.set_spol(Spol.muski);
						else if(radioButton_1.isSelected())
							trazeniKlijent.set_spol(Spol.zenski);
						trazeniKlijent.set_ime(textField.getText());
						trazeniKlijent.set_prezime(textField_1.getText());
						try {
							trazeniKlijent.set_datumRodjenja(format.parse(textField_3.getText()));
							trazeniKlijent.set_datumPrijave(format.parse(textField_6.getText()));

						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						trazeniKlijent.set_adresa(textField_2.getText());
						trazeniKlijent.set_eMail(textField_4.getText());
						trazeniKlijent.set_telefon(textField_5.getText());
						kdao.update(trazeniKlijent);
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