package ba.tim8.kvizbiz.forme;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.util.Collection;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.entiteti.Administrator;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PregledAdministratora extends JFrame {

	private JFrame frmPregledAdministratora;
	private JTable table;
	private JComboBox comboBox_1;
	private JComboBox  comboBox;
	
	public JFrame get_frmPregledAdministratora() {
		return frmPregledAdministratora;
	}

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
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				// biranje kategorije
				
				 //if(e.getStateChange() == ItemEvent.SELECTED)
				//JOptionPane.showMessageDialog(null, e.getItem());
				
				
				
				
				AdministratorDao adao = AdministratorDao.get();
				
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					comboBox_1.removeAllItems();
					comboBox_1.addItem("--------"); // default value
					
					String kategorija = e.getItem().toString();
					
					if(kategorija.compareTo("Username") == 0)
					{
						
						for(String s : adao.dajUsernames())
							comboBox_1.addItem(s);
						
					}
					else if(kategorija.compareTo("Ime") == 0)
					{
						for(String s : adao.dajImena())
							comboBox_1.addItem(s);
					}
					else if(kategorija.compareTo("Prezime") == 0)
					{
						for(String s : adao.dajPrezimena())
							comboBox_1.addItem(s);
					}
					else if(kategorija.compareTo("Adresa") == 0)
					{
						for(String s : adao.dajAdrese())
							comboBox_1.addItem(s);
					}
					else // default value, show all admins
					{
						comboBox_1.removeAllItems();
						ucitajSveAdmine();
					}
				}
				
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--------", "Username", "Ime", "Prezime", "Adresa"}));
		comboBox.setBounds(172, 29, 230, 20);
		panel_1.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			
			{
				// pretraga
				
				AdministratorDao adao = AdministratorDao.get();
				
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
				
				if(comboBox.getSelectedItem().toString() == "Username")
					ucitajAdmine(adao.dajPoUsernamu(comboBox_1.getSelectedItem().toString()));
				else if(comboBox.getSelectedItem().toString() == "Ime")
					ucitajAdmine(adao.dajPoImenu(comboBox_1.getSelectedItem().toString()));
				else if(comboBox.getSelectedItem().toString() == "Prezime")
					ucitajAdmine(adao.dajPoPrezimenu(comboBox_1.getSelectedItem().toString()));
				else if(comboBox.getSelectedItem().toString() == "Adresa")
					ucitajAdmine(adao.dajPoAdresi(comboBox_1.getSelectedItem().toString()));
				
				
			}
				
			}
		});
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
		
		
		ucitajSveAdmine();
	}
	
	private void ucitajSveAdmine()
	{
		// ucitavanje svih admina iz baze i prikaz u tabeli
		
		AdministratorDao adao = AdministratorDao.get();
		Collection<Administrator> admini = adao.readAll();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		
		
		ucitajAdmine(admini);
		
		
	}
	
	
	private void ucitajAdmine(Collection<Administrator> admini)
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		removeAllRows();
		
		for(Administrator a : admini)
		{
			model.addRow(new Object[]{a.get_username(), a.get_ime(), a.get_prezime(), a.get_spol(), a.get_adresa(), a.get_datumRodjenja(), a.get_eMail(), a.get_telefon()});
			
		}
	}
	
	private void removeAllRows()
	{
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
	
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
}
