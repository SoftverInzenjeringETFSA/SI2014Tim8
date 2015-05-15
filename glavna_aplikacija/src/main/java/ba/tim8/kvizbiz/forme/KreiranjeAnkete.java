package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class KreiranjeAnkete extends JFrame {

	private JFrame frmKreiranjeAnkete;
	private JTextField textField;
	private JTable tblPitanja;
	
	public JFrame get_frmKreiranjeAnkete () {
		return frmKreiranjeAnkete;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KreiranjeAnkete window = new KreiranjeAnkete();
					window.frmKreiranjeAnkete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KreiranjeAnkete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKreiranjeAnkete = new JFrame();
		frmKreiranjeAnkete.setTitle("Kreiranje ankete");
		frmKreiranjeAnkete.setBounds(100, 100, 620, 458);
		frmKreiranjeAnkete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKreiranjeAnkete.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmKreiranjeAnkete);
		
		JPanel panel1 = new JPanel();
		frmKreiranjeAnkete.getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 30, 400, 100);
		panel.setBorder(new TitledBorder(null, "Unesite osnovne podatke:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(168, 31, 195, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(25, 34, 133, 14);
		panel.add(lblNaziv);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinner.setBounds(168, 62, 86, 20);
		panel.add(spinner);
		
		JLabel lblVremeskoOgranienje = new JLabel("Vremensko ograni\u010Denje:");
		lblVremeskoOgranienje.setBounds(25, 65, 133, 14);
		panel.add(lblVremeskoOgranienje);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(474, 327, 89, 23);
		panel1.add(btnOk);
		
		JButton btnOtkazi = new JButton("Otka\u017Ei");
		btnOtkazi.setBounds(360, 327, 89, 23);
		panel1.add(btnOtkazi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Unesite pitanja:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(30, 141, 533, 175);
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		// Testni podaci
		Object[] naziviKolona = new Object[]{"Broj", "Tekst", "Tip"};
		Object[][] podaci = new Object[][]{
				{new Integer(1), "Koliko je 2+2?", "Ponu�eni odgovori"},
				{new Integer(2), "�ta je polimorfizam?", "Otvoren odgovor"}
		};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(podaci, naziviKolona);
		
		JButton btnDodajNovo = new JButton("Dodaj novo");
		btnDodajNovo.setBounds(10, 30, 155, 23);
		panel_1.add(btnDodajNovo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 25, 348, 139);
		panel_1.add(scrollPane);
		
		tblPitanja = new JTable(model);
		tblPitanja.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane.setViewportView(tblPitanja);
		
		JButton btnObrisiOznaceno = new JButton("Obriši označeno");
		btnObrisiOznaceno.setBounds(10, 64, 155, 23);
		panel_1.add(btnObrisiOznaceno);
		
		JButton btnPromjeniOznaceno = new JButton("Promjeni označeno");
		btnPromjeniOznaceno.setBounds(10, 98, 155, 23);
		panel_1.add(btnPromjeniOznaceno);
		

		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmKreiranjeAnkete.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}

}
