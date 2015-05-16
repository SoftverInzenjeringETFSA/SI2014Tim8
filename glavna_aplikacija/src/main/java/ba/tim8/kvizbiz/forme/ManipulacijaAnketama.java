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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ManipulacijaAnketama extends JFrame {

	private JFrame frmManipulacijaAnketama;
	private JTable tblAnkete;
	
	public JFrame get_frmManipulacijaAnketama () {
		return frmManipulacijaAnketama;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManipulacijaAnketama window = new ManipulacijaAnketama();
					window.frmManipulacijaAnketama.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManipulacijaAnketama() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManipulacijaAnketama = new JFrame();
		frmManipulacijaAnketama.setTitle("Manipulacija anketama");
		frmManipulacijaAnketama.setBounds(100, 100, 630, 430);
		frmManipulacijaAnketama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmManipulacijaAnketama);
		
		JPanel panel1 = new JPanel();
		frmManipulacijaAnketama.getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ozna\u010Dite akciju i manipuli\u0161ite anketama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 579, 282);
		panel1.add(panel);
		panel.setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 26, 402, 245);
		panel.add(scrollPane);
		
		// Testni podaci
		Object[] naziviKolona = new Object[]{"Broj", "Naziv", "Stats", "Broj pitanja", "Ograni�enjes"};
		Object[][] podaci = new Object[][]{
				{new Integer(1), "Studentska", "Arhivirana", "10", "10"},
				{new Integer(2), "Programiranje", "Otvorena", "12", "15"}
		};
		
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(podaci, naziviKolona);
		
		tblAnkete = new JTable(model);
		tblAnkete.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane.setViewportView(tblAnkete);
		
		JButton btnObriiOznaenu = new JButton("Obri\u0161i ozna\u010Denu");
		btnObriiOznaenu.setBounds(10, 92, 147, 23);
		panel.add(btnObriiOznaenu);
		
		JButton btnModifikujOznaenu = new JButton("Modifikuj ozna\u010Denu");
		btnModifikujOznaenu.setBounds(10, 126, 147, 23);
		panel.add(btnModifikujOznaenu);
		
		JButton btnArhivirajOznaenu = new JButton("Arhiviraj ozna\u010Denu");
		btnArhivirajOznaenu.setBounds(10, 160, 147, 23);
		panel.add(btnArhivirajOznaenu);
		
		JButton btnPregledajOznaenu = new JButton("Pregledaj ozna\u010Denu");
		btnPregledajOznaenu.setBounds(10, 58, 147, 23);
		panel.add(btnPregledajOznaenu);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(500, 304, 89, 23);
		panel1.add(btnOk);
		
		JButton btnOtkai = new JButton("Otka\u017Ei");
		btnOtkai.setBounds(401, 304, 89, 23);
		panel1.add(btnOtkai);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmManipulacijaAnketama.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		
	}

}
