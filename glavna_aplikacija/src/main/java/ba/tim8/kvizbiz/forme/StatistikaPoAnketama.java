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
import javax.swing.JOptionPane;
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

import ba.tim8.kvizbiz.dao.KlijentDao;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.TipPitanja;

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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class StatistikaPoAnketama extends JFrame {
	
	//TODO: Rename obavezan, cuj glavna forma forma statistike (rename i u klasi Menu!!!)
	
	private JFrame frmGlavnaForma;
	
	public JFrame get_frmGlavnaForma () {
		return frmGlavnaForma;
	}

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
		
		final JPanel panel = new JPanel();
		frmGlavnaForma.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panelAnketa = new JPanel();
		panelAnketa.setLayout(null);
		panelAnketa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga anketa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblIzaberiteAdministratora = new JLabel("Izaberite anketu:");
		lblIzaberiteAdministratora.setBounds(22, 35, 101, 14);
		panelAnketa.add(lblIzaberiteAdministratora);
		
		/*JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Klix", "RadioSarajevo"}));
		comboBox.setBounds(131, 32, 189, 20);
		panelAnketa.add(comboBox);*/
		
		final KvizDao kdao = KvizDao.get();
		Collection<Kviz> kvizovi = kdao.readAll();
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 32, 189, 20);
		panelAnketa.add(comboBox);

		Kviz kviz = new Kviz();
		for (Iterator<Kviz> iterator = kvizovi.iterator(); iterator
				.hasNext();) {
			kviz = (Kviz) iterator.next();
			comboBox.addItem(kviz);
		}
		comboBox.setSelectedIndex(-1);

		
		
		final JPanel panelStatistika = new JPanel();
		panelStatistika.setAutoscrolls(true);
		panelStatistika.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "O anketi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelStatistika.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		final JLabel lblNewLabel = new JLabel("Ukupno popunjenih anketa: ?");
		panelStatistika.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(247, 14));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelUkupno = new JPanel();
		panelStatistika.add(panelUkupno);
		panelUkupno.setLayout(new BorderLayout(0, 0));
		
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
		
		JScrollPane js =new JScrollPane(panelStatistika);
		//js.setPreferredSize(panelStatistika.getSize());
		panel.add(js);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Implement
				panelStatistika.removeAll();
				panelStatistika.revalidate();
				panelStatistika.repaint();
				
				Kviz tmp = (Kviz) comboBox.getSelectedItem();
				final JLabel lblNewLabel = new JLabel();
				lblNewLabel.setText("Ukupno popunjenih anketa: "+String.valueOf(tmp.get_klijenti().size()));
				panelStatistika.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setPreferredSize(new Dimension(247, 14));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				
				JPanel panelUkupno = new JPanel();
				panelStatistika.add(panelUkupno);
				panelUkupno.setLayout(new BorderLayout(0, 0));
				Set<Pitanje> pitanja = tmp.get_pitanja();
				for(Pitanje p:pitanja){
					if(p.get_tipPitanja().equals(TipPitanja.OtvoreniOdgovor))
						continue;
					JPanel panelD = new JPanel();
					panelD.setPreferredSize(new Dimension(300, 80));
					panelD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), p.get_tekstPitanja(), TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
					panelD.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
					Set<Odgovor> odgovori = p.get_listaOdgovora();
					int count = 1;
					for(Odgovor o:odgovori){
						int brOdgovora = o.get_klijenti().size();
						int ukOdgovora=tmp.get_klijenti().size();
						Double postotak = Double.valueOf(brOdgovora)/Double.valueOf(ukOdgovora);
						postotak *= 100;
						JLabel label = new JLabel(count+". "+o.get_tekstOdgovora()+" - "+String.format("%.2f",postotak)+"% ("+brOdgovora+" od "+ukOdgovora+")");
						label.setPreferredSize(new Dimension(280, 14));
						panelD.add(label);
						count++;
					}
					panelStatistika.add(panelD);
				}
				
				
			}});
	}
}