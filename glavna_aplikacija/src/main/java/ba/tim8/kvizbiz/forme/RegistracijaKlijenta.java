package ba.tim8.kvizbiz.forme;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
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

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.dao.KlijentDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Spol;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JRadioButton;

public class RegistracijaKlijenta {

	public JFrame frmRegistracijaKlijenta;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtEmail;
	private JTextField txtBrojTelefona;
	private JTextField txtAdresa;	
	private JLabel lblStatus;
	private JTextField txtDatumRodjenja;
	private JRadioButton radioBtnMuski;
	private JRadioButton radioBtnZenski;
	
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
		frmRegistracijaKlijenta.setBounds(100, 100, 450, 428);
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
		
		JLabel lblEmail = new JLabel("E-mail:");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, lblEmail, 53, SpringLayout.SOUTH, lblPrezime);
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
		
		JButton btnOtkazi = new JButton("Nazads");
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, btnOtkazi, -101, SpringLayout.EAST, panelRegistracija);
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KvizBiz forma = new KvizBiz();
				forma.get_frame().repaint();
				forma.get_frame().revalidate();
				forma.get_frame().setVisible(true);
				frmRegistracijaKlijenta.dispose();
			}				
		});
		panelRegistracija.add(btnOtkazi);
		
		JButton btnRegistrujSe = new JButton("Registruj se");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, btnOtkazi, 0, SpringLayout.NORTH, btnRegistrujSe);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, btnOtkazi, 6, SpringLayout.EAST, btnRegistrujSe);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, btnRegistrujSe, 0, SpringLayout.WEST, lblIme);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, btnRegistrujSe, -204, SpringLayout.EAST, panelRegistracija);
		btnRegistrujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!spremiKlijenta()){
					JOptionPane.showMessageDialog(null,
							"Greška prilikom registracije klijenta!",
							"Registracija klijenta",
							JOptionPane.ERROR_MESSAGE);
				}else{
				PocetnaKlijentZaKlijenta noviFrame = new PocetnaKlijentZaKlijenta();
				noviFrame.setVisible(true);
				frmRegistracijaKlijenta.dispose();
				}
			}
		});	
		btnRegistrujSe.setMargin(new Insets(2, 5, 2, 5));
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
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, label_2, 39, SpringLayout.WEST, panelRegistracija);
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
		
		JLabel label_4 = new JLabel("Spol:");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, label_4, 17, SpringLayout.SOUTH, txtAdresa);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, label_4, -280, SpringLayout.EAST, panelRegistracija);
		panelRegistracija.add(label_4);
		
		radioBtnMuski = new JRadioButton("Muški");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, btnRegistrujSe, 23, SpringLayout.SOUTH, radioBtnMuski);
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, radioBtnMuski, -4, SpringLayout.NORTH, label_4);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, radioBtnMuski, 0, SpringLayout.WEST, lblpoljeJeObavezno);
		radioBtnMuski.setSelected(true);
		panelRegistracija.add(radioBtnMuski);
		
		radioBtnZenski = new JRadioButton("Ženski");
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, radioBtnZenski, -4, SpringLayout.NORTH, label_4);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, radioBtnZenski, 18, SpringLayout.EAST, radioBtnMuski);
		panelRegistracija.add(radioBtnZenski);
		
		ButtonGroup spol = new ButtonGroup();
		spol.add(radioBtnMuski);
		spol.add(radioBtnZenski);
		
		txtDatumRodjenja = new JTextField();
		sl_panelRegistracija.putConstraint(SpringLayout.SOUTH, label_2, 0, SpringLayout.SOUTH, txtDatumRodjenja);
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, txtDatumRodjenja, 16, SpringLayout.SOUTH, txtPrezime);
		sl_panelRegistracija.putConstraint(SpringLayout.WEST, txtDatumRodjenja, -86, SpringLayout.EAST, separator);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, txtDatumRodjenja, 0, SpringLayout.EAST, txtIme);
		txtDatumRodjenja.setColumns(10);
		panelRegistracija.add(txtDatumRodjenja);
		
		JLabel label_5 = new JLabel("Datum rođenja:");
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, label_2, -7, SpringLayout.WEST, label_5);
		sl_panelRegistracija.putConstraint(SpringLayout.NORTH, label_5, 20, SpringLayout.SOUTH, label_1);
		sl_panelRegistracija.putConstraint(SpringLayout.EAST, label_5, 0, SpringLayout.EAST, lblIme);
		panelRegistracija.add(label_5);
		
		JLabel lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmRegistracijaKlijenta.getContentPane().add(lblStatus, BorderLayout.SOUTH);
	}
	private boolean spremiKlijenta(){
		KlijentDao kdao = new KlijentDao();
		boolean dodaj = true;

	
		// ime validacija
		if (txtIme.getText().isEmpty()) {
			dodaj = false;
			//lblStatus.setText("Greska");
			JOptionPane.showMessageDialog(null,
					"Polje Ime mora biti popunjeno!",
					"Registracija klijenta",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String regx = "[a-zA-Z]+\\.?";
			Pattern pattern = Pattern.compile(regx,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(txtIme.getText());
			if (!matcher.matches()) {
				dodaj = false;
				//lblStatus.setText("Greska");
				JOptionPane
						.showMessageDialog(
								null,
								"Polje Ime mora sadržavati samo slova!",
								"Registracija klijenta",
								JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		// prezime validacija
		if (txtPrezime.getText().isEmpty()) {
			dodaj = false;
			//lblStatus.setText("Greska");
			JOptionPane.showMessageDialog(null,
					"Polje Prezime mora biti popunjeno!",
					"Registracija klijenta",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String regx = "[a-zA-Z]+\\.?";
			Pattern pattern = Pattern.compile(regx,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(txtPrezime.getText());
			if (!matcher.matches()) {
				dodaj = false;
				//lblStatus.setText("Greska");
				JOptionPane
						.showMessageDialog(
								null,
								"Polje Prezime mora sadržavati samo slova!",
								"Registracija klijenta",
								JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		if (txtDatumRodjenja.getText().isEmpty()) {
			dodaj = false;
			//lblStatus.setText("Greska");
			JOptionPane.showMessageDialog(null,
					"Polje Datum rođenja mora biti popunjeno!",
					"Dodavanje administratora",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String regx = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
			Pattern pattern = Pattern.compile(regx,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(txtDatumRodjenja.getText());
			if (!matcher.matches()) {
				dodaj = false;
				//lblStatus.setText("Greska");
				JOptionPane
						.showMessageDialog(
								null,
								"Polje Datum rođenja mora biti u formatu yyyy-mm-dd(2015-01-01)!",
								"Dodavanje administratora",
								JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		// email validacija
		if (txtEmail.getText().isEmpty()) {
			dodaj = false;
			//lblStatus.setText("Greska");
			JOptionPane.showMessageDialog(null,
					"Polje Email mora biti popunjeno!",
					"Registracija klijenta",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			String regx = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(regx,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(txtEmail.getText());
			if (!matcher.matches()) {
				dodaj = false;
				//lblStatus.setText("Greska");
				JOptionPane.showMessageDialog(null,
						"Polje Email mora biti u pravilnom formatu!",
						"Registracija klijenta",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		// telefon validacija
		if (!txtBrojTelefona.getText().isEmpty()) {
			String regx = "^[0-9]*$";
			Pattern pattern = Pattern.compile(regx,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(txtBrojTelefona.getText());
			if (!matcher.matches()) {
				dodaj = false;
				//lblStatus.setText("Greska");
				JOptionPane.showMessageDialog(null,
						"Polje Broj telefona mora sadržavati samo brojeve!",
						"Registracija klijenta",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		

		
		if (dodaj == true) {
			java.util.Date dt = new java.util.Date();			
			DateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
		
			try {
				Date datum = format.parse(txtDatumRodjenja.getText());
				
				Klijent k = new Klijent();
				k.set_ime(txtIme.getText());
				k.set_prezime(txtPrezime.getText());
				k.set_eMail(txtEmail.getText());
				k.set_adresa(txtAdresa.getText());
				k.set_telefon(txtBrojTelefona.getText());
				k.set_datumRodjenja(datum);
			
				if(radioBtnMuski.isSelected()){
					k.set_spol(Spol.muski);
				}else{
					k.set_spol(Spol.zenski);
				}
				k.set_datumPrijave(dt);
				kdao.create(k);
				JOptionPane.showMessageDialog(null,
						"Klijent je uspješno registrovan!",
						"Registracija klijenta",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		}
		return dodaj;
	}
}
