package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.dao.KlijentDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import net.miginfocom.swing.MigLayout;

public class PregledKlijenatav1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblStatus;
	private JComboBox<String> kategorija;
	private JTextField vrijednost;
	private JTable klijentiTab;
	private JTable table;
	private JButton btnNazad;
	private JButton btnPretrai;
	private JFrame par;
	
	final static Logger logger = Logger.getLogger(PregledKlijenatav1.class);
	



	/**
	 * Create the frame.
	 */
	public PregledKlijenatav1(JFrame parent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Pregled klijenata");
		setContentPane(contentPane);
		
		par = parent;
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JPanel mainContent = new JPanel(new MigLayout("", "[grow][fill][220px][fill][fill][grow]", "[fill][fill][50px][grow][fill]"));
		mainContent.setBorder(new TitledBorder("Unesite podatke za pretragu klijenata:"));
		contentPane.add(mainContent, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Izaberite kategoriju: ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		mainContent.add(label, "cell 1 0,growx");
		
		kategorija = new JComboBox<String>();
		kategorija.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				// biranje kategorije
				
				
				
				
				
				
				AdministratorDao adao = AdministratorDao.get();
				
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					
					
					String kategorija = e.getItem().toString();
					
					if(kategorija.compareTo("--------") == 0)
					{
						ucitajSveKlijente();
						vrijednost.setText("");
						
						
					}
					
						
						
					
				}
				
				
			}
		});
		kategorija.setModel(new DefaultComboBoxModel(new String[] {"--------", "Ime", "Prezime", "Adresa", "Datum rođenja", "Telefon", "Email"}));
		
		mainContent.add(kategorija, "cell 2 0,growx");
		JLabel label_1 = new JLabel("Unesite vrijednost: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		mainContent.add(label_1, "cell 1 1,growx");
		
		vrijednost = new JTextField();
		mainContent.add(vrijednost, "cell 2 1,growx");
		
		btnPretrai = new JButton("Pretraži");
		btnPretrai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			
			
			{
				// pretraga
				
				KlijentDao adao = KlijentDao.get();
				
				
				if(kategorija.getSelectedItem().toString() == "Ime")
					ucitajKlijente(adao.dajPoImenu(vrijednost.getText()));
				else if(kategorija.getSelectedItem().toString() == "Prezime")
					ucitajKlijente(adao.dajPoPrezimenu(vrijednost.getText()));
				else if(kategorija.getSelectedItem().toString() == "Adresa")
					ucitajKlijente(adao.dajPoAdresi(vrijednost.getText()));
				else if(kategorija.getSelectedItem().toString() == "Datum rođenja")
				{
						try
					{
						ucitajKlijente(adao.dajPoDatumu(vrijednost.getText()));
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,
								"Datum mora biti u formatu dd/mm/yyyy",
								"Pogrešan format datuma",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(kategorija.getSelectedItem().toString() == "Telefon")
					ucitajKlijente(adao.dajPoTelefonu(vrijednost.getText()));
				else if(kategorija.getSelectedItem().toString() == "Email")
					ucitajKlijente(adao.dajPoMailu(vrijednost.getText()));
			}
		});
		mainContent.add(btnPretrai, "cell 3 1");
		
		JScrollPane scrollPane = new JScrollPane();
		mainContent.add(scrollPane, "cell 0 3 6 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Ime", "Prezime", "Spol", "Adresa", "Datum rođenja", "Email", "Telefon"
			}
		){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setMinWidth(85);
		
		btnNazad = new JButton("Nazad");
		btnNazad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				par.setVisible(true);
				dispose();
			}
		});
		mainContent.add(btnNazad, "cell 5 4 1 2,alignx right");
		
		
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		
		ucitajSveKlijente();
	}
	
	private void ucitajSveKlijente()
	{
		// ucitavanje svih klijenata iz baze i prikaz u tabeli
		
		KlijentDao kdao = KlijentDao.get();
		Collection<Klijent> klijenti = kdao.readAll();
		sortirajPoPrezimenu(klijenti);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		
		
		ucitajKlijente(klijenti);
		
		
	}
	
	private void sortirajPoPrezimenu(Collection<Klijent> klijenti)
	{
		Comparator<Klijent> comparator = new Comparator<Klijent>() {
		    public int compare(Klijent f1, Klijent f2) {
		        return f1.get_prezime().compareTo(f2.get_prezime());
		    }
		};

		Collections.sort((ArrayList<Klijent>) klijenti, comparator);
		
	}

	private void ucitajKlijente(Collection<Klijent> klijenti)
	{
		Integer brojac = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		removeAllRows();
		
		for(Klijent k : klijenti)
		{
			model.addRow(new Object[]{k.get_ime(), k.get_prezime(), k.get_spol(), k.get_adresa(), k.get_datumRodjenja(), k.get_eMail(), k.get_telefon()});
			brojac++;
		}
		
		lblStatus.setText("Prikazano " + brojac.toString() + " rezultata.");
		
		lblStatus.setForeground(Color.GREEN);
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
