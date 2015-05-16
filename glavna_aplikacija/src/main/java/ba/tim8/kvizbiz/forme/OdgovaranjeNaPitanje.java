package ba.tim8.kvizbiz.forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class OdgovaranjeNaPitanje extends JFrame {

	private JFrame frmPopunjavanjeAnkete;
	private final JProgressBar progressBar = new JProgressBar();
	private final JPanel panelBrojPitanja = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdgovaranjeNaPitanje window = new OdgovaranjeNaPitanje();
					window.frmPopunjavanjeAnkete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OdgovaranjeNaPitanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPopunjavanjeAnkete = new JFrame();
		frmPopunjavanjeAnkete.setTitle("Popunjavanje ankete");
		frmPopunjavanjeAnkete.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MuhamedMujic\\Desktop\\ikonaKviz.png"));
		frmPopunjavanjeAnkete.setBounds(100, 100, 450, 381);
		frmPopunjavanjeAnkete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		frmPopunjavanjeAnkete.getContentPane().add(panelStatus, BorderLayout.SOUTH);
		GridBagLayout gbl_panelStatus = new GridBagLayout();
		gbl_panelStatus.columnWidths = new int[] {432, 0};
		gbl_panelStatus.rowHeights = new int[] {35, 25};
		gbl_panelStatus.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelStatus.rowWeights = new double[]{0.0, 0.0};
		panelStatus.setLayout(gbl_panelStatus);
		progressBar.setPreferredSize(new Dimension(246, 14));
		progressBar.setToolTipText("Napredak odgovaranja");
		progressBar.setValue(4);
		progressBar.setMaximum(20);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.VERTICAL;
		gbc_progressBar.insets = new Insets(10, 0, 5, 0);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 0;
		panelStatus.add(progressBar, gbc_progressBar);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(30, 144, 255));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.fill = GridBagConstraints.VERTICAL;
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 1;
		panelStatus.add(lblStatus, gbc_lblStatus);
		
		JPanel panelPitanje = new JPanel();
		frmPopunjavanjeAnkete.getContentPane().add(panelPitanje, BorderLayout.CENTER);
		SpringLayout sl_panelPitanje = new SpringLayout();
		panelPitanje.setLayout(sl_panelPitanje);
		
		JLabel lblPitanje = new JLabel("Koliko \u010Desto kupujete u na\u0161im poslovnicama?");
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, lblPitanje, 10, SpringLayout.NORTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, lblPitanje, 103, SpringLayout.WEST, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, lblPitanje, 39, SpringLayout.NORTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, lblPitanje, -87, SpringLayout.EAST, panelPitanje);
		lblPitanje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPitanje.add(lblPitanje);
		
		JPanel panelOdgovor = new JPanel();
		panelOdgovor.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, panelOdgovor, 6, SpringLayout.SOUTH, lblPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, panelOdgovor, 0, SpringLayout.WEST, lblPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, panelOdgovor, -57, SpringLayout.SOUTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, panelOdgovor, -87, SpringLayout.EAST, panelPitanje);
		panelPitanje.add(panelOdgovor);
		panelOdgovor.setLayout(null);
		
		JRadioButton rdbtnRijetko = new JRadioButton("Rijetko");
		rdbtnRijetko.setBounds(6, 7, 200, 41);
		panelOdgovor.add(rdbtnRijetko);
		
		JRadioButton rdbtnUobiajeno = new JRadioButton("Uobi\u010Dajeno");
		rdbtnUobiajeno.setBounds(6, 51, 200, 41);
		panelOdgovor.add(rdbtnUobiajeno);
		
		JRadioButton rdbtnesto = new JRadioButton("\u010Cesto");
		rdbtnesto.setBounds(6, 95, 200, 41);
		panelOdgovor.add(rdbtnesto);
		
		JButton btnNaprijed = new JButton("Naprijed");
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, btnNaprijed, 6, SpringLayout.SOUTH, panelOdgovor);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNaprijed, 0, SpringLayout.EAST, lblPitanje);
		panelPitanje.add(btnNaprijed);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.setMargin(new Insets(2, 5, 2, 5));
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, btnNazad, 6, SpringLayout.SOUTH, panelOdgovor);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, btnNazad, 195, SpringLayout.WEST, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNazad, -6, SpringLayout.WEST, btnNaprijed);
		panelPitanje.add(btnNazad);
		panelBrojPitanja.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frmPopunjavanjeAnkete.getContentPane().add(panelBrojPitanja, BorderLayout.NORTH);
		GridBagLayout gbl_panelBrojPitanja = new GridBagLayout();
		gbl_panelBrojPitanja.columnWidths = new int[] {438};
		gbl_panelBrojPitanja.rowHeights = new int[] {40};
		gbl_panelBrojPitanja.columnWeights = new double[]{0.0};
		gbl_panelBrojPitanja.rowWeights = new double[]{0.0};
		panelBrojPitanja.setLayout(gbl_panelBrojPitanja);
		
		JLabel lblPitanjeBroj = new JLabel("Pitanje broj 1.");
		lblPitanjeBroj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPitanjeBroj = new GridBagConstraints();
		gbc_lblPitanjeBroj.gridx = 0;
		gbc_lblPitanjeBroj.gridy = 0;
		panelBrojPitanja.add(lblPitanjeBroj, gbc_lblPitanjeBroj);
	}
}
