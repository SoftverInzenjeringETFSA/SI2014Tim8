package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Spol;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BrisanjeAdministratora extends JFrame {

	private JFrame frmBrisanjeAdministratora;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblStatus;

	public JFrame get_frmBrisanjeAdministratora() {
		return frmBrisanjeAdministratora;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeAdministratora window = new BrisanjeAdministratora();
					window.frmBrisanjeAdministratora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrisanjeAdministratora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrisanjeAdministratora = new JFrame();
		frmBrisanjeAdministratora.setTitle("Brisanje administratora");
		frmBrisanjeAdministratora.setBounds(100, 100, 470, 480);
		frmBrisanjeAdministratora
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrisanjeAdministratora.getContentPane().setLayout(
				new BorderLayout(0, 0));

		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmBrisanjeAdministratora);

		JPanel panel = new JPanel();
		frmBrisanjeAdministratora.getContentPane().add(panel,
				BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Pretraga administratora",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(30, 30, 390, 70);
		panel.add(panel_1);

		JLabel lblIzaberiteAdministratora = new JLabel(
				"Izaberite administratora:");
		lblIzaberiteAdministratora.setBounds(22, 35, 140, 14);
		panel_1.add(lblIzaberiteAdministratora);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Li\u010Dni podaci",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(30, 110, 390, 230);
		panel.add(panel_2);

		JLabel label_2 = new JLabel("Prezime:");
		label_2.setBounds(30, 62, 50, 14);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Ime:");
		label_3.setBounds(30, 37, 52, 14);
		panel_2.add(label_3);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(140, 34, 230, 20);
		panel_2.add(textField);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(140, 59, 230, 20);
		panel_2.add(textField_1);

		JLabel lblDatumRoenja = new JLabel("Datum ro\u0111enja:");
		lblDatumRoenja.setBounds(30, 140, 91, 14);
		panel_2.add(lblDatumRoenja);

		JLabel label_5 = new JLabel("Adresa:");
		label_5.setBounds(30, 115, 52, 14);
		panel_2.add(label_5);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(140, 112, 230, 20);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(140, 137, 230, 20);
		panel_2.add(textField_3);

		JLabel label_6 = new JLabel("Spol:");
		label_6.setBounds(30, 87, 50, 14);
		panel_2.add(label_6);

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

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(140, 162, 230, 20);
		panel_2.add(textField_4);

		JLabel label_7 = new JLabel("Email:");
		label_7.setBounds(30, 165, 50, 14);
		panel_2.add(label_7);

		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(30, 191, 52, 14);
		panel_2.add(lblTelefon);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(140, 193, 230, 20);
		panel_2.add(textField_5);

		JButton btnObriiKlijenta = new JButton("Obri\u0161i administratora");
		btnObriiKlijenta.setBounds(240, 350, 180, 23);
		panel.add(btnObriiKlijenta);

		lblStatus = new JLabel("Uredu");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBrisanjeAdministratora.getContentPane().add(lblStatus,
				BorderLayout.SOUTH);
		// LOGIKA

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 32, 195, 20);
		panel_1.add(comboBox);

		final AdministratorDao adao = AdministratorDao.get();
		Collection<Administrator> admini = (Collection<Administrator>) adao
				.readAll();
		for (Iterator<Administrator> iterator = admini.iterator(); iterator
				.hasNext();) {
			Administrator admin = (Administrator) iterator.next();
			comboBox.addItem(admin.toString());
		}

		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				AdministratorDao admindao = AdministratorDao.get();
				Collection<Administrator> admin = admindao
						.dajPoUsernamu(comboBox.getSelectedItem().toString());
				Administrator trazeniAdmin = new Administrator();
				for (Iterator<Administrator> iterator = admin.iterator(); iterator
						.hasNext();) {
					trazeniAdmin = (Administrator) iterator.next();
				}
				textField.setText(trazeniAdmin.get_ime());
				textField_1.setText(trazeniAdmin.get_prezime());
				textField_2.setText(trazeniAdmin.get_adresa());
				textField_3.setText(trazeniAdmin.get_datumRodjenja().toString()
						.substring(0, 10));
				textField_4.setText(trazeniAdmin.get_eMail());
				textField_5.setText(trazeniAdmin.get_telefon());
				if (trazeniAdmin.get_spol() == Spol.muski)
					radioButton.setSelected(true);
				else
					radioButton_1.setSelected(true);
			}
		});

		btnObriiKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (comboBox.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(null,
								"Izaberite administratora!",
								"Brisanje administratora",
								JOptionPane.WARNING_MESSAGE);
					} else {
						AdministratorDao admindao = AdministratorDao.get();
						Collection<Administrator> admin = admindao
								.dajPoUsernamu(comboBox.getSelectedItem()
										.toString());
						Administrator trazeniAdmin = new Administrator();
						for (Iterator<Administrator> iterator = admin
								.iterator(); iterator.hasNext();) {
							trazeniAdmin = (Administrator) iterator.next();
						}

						if (adao.readAll().size() == 1) {
							lblStatus.setText("Greska");
							JOptionPane
									.showMessageDialog(
											null,
											"Administrator ne može biti obrisan! U sistemu mora postojati barem jedan administrator!",
											"Brisanje administratora",
											JOptionPane.WARNING_MESSAGE);
						} else {
							adao.delete(trazeniAdmin.get_id());
							JOptionPane.showMessageDialog(null,
									"Administrator je uspješno obrisan!",
									"Brisanje administratora",
									JOptionPane.INFORMATION_MESSAGE);
							BrisanjeAdministratora noviProzor = new BrisanjeAdministratora();
							JFrame noviFrame = noviProzor
									.get_frmBrisanjeAdministratora();
							noviFrame.setVisible(true);
							frmBrisanjeAdministratora.dispose();

						}
					}
				} catch (Exception ex) {

				}
			}
		});

	}
}
