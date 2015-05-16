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
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

public class StatistikaPoKlijentima extends JFrame {

	private JFrame frmStatistikaPoKlijentimaForma;
	
	public JFrame get_frmStatistikaPoKlijentimaForma () {
		return frmStatistikaPoKlijentimaForma;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatistikaPoKlijentima window = new StatistikaPoKlijentima();
					window.frmStatistikaPoKlijentimaForma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatistikaPoKlijentima() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStatistikaPoKlijentimaForma = new JFrame();
		frmStatistikaPoKlijentimaForma.setTitle("Statistika po anketama");
		frmStatistikaPoKlijentimaForma.setBounds(100, 100, 430, 508);
		frmStatistikaPoKlijentimaForma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatistikaPoKlijentimaForma.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmStatistikaPoKlijentimaForma);
		
		JPanel panel = new JPanel();
		frmStatistikaPoKlijentimaForma.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panelKlijent = new JPanel();
		panelKlijent.setLayout(null);
		panelKlijent.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga klijenata", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblIzaberiteAdministratora = new JLabel("Izaberite klijenta:");
		lblIzaberiteAdministratora.setBounds(22, 35, 103, 14);
		panelKlijent.add(lblIzaberiteAdministratora);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kurt Cobain"}));
		comboBox.setBounds(135, 32, 185, 20);
		panelKlijent.add(comboBox);
		
		JPanel panelAnketa = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAnketa.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelAnketa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Anketa broj 1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelAnketa, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelKlijent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(panelKlijent, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAnketa, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pitanje 1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setPreferredSize(new Dimension(290, 70));
		panelAnketa.add(panel_1);
		
		JLabel lblDaLiSte = new JLabel("Da li ste zadovoljni uslugom?");
		lblDaLiSte.setPreferredSize(new Dimension(260, 14));
		panel_1.add(lblDaLiSte);
		
		JLabel lblDa = new JLabel("1. Da");
		panel_1.add(lblDa);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_2.setPreferredSize(new Dimension(290, 70));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pitanje 2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelAnketa.add(panel_2);
		
		JLabel lblKolikoestoKoristite = new JLabel("Koliko \u010Desto koristite na\u0161e usluge?");
		lblKolikoestoKoristite.setPreferredSize(new Dimension(260, 14));
		panel_2.add(lblKolikoestoKoristite);
		
		JLabel lblesto = new JLabel("3. \u010Cesto");
		panel_2.add(lblesto);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_3.setPreferredSize(new Dimension(290, 70));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pitanje 3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelAnketa.add(panel_3);
		
		JLabel lblKomentarNaUsluge = new JLabel("Komentar na usluge:");
		lblKomentarNaUsluge.setPreferredSize(new Dimension(260, 14));
		panel_3.add(lblKomentarNaUsluge);
		
		JLabel lblUslugaJeKorektna = new JLabel("Usluga je korektna, osoblje je ljubazno");
		panel_3.add(lblUslugaJeKorektna);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmStatistikaPoKlijentimaForma.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
}