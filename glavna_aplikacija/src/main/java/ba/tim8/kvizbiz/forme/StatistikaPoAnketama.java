package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

import java.awt.ComponentOrientation;

public class StatistikaPoAnketama extends JFrame {
	
	//TODO: Rename obavezan, cuj glavna forma forma statistike
	
	private JFrame frmGlavnaForma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatistikaPoAnketama window = new StatistikaPoAnketama();
					window.frmGlavnaForma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatistikaPoAnketama() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGlavnaForma = new JFrame();
		frmGlavnaForma.setTitle("Statistika po anketama");
		frmGlavnaForma.setBounds(100, 100, 430, 518);
		frmGlavnaForma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGlavnaForma.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmGlavnaForma);
		
		JPanel panel = new JPanel();
		frmGlavnaForma.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panelAnketa = new JPanel();
		panelAnketa.setLayout(null);
		panelAnketa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga anketa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblIzaberiteAdministratora = new JLabel("Izaberite anketu:");
		lblIzaberiteAdministratora.setBounds(22, 35, 101, 14);
		panelAnketa.add(lblIzaberiteAdministratora);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Klix", "RadioSarajevo"}));
		comboBox.setBounds(131, 32, 189, 20);
		panelAnketa.add(comboBox);
		
		JPanel panelStatistika = new JPanel();
		panelStatistika.setAutoscrolls(true);
		panelStatistika.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "O anketi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelStatistika.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Ukupno popunjenih anketa: 36");
		panelStatistika.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(247, 14));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelUkupno = new JPanel();
		panelStatistika.add(panelUkupno);
		panelUkupno.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPitanje1 = new JPanel();
		panelPitanje1.setPreferredSize(new Dimension(300, 80));
		panelPitanje1.setBorder(new TitledBorder(null, "Prvo pitanje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelStatistika.add(panelPitanje1);
		panelPitanje1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblDaLiSte = new JLabel("Da li ste zadovoljni uslugom?");
		lblDaLiSte.setPreferredSize(new Dimension(280, 14));
		panelPitanje1.add(lblDaLiSte);
		
		JLabel label = new JLabel("1. Da - 33% (12 od 36)");
		label.setPreferredSize(new Dimension(280, 14));
		panelPitanje1.add(label);
		
		JLabel lblNe = new JLabel("2. Ne - 67% (24 od 36)");
		lblNe.setPreferredSize(new Dimension(280, 14));
		panelPitanje1.add(lblNe);
		
		JPanel panelPitanje2 = new JPanel();
		panelPitanje2.setPreferredSize(new Dimension(300, 80));
		panelPitanje2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Drugo pitanje", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelStatistika.add(panelPitanje2);
		panelPitanje2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel label_1 = new JLabel("Da li ste zadovoljni uslugom?");
		label_1.setPreferredSize(new Dimension(280, 14));
		panelPitanje2.add(label_1);
		
		JLabel label_2 = new JLabel("1. Da - 33% (12 od 36)");
		label_2.setPreferredSize(new Dimension(280, 14));
		panelPitanje2.add(label_2);
		
		JLabel label_3 = new JLabel("2. Ne - 67% (24 od 36)");
		label_3.setPreferredSize(new Dimension(280, 14));
		panelPitanje2.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(300, 80));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Drugo pitanje", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelStatistika.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel label_4 = new JLabel("Da li ste zadovoljni uslugom?");
		label_4.setPreferredSize(new Dimension(280, 14));
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("1. Da - 33% (12 od 36)");
		label_5.setPreferredSize(new Dimension(280, 14));
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("2. Ne - 67% (24 od 36)");
		label_6.setPreferredSize(new Dimension(280, 14));
		panel_1.add(label_6);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelStatistika, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelAnketa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
					.addGap(48))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(panelAnketa, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(panelStatistika, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmGlavnaForma.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
}