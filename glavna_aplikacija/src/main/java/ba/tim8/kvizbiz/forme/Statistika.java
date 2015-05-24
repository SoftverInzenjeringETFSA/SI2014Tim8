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

public class Statistika extends JFrame {
	
	//TODO: Rename obavezan, cuj glavna forma forma statistike (rename i u klasi Menu!!!)
	
	private JFrame frmGlavnaForma;
	
	public JFrame getFrmGlavnaForma() {
		return frmGlavnaForma;
	}

	public void setFrmGlavnaForma(JFrame frmGlavnaForma) {
		this.frmGlavnaForma = frmGlavnaForma;
	}

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
					Statistika window = new Statistika();
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
	public Statistika() {
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
		
		
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmGlavnaForma.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		final JScrollPane scrollPane = new JScrollPane();
		frmGlavnaForma.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		final JComboBox comboBox = new JComboBox();
		scrollPane.setColumnHeaderView(comboBox);
		
		final KvizDao kdao = KvizDao.get();
		Collection<Kviz> kvizovi = kdao.readAll();

		Kviz kviz = new Kviz();
		for (Iterator<Kviz> iterator = kvizovi.iterator(); iterator
				.hasNext();) {
			kviz = (Kviz) iterator.next();
			comboBox.addItem(kviz);
		}
		
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Implement
								
				String tekst = "";
				Kviz tmp = (Kviz) comboBox.getSelectedItem();
				tekst += "  Ukupno popunjenih anketa: "+String.valueOf(tmp.get_klijenti().size())+"\n";
				
				
			    
				JPanel panelUkupno = new JPanel();
				panelUkupno.setLayout(new BorderLayout(0, 0));
				Set<Pitanje> pitanja = tmp.get_pitanja();
				int brojac = 1;
				for(Pitanje p:pitanja){
					if(p.get_tipPitanja().equals(TipPitanja.OtvoreniOdgovor))
						continue;
					tekst +="\n    "+brojac+". "+p.get_tekstPitanja()+"\n";
					Set<Odgovor> odgovori = p.get_listaOdgovora();
					int count = 1;
					for(Odgovor o:odgovori){
						int brOdgovora = o.get_klijenti().size();
						int ukOdgovora=tmp.get_klijenti().size();
						Double postotak = Double.valueOf(brOdgovora)/Double.valueOf(ukOdgovora);
						postotak *= 100;
						tekst += "        "+count+". "+o.get_tekstOdgovora()+" - "+String.format("%.2f",postotak)+"% ("+brOdgovora+" od "+ukOdgovora+")\n";
						count++;
					}
					brojac++;
				}
				textArea.setText(tekst);
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
				textArea.setEnabled(false);
				textArea.setDisabledTextColor(Color.black);
			}});
		
		JLabel lblIzaberiteAnketu = new JLabel("Izaberite anketu:");
		lblIzaberiteAnketu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIzaberiteAnketu.setHorizontalAlignment(SwingConstants.CENTER);
		frmGlavnaForma.getContentPane().add(lblIzaberiteAnketu, BorderLayout.NORTH);
	}
}