package ba.tim8.kvizbiz.forme;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import java.awt.BorderLayout;

import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import ba.tim8.kvizbiz.entiteti.Administrator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PromjenaLicnihPodataka extends JFrame {

	//TODO: Rename textField u smislene nazive
	
	private JFrame frmPromjenaLicnihPodataka;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
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
		
		JPanel panel = new JPanel();
		frmPromjenaLicnihPodataka.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow]", "[grow][20px]"));
		
		JButton btnPromjeniLinePodatke = new JButton("Promjeni li\u010Dne podatke");
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
		textField.setEditable(false);
		textField.setColumns(10);
		panel_1.add(textField, "cell 1 0 3 1,growx,aligny top");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
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
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		panel_1.add(textField_3, "cell 1 4 3 1,growx,aligny top");
		
		JLabel label_4 = new JLabel("Spol:");
		label_4.setHorizontalAlignment(JLabel.RIGHT);
		panel_1.add(label_4, "cell 0 2,growx,aligny top");
		
		JRadioButton radioButton = new JRadioButton("Muški");
		radioButton.setEnabled(false);
		panel_1.add(radioButton, "cell 1 2,growx,aligny top");
		
		JRadioButton radioButton_1 = new JRadioButton("Ženski");
		radioButton_1.setEnabled(false);
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
			
		JButton btnNewButton = new JButton("Uredu");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmPromjenaLicnihPodataka.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		/*
		btnPromjeniLinePodatke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean dodaj = true;
				// adresa samo ne smije bit prazna
				if (textField_2.getText().isEmpty()) {
					dodaj = false;
					btnNewButton.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Adresa mora biti popunjeno!",
							"Promjena licnih podataka", JOptionPane.ERROR_MESSAGE);
				}

				// email validacija
				if (textField_4.getText().isEmpty()) {
					dodaj = false;
					btnNewButton.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Email mora biti popunjeno!",
							"Promjena licnih podataka", JOptionPane.ERROR_MESSAGE);
				} else {
					String regx = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_4.getText());
					if (!matcher.matches()) {
						dodaj = false;
						btnNewButton.setText("Greska");
						JOptionPane.showMessageDialog(null,
								"Polje Email mora biti u pravilnom formatu!",
								"Promjena licnih podataka", JOptionPane.ERROR_MESSAGE);
						;
					}
				}

				// telefon validacija
				if (textField_5.getText().isEmpty()) {
					dodaj = false;
					btnNewButton.setText("Greska");
					JOptionPane.showMessageDialog(null,
							"Polje Telefon mora biti popunjeno!",
							"Promjena licnih podataka", JOptionPane.ERROR_MESSAGE);
				} else {
					String regx = "^[0-9]*$";
					Pattern pattern = Pattern.compile(regx,
							Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(textField_5.getText());
					if (!matcher.matches()) {
						dodaj = false;
						btnNewButton.setText("Greska");
						JOptionPane.showMessageDialog(null,
								"Polje Telefon mora sadržavati samo brojeve!",
								"Promjena licnih podataka", JOptionPane.ERROR_MESSAGE);
						;
					}
				}

				if (dodaj == true) {
					trazeniKlijent.set_adresa(textField_2.getText());
					trazeniKlijent.set_eMail(textField_4.getText());
					trazeniKlijent.set_telefon(textField_5.getText());
					kdao.update(trazeniKlijent);
					JOptionPane.showMessageDialog(null,
							"Klijent je uspješno promjenjen!",
							"Promjena klijenta",
							JOptionPane.INFORMATION_MESSAGE);
					PromjenaLicnihPodataka noviProzor = new PromjenaLicnihPodataka();
					JFrame noviFrame = noviProzor.get_frmPromjenaLicnihPodataka();
					noviFrame.setVisible(true);
					frmPromjenaLicnihPodataka.dispose();
				}
			}
		}); */
	}
}
