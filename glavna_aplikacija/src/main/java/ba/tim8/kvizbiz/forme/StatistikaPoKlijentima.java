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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import ba.tim8.kvizbiz.dao.KlijentDao;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Pitanje;

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
		
		final JPanel panel = new JPanel();
		frmStatistikaPoKlijentimaForma.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panelKlijent = new JPanel();
		panelKlijent.setLayout(null);
		panelKlijent.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga klijenata", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblIzaberiteAdministratora = new JLabel("Izaberite klijenta:");
		lblIzaberiteAdministratora.setBounds(22, 35, 103, 14);
		panelKlijent.add(lblIzaberiteAdministratora);
		
		final KlijentDao kdao = KlijentDao.get();
		Collection<Klijent> klijenti = kdao.dajPoPopunjenomKvizu();
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(135, 32, 185, 20);
		panelKlijent.add(comboBox);

		Klijent klijent = new Klijent();
		for (Iterator<Klijent> iterator = klijenti.iterator(); iterator
				.hasNext();) {
			klijent = (Klijent) iterator.next();
			comboBox.addItem(klijent);
		}
		comboBox.setSelectedIndex(-1);

		
		final JPanel panelAnketa = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAnketa.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelAnketa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Anketa broj ?", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmStatistikaPoKlijentimaForma.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		final JScrollPane jp = new JScrollPane(panelAnketa);
		jp.setPreferredSize(new Dimension(300, 300));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Implement
				Klijent k = (Klijent) comboBox.getSelectedItem();
				Kviz anketa = k.get_popunjeniKviz();
				panelAnketa.removeAll();
				panelAnketa.revalidate();
				panelAnketa.repaint();
				panelAnketa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), anketa.get_naziv(), 
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				Set<Pitanje> pitanja = k.get_popunjeniKviz().get_pitanja();
				int count = 1;
				for(Pitanje p:pitanja){
					Set<Odgovor> odgs = k.get_listaOdgovora();
					JLabel ques = new JLabel(count+". "+p.get_tekstPitanja());
					ques.setPreferredSize(new Dimension(250, 20));
					panelAnketa.add(ques);
					for(Odgovor o:odgs){
						if(o.get_pitanje().equals(p)){
							JLabel ans = new JLabel("        "+o.get_tekstOdgovora());
							ans.setPreferredSize(new Dimension(250, 20));
							panelAnketa.add(ans);
							
						}
					}
					count++;
				}
				for(int j=0; j<10;j++)
				{
					JLabel dump = new JLabel("Test");
					dump.setPreferredSize(new Dimension(250, 20));
					panelAnketa.add(dump);
				}
				frmStatistikaPoKlijentimaForma.add(jp);
			}});
	}
}