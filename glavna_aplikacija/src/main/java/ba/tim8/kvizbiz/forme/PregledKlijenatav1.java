package ba.tim8.kvizbiz.forme;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledKlijenatav1 frame = new PregledKlijenatav1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PregledKlijenatav1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Pregled klijenata");
		setContentPane(contentPane);
		
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
		kategorija.setModel(new DefaultComboBoxModel(new String[] {"--------", "Username", "Ime", "Prezime", "Adresa", "Datum rođenja", "Telefon", "Email"}));
		
		mainContent.add(kategorija, "cell 2 0,growx");
		JLabel label_1 = new JLabel("Unesite vrijednost: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		mainContent.add(label_1, "cell 1 1,growx");
		
		vrijednost = new JTextField();
		mainContent.add(vrijednost, "cell 2 1,growx");
		
		btnPretrai = new JButton("Pretraži");
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
		mainContent.add(btnNazad, "cell 5 4 1 2,alignx right");
		
		
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
	}

}
