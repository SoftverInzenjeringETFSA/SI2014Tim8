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

import ba.tim8.kvizbiz.dao.KlijentDao;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.OdgovorDao;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Spol;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Collection;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

public class BrisanjeKlijenta extends JFrame {

	final static Logger logger = Logger.getLogger(BrisanjeKlijenta.class);
	private static final long serialVersionUID = 1L;
	private JFrame frmBrisanjeKlijenta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblStatus;

	public JFrame get_frmBrisanjeKlijenta() {
		return frmBrisanjeKlijenta;
	}

	/**
	 * Create the application.
	 */
	public BrisanjeKlijenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrisanjeKlijenta = new JFrame();
		frmBrisanjeKlijenta.setTitle("Brisanje klijenta");
		frmBrisanjeKlijenta.setResizable(false);
		frmBrisanjeKlijenta.setBounds(100, 100, 470, 520);
		frmBrisanjeKlijenta.setLocationRelativeTo(null);
		frmBrisanjeKlijenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrisanjeKlijenta.getContentPane().setLayout(new BorderLayout(0, 0));

		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmBrisanjeKlijenta);

		lblStatus = new JLabel("Uredu");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBrisanjeKlijenta.getContentPane().add(lblStatus, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		frmBrisanjeKlijenta.getContentPane().add(panel, BorderLayout.CENTER);

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

		JButton btnObriiKlijenta = new JButton("Obri\u0161i klijenta");
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
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(140, 34, 230, 20);
		panel_2.add(textField);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
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
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(140, 112, 230, 20);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(140, 137, 230, 20);
		panel_2.add(textField_3);

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

		textField_4 = new JTextField();
		textField_4.setEditable(false);
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
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(140, 188, 230, 20);
		panel_2.add(textField_5);

		JLabel label_7 = new JLabel("Datum prijave:");
		label_7.setBounds(30, 216, 100, 14);
		panel_2.add(label_7);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(140, 213, 230, 20);
		panel_2.add(textField_6);

		// LOGIKA

		final KlijentDao kdao = KlijentDao.get();
		Collection<Klijent> klijenti = kdao.readAll();
		final JComboBox<String> comboBox = new JComboBox<String>();
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
				try {
					if (comboBox.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(null,
								"Izaberite klijenta!", "Brisanje klijenta",
								JOptionPane.WARNING_MESSAGE);
					} else {
						int rezultatDijaloga = JOptionPane
								.showConfirmDialog(
										null,
										"Jeste li sigurni da želite obrisati klijenta?",
										"Promjena ličnih podataka",
										JOptionPane.YES_NO_OPTION);
						if (rezultatDijaloga == JOptionPane.YES_OPTION) {
							KlijentDao klijentdao = KlijentDao.get();
							Collection<Klijent> klijent = klijentdao
									.dajKlijenta(comboBox.getSelectedItem()
											.toString());
							Klijent trazeniKlijent = new Klijent();
							for (Iterator<Klijent> iterator = klijent
									.iterator(); iterator.hasNext();) {
								trazeniKlijent = (Klijent) iterator.next();
							}
							kdao.delete(trazeniKlijent.get_id());
							JOptionPane.showMessageDialog(null,
									"Klijent je uspješno obrisan!",
									"Brisanje klijenta",
									JOptionPane.INFORMATION_MESSAGE);
							BrisanjeKlijenta noviProzor = new BrisanjeKlijenta();
							JFrame noviFrame = noviProzor
									.get_frmBrisanjeKlijenta();
							noviFrame.setVisible(true);
							frmBrisanjeKlijenta.dispose();
						}
					}
				} catch (Exception ex) {
					logger.error("Greska: ", ex);
				}
			}
		});
	}
}