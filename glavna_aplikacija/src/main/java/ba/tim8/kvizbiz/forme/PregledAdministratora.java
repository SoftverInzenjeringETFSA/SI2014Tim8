package ba.tim8.kvizbiz.forme;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;

public class PregledAdministratora extends JFrame {

	private JFrame frmPregledAdministratora;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledAdministratora window = new PregledAdministratora();
					window.frmPregledAdministratora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PregledAdministratora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPregledAdministratora = new JFrame();
		frmPregledAdministratora.setTitle("Pregled administratora");
		frmPregledAdministratora.setBounds(100, 100, 650, 380);
		frmPregledAdministratora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmPregledAdministratora);		
		
		frmPregledAdministratora.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmPregledAdministratora.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga administratora", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(30, 31, 430, 90);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Izaberite kategoriju:");
		label.setBounds(30, 32, 132, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Izaberite vrijednost:");
		label_1.setBounds(30, 57, 132, 14);
		panel_1.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(172, 29, 230, 20);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(172, 54, 230, 20);
		panel_1.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 145, 580, 127);
		panel.add(scrollPane);
			
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Username", "Ime", "Prezime", "Spol", "Adresa", "Datum ro\u0111enja", "Email", "Telefon"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setMinWidth(85);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmPregledAdministratora.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
}
