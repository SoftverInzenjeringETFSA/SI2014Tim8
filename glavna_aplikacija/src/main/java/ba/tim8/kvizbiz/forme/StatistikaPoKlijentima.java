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
import javax.swing.JTextArea;
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

public class StatistikaPoKlijentima extends JFrame {
	
	private JFrame frmStatistikaKlijent;
	
	public JFrame get_frmStatistikaPoKlijentimaForma () {
		return frmStatistikaKlijent;
	}
	
	public JFrame get_frmGlavnaForma () {
		return frmStatistikaKlijent;
	}

	public StatistikaPoKlijentima() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStatistikaKlijent = new JFrame();
		frmStatistikaKlijent.setTitle("Statistika po klijentima");
		frmStatistikaKlijent.setBounds(100, 100, 430, 518);
		frmStatistikaKlijent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatistikaKlijent.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		Menu menu = new Menu();
		menu.NapraviMenu(frmStatistikaKlijent);		
		
		
		final JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmStatistikaKlijent.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		final JScrollPane scrollPane = new JScrollPane();
		frmStatistikaKlijent.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.black);
		textArea.setBackground(frmStatistikaKlijent.getBackground());
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setColumnHeaderView(comboBox);
		
		final KlijentDao kdao = KlijentDao.get();
		Collection<Klijent> klijenti = kdao.dajPoPopunjenomKvizu();

		Klijent klijent = new Klijent();
		for (Iterator<Klijent> iterator = klijenti.iterator(); iterator
				.hasNext();) {
			klijent = (Klijent) iterator.next();
			comboBox.addItem(klijent);
		}
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Implement
				Klijent k = (Klijent) comboBox.getSelectedItem();
				Kviz anketa = k.get_popunjeniKviz();
				btnNewButton.setText(anketa.get_naziv());
				String tekst = "\n";
				tekst += "\tNaziv kviza: "+anketa.get_naziv()+"\n"; 
				Set<Pitanje> pitanja = k.get_popunjeniKviz().get_pitanja();
				int count = 1;
				for(Pitanje p:pitanja){
					Set<Odgovor> odgs = k.get_listaOdgovora();
					tekst += "\n  "+count+". "+p.get_tekstPitanja()+"\n";
					for(Odgovor o:odgs){
						if(o.get_pitanje().equals(p)){
							tekst += "        "+o.get_tekstOdgovora()+"\n";
						}
					}
					count++;
				}
				textArea.setText(tekst);
			}});
		
		JLabel lblIzaberiteAnketu = new JLabel("Izaberite klijenta:");
		lblIzaberiteAnketu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzaberiteAnketu.setHorizontalAlignment(SwingConstants.CENTER);
		frmStatistikaKlijent.getContentPane().add(lblIzaberiteAnketu, BorderLayout.NORTH);
	}
}