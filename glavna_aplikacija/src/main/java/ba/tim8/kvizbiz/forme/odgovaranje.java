package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.MatteBorder;

import ba.tim8.kvizbiz.dao.OdgovorDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.TipPitanja;

public class odgovaranje {

	private JFrame frmPopunjavanjeAnkete;
	private final JProgressBar progressBar = new JProgressBar();
	private final JPanel panelBrojPitanja = new JPanel();
	private int ukupnoPitanja;
	private List lista;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					odgovaranje window = new odgovaranje(1);
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
	public odgovaranje(long kvizID) {
		initialize(kvizID);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(long kvizID) {
		
		frmPopunjavanjeAnkete = new JFrame();
		frmPopunjavanjeAnkete.setTitle("Popunjavanje ankete");
		frmPopunjavanjeAnkete.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MuhamedMujic\\Desktop\\ikonaKviz.png"));
		frmPopunjavanjeAnkete.setBounds(100, 100, 450, 372);
		frmPopunjavanjeAnkete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//long ID = Long.valueOf(kvizID).longValue();
		//PitanjeDao pdao = PitanjeDao.get();
		//Collection<Pitanje> pitanja = pdao.dajPitanja(ID);

		Collection<Pitanje> pitanja = new HashSet<Pitanje>();
		Pitanje p = new Pitanje();
		p.set_id(1);
		try {
			p.set_tekstPitanja("Tvoje misljenje");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p.set_tipPitanja(TipPitanja.OtvoreniOdgovor);
		pitanja.add(p);
		Pitanje p2 = new Pitanje();
		p2.set_id(2);
		try {
			p2.set_tekstPitanja("Zasto je to tako");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p2.set_tipPitanja(TipPitanja.OtvoreniOdgovor);
		pitanja.add(p2);
		
		Pitanje p3 = new Pitanje();
		p3.set_id(3);
		try {
			p3.set_tekstPitanja("Nije to za tebe jer");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p3.set_tipPitanja(TipPitanja.OtvoreniOdgovor);
		pitanja.add(p3);
		
		Pitanje p4 = new Pitanje();
		p4.set_id(4);
		try {
			p4.set_tekstPitanja("Evo naprimjer ja");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p4.set_tipPitanja(TipPitanja.OtvoreniOdgovor);
		pitanja.add(p4);
		
		Pitanje p5 = new Pitanje();
		p5.set_id(5);
		try {
			p5.set_tekstPitanja("Da li je");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p5.set_tipPitanja(TipPitanja.DaNE);
		pitanja.add(p5);
		
		Pitanje p6 = new Pitanje();
		p6.set_id(6);
		try {
			p6.set_tekstPitanja("Tacno ili netacno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p6.set_tipPitanja(TipPitanja.TacnoNetacno);
		pitanja.add(p6);
		
		Pitanje p7 = new Pitanje();
		p7.set_id(7);
		try {
			p7.set_tekstPitanja("Odaberite višestruki izbor");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p7.set_tipPitanja(TipPitanja.VisestrukiIzbor);
		pitanja.add(p7);
		
		Pitanje p8 = new Pitanje();
		p8.set_id(8);
		try {
			p8.set_tekstPitanja("Odaberite jedan od ponudjenih odgovora abc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p8.set_tipPitanja(TipPitanja.Abc);
		pitanja.add(p8);
		
		ukupnoPitanja = pitanja.size();
		
		lista = new ArrayList(pitanja);
		postaviPitanje((Pitanje) lista.get(0), 0);		
	}
	private void postaviPitanje(Pitanje pitanje, int indeks) {
		if(pitanje.get_tipPitanja().equals(TipPitanja.Abc)){
			ucitajAbc(pitanje, indeks);
		}else if(pitanje.get_tipPitanja().equals(TipPitanja.DaNE)){
			ucitajDaNe(pitanje, indeks);
		}else if(pitanje.get_tipPitanja().equals(TipPitanja.OtvoreniOdgovor)){
			ucitajOtvoreniOdgovor(pitanje, indeks);
		}else if(pitanje.get_tipPitanja().equals(TipPitanja.TacnoNetacno)){
			ucitajTacnoNetacno(pitanje, indeks);
		}else if(pitanje.get_tipPitanja().equals(TipPitanja.VisestrukiIzbor)){
			ucitajVisestrukiIzbor(pitanje, indeks);
		}else{
			//Greška
		}
	}

	private void ucitajVisestrukiIzbor(Pitanje pitanje, final int broj) {
		//Odgovor odg = new Odgovor();
		//OdgovorDao odao = OdgovorDao.get();
		//List odgovori = odao.dajOdgovore((int) pitanje.get_id());
		
		List odgovori = new ArrayList();
		
		Odgovor odg = new Odgovor();
		odg.set_id(1);
		odg.set_pitanje((Pitanje) lista.get(6));
		try {
			odg.set_tekstOdgovora("Odgovor a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		odgovori.add(odg);
		
		Odgovor odg2 = new Odgovor();
		odg2.set_id(2);
		odg2.set_pitanje((Pitanje) lista.get(6));
		try {
			odg2.set_tekstOdgovora("Odgovor b");
		} catch (Exception e) {
			e.printStackTrace();
		}
		odgovori.add(odg2);
		
		Odgovor odg3 = new Odgovor();
		odg3.set_id(3);
		odg3.set_pitanje((Pitanje) lista.get(6));
		try {
			odg3.set_tekstOdgovora("Odgovor c");
		} catch (Exception e) {
			e.printStackTrace();
		}
		odgovori.add(odg3);
		
		Odgovor odg4 = new Odgovor();
		odg4.set_id(4);
		odg4.set_pitanje((Pitanje) lista.get(6));
		try {
			odg4.set_tekstOdgovora("Odgovor d");
		} catch (Exception e) {
			e.printStackTrace();
		}
		odgovori.add(odg4);
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBorder(null);
		frmPopunjavanjeAnkete.getContentPane().add(panelStatus, BorderLayout.SOUTH);
		GridBagLayout gbl_panelStatus = new GridBagLayout();
		gbl_panelStatus.columnWidths = new int[] {432, 0};
		gbl_panelStatus.rowHeights = new int[] {35, 25};
		gbl_panelStatus.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelStatus.rowWeights = new double[]{0.0, 0.0};
		panelStatus.setLayout(gbl_panelStatus);
		progressBar.setPreferredSize(new Dimension(246, 14));
		progressBar.setToolTipText("Napredak odgovaranja");
		progressBar.setValue(broj+1);
		progressBar.setMaximum(ukupnoPitanja);
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
		panelPitanje.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frmPopunjavanjeAnkete.getContentPane().add(panelPitanje, BorderLayout.CENTER);
		SpringLayout sl_panelPitanje = new SpringLayout();
		panelPitanje.setLayout(sl_panelPitanje);
		
		JLabel lblPitanje = new JLabel(pitanje.get_tekstPitanja());
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, lblPitanje, 10, SpringLayout.NORTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, lblPitanje, 103, SpringLayout.WEST, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, lblPitanje, 39, SpringLayout.NORTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, lblPitanje, -87, SpringLayout.EAST, panelPitanje);
		lblPitanje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPitanje.add(lblPitanje);
		
		final JPanel panelOdgovor = new JPanel();
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, panelOdgovor, 6, SpringLayout.SOUTH, lblPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, panelOdgovor, 0, SpringLayout.WEST, lblPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, panelOdgovor, -76, SpringLayout.SOUTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, panelOdgovor, -87, SpringLayout.EAST, panelPitanje);
		panelOdgovor.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panelPitanje.add(panelOdgovor);
		panelOdgovor.setLayout(null);
		
		JButton btnNaprijed = new JButton("Naprijed");
		panelPitanje.add(btnNaprijed);
		btnNaprijed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCheckBox tmp = new JCheckBox();
				for(int i=0; i < panelOdgovor.getComponentCount(); i++){
					tmp = (JCheckBox) panelOdgovor.getComponent(i);
					if(tmp.isSelected()){
						JOptionPane.showMessageDialog(null,
								tmp.getText(),
								"Registracija klijenta",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				if(broj+1 < ukupnoPitanja){
					frmPopunjavanjeAnkete.getContentPane().removeAll();
					panelBrojPitanja.removeAll();
					postaviPitanje((Pitanje) lista.get(broj+1), broj+1);
					panelBrojPitanja.revalidate();
					panelBrojPitanja.repaint();
					frmPopunjavanjeAnkete.validate();
					frmPopunjavanjeAnkete.repaint();
				}else{
					JOptionPane.showMessageDialog(null,
							"Kviz uspješno popunjen.",
							"Registracija klijenta",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		JButton btnNazad = new JButton("Nazad");
		sl_panelPitanje.putConstraint(SpringLayout.WEST, btnNazad, 195, SpringLayout.WEST, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNazad, -166, SpringLayout.EAST, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, btnNaprijed, 0, SpringLayout.NORTH, btnNazad);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, btnNaprijed, 6, SpringLayout.EAST, btnNazad);
		btnNazad.setMargin(new Insets(2, 5, 2, 5));
		
		/*JCheckBox chckbxDeterdent = new JCheckBox("Deterd\u017Eent");
		chckbxDeterdent.setSelected(true);
		chckbxDeterdent.setBounds(6, 7, 97, 23);
		panelOdgovor.add(chckbxDeterdent);
		
		JCheckBox chckbxTjestenina = new JCheckBox("Tjestenina");
		chckbxTjestenina.setBounds(6, 33, 97, 23);
		panelOdgovor.add(chckbxTjestenina);
		
		JCheckBox chckbxMlijeko = new JCheckBox("Mlijeko");
		chckbxMlijeko.setBounds(6, 59, 97, 23);
		panelOdgovor.add(chckbxMlijeko);
		
		JCheckBox chckbxKozmetika = new JCheckBox("Kozmetika");
		chckbxKozmetika.setBounds(6, 85, 97, 23);
		panelOdgovor.add(chckbxKozmetika);
		
		JCheckBox chckbxHljeb = new JCheckBox("Hljeb");
		chckbxHljeb.setBounds(6, 111, 97, 23);
		panelOdgovor.add(chckbxHljeb);*/
		
		int dim = 0;
		Odgovor tmp = new Odgovor();
		for(int i=0; i < odgovori.size(); i++){
			tmp = (Odgovor) odgovori.get(i);
			JCheckBox checkBox = new JCheckBox(tmp.get_tekstOdgovora());
			checkBox.setBounds(6, dim, 97, 23);
			panelOdgovor.add(checkBox);
			dim += 25;
		}
		
		panelPitanje.add(btnNazad);
		
		JLabel lblpitanjeJeObavezno = new JLabel("*Pitanje je obavezno");
		lblpitanjeJeObavezno.setForeground(new Color(255, 0, 0));
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, lblpitanjeJeObavezno, -10, SpringLayout.SOUTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, lblpitanjeJeObavezno, -157, SpringLayout.EAST, panelPitanje);
		panelPitanje.add(lblpitanjeJeObavezno);
		
		JSeparator separator = new JSeparator();
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, btnNazad, -10, SpringLayout.NORTH, separator);
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, separator, -8, SpringLayout.NORTH, lblpitanjeJeObavezno);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, lblPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, lblPitanje);
		separator.setPreferredSize(new Dimension(300, 2));
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, separator, -6, SpringLayout.NORTH, lblpitanjeJeObavezno);
		panelPitanje.add(separator);
		panelBrojPitanja.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frmPopunjavanjeAnkete.getContentPane().add(panelBrojPitanja, BorderLayout.NORTH);
		GridBagLayout gbl_panelBrojPitanja = new GridBagLayout();
		gbl_panelBrojPitanja.columnWidths = new int[] {438};
		gbl_panelBrojPitanja.rowHeights = new int[] {40};
		gbl_panelBrojPitanja.columnWeights = new double[]{0.0};
		gbl_panelBrojPitanja.rowWeights = new double[]{0.0};
		panelBrojPitanja.setLayout(gbl_panelBrojPitanja);
		
		JLabel lblPitanjeBroj = new JLabel("Pitanje broj "+String.valueOf(broj+1)+".");
		lblPitanjeBroj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPitanjeBroj = new GridBagConstraints();
		gbc_lblPitanjeBroj.gridx = 0;
		gbc_lblPitanjeBroj.gridy = 0;
		panelBrojPitanja.add(lblPitanjeBroj, gbc_lblPitanjeBroj);
		
	}

	private void ucitajTacnoNetacno(Pitanje p, final int broj) {
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
		progressBar.setValue(broj+1);
		progressBar.setMaximum(ukupnoPitanja);
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
		
		JLabel lblPitanje = new JLabel(p.get_tekstPitanja());
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
		
		ButtonGroup btngr = new ButtonGroup();
		JRadioButton radioBtnDa = new JRadioButton("Tacno");
		radioBtnDa.setBounds(6, 7, 200, 41);
		radioBtnDa.setSelected(true);
		panelOdgovor.add(radioBtnDa);
		
		JRadioButton radioBtnNe = new JRadioButton("Netacno");
		radioBtnNe.setBounds(6, 51, 200, 41);
		panelOdgovor.add(radioBtnNe);
		btngr.add(radioBtnDa);
		btngr.add(radioBtnNe);
		
		JButton btnNaprijed = new JButton("Naprijed");
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, btnNaprijed, 6, SpringLayout.SOUTH, panelOdgovor);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNaprijed, 0, SpringLayout.EAST, lblPitanje);
		panelPitanje.add(btnNaprijed);
		btnNaprijed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(broj+1 < ukupnoPitanja){
					frmPopunjavanjeAnkete.getContentPane().removeAll();
					panelBrojPitanja.removeAll();
					postaviPitanje((Pitanje) lista.get(broj+1), broj+1);
					panelBrojPitanja.revalidate();
					panelBrojPitanja.repaint();
					frmPopunjavanjeAnkete.validate();
					frmPopunjavanjeAnkete.repaint();
				}else{
					JOptionPane.showMessageDialog(null,
							"Kviz uspješno popunjen.",
							"Registracija klijenta",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
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
		
		JLabel lblPitanjeBroj = new JLabel("Pitanje broj "+String.valueOf(broj+1)+".");
		lblPitanjeBroj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPitanjeBroj = new GridBagConstraints();
		gbc_lblPitanjeBroj.gridx = 0;
		gbc_lblPitanjeBroj.gridy = 0;
		panelBrojPitanja.add(lblPitanjeBroj, gbc_lblPitanjeBroj);
	}

	private void ucitajOtvoreniOdgovor(final Pitanje pitanje, final int broj) {
		
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
		
		progressBar.setValue(broj+1);
		progressBar.setMaximum(ukupnoPitanja);
		
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
		
		JLabel lblPitanje = new JLabel(pitanje.get_tekstPitanja());
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, lblPitanje, 10, SpringLayout.NORTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, lblPitanje, 103, SpringLayout.WEST, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, lblPitanje, 39, SpringLayout.NORTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, lblPitanje, -87, SpringLayout.EAST, panelPitanje);
		lblPitanje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPitanje.add(lblPitanje);
		
		JPanel panelOdgovor = new JPanel();
		panelOdgovor.setBorder(null);
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, panelOdgovor, 6, SpringLayout.SOUTH, lblPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, panelOdgovor, 0, SpringLayout.WEST, lblPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, panelOdgovor, -57, SpringLayout.SOUTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, panelOdgovor, -87, SpringLayout.EAST, panelPitanje);
		panelPitanje.add(panelOdgovor);
		panelOdgovor.setLayout(null);
		
		JButton btnNaprijed = new JButton("Naprijed");
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, btnNaprijed, -10, SpringLayout.SOUTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNaprijed, 0, SpringLayout.EAST, lblPitanje);
		panelPitanje.add(btnNaprijed);
		btnNaprijed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(broj+1 < ukupnoPitanja){
					frmPopunjavanjeAnkete.getContentPane().removeAll();
					panelBrojPitanja.removeAll();
					postaviPitanje((Pitanje) lista.get(broj+1), broj+1);
					panelBrojPitanja.revalidate();
					panelBrojPitanja.repaint();
					frmPopunjavanjeAnkete.validate();
					frmPopunjavanjeAnkete.repaint();
				}else{
					JOptionPane.showMessageDialog(null,
							"Kviz uspješno popunjen.",
							"Registracija klijenta",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnNazad = new JButton("Nazad");
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, btnNazad, 0, SpringLayout.NORTH, btnNaprijed);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, btnNazad, 193, SpringLayout.WEST, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNazad, -8, SpringLayout.WEST, btnNaprijed);
		btnNazad.setMargin(new Insets(2, 5, 2, 5));
		
		JTextArea txtAreaOdgovor = new JTextArea();
		txtAreaOdgovor.setBounds(0, 0, 244, 143);
		panelOdgovor.add(txtAreaOdgovor);
		panelPitanje.add(btnNazad);
		
		JSeparator separator = new JSeparator();
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, separator, 6, SpringLayout.SOUTH, panelOdgovor);
		sl_panelPitanje.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, lblPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, separator, 8, SpringLayout.SOUTH, panelOdgovor);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, lblPitanje);
		separator.setPreferredSize(new Dimension(200, 2));
		panelPitanje.add(separator);
		panelBrojPitanja.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frmPopunjavanjeAnkete.getContentPane().add(panelBrojPitanja, BorderLayout.NORTH);
		GridBagLayout gbl_panelBrojPitanja = new GridBagLayout();
		gbl_panelBrojPitanja.columnWidths = new int[] {438};
		gbl_panelBrojPitanja.rowHeights = new int[] {40};
		gbl_panelBrojPitanja.columnWeights = new double[]{0.0};
		gbl_panelBrojPitanja.rowWeights = new double[]{0.0};
		panelBrojPitanja.setLayout(gbl_panelBrojPitanja);
		
		String tmp = "Pitanje broj "+String.valueOf(broj+1)+".";
		JLabel lblPitanjeBroj = new JLabel(tmp);
		lblPitanjeBroj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPitanjeBroj = new GridBagConstraints();
		gbc_lblPitanjeBroj.gridx = 0;
		gbc_lblPitanjeBroj.gridy = 0;
		panelBrojPitanja.add(lblPitanjeBroj, gbc_lblPitanjeBroj);
	}

	private void ucitajAbc(Pitanje p, final int broj){
		//OdgovorDao odao = OdgovorDao.get();
		//List odgovori = odao.dajOdgovore((int) pitanje.get_id());
		
		List odgovori = new ArrayList();
		
		Odgovor odg = new Odgovor();
		odg.set_id(1);
		odg.set_pitanje((Pitanje) lista.get(6));
		try {
			odg.set_tekstOdgovora("Odgovor a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		odgovori.add(odg);
		
		Odgovor odg2 = new Odgovor();
		odg2.set_id(2);
		odg2.set_pitanje((Pitanje) lista.get(6));
		try {
			odg2.set_tekstOdgovora("Odgovor b");
		} catch (Exception e) {
			e.printStackTrace();
		}
		odgovori.add(odg2);
		
		Odgovor odg3 = new Odgovor();
		odg3.set_id(3);
		odg3.set_pitanje((Pitanje) lista.get(6));
		try {
			odg3.set_tekstOdgovora("Odgovor c");
		} catch (Exception e) {
			e.printStackTrace();
		}
		odgovori.add(odg3);
		
		Odgovor odg4 = new Odgovor();
		odg4.set_id(4);
		odg4.set_pitanje((Pitanje) lista.get(6));
		try {
			odg4.set_tekstOdgovora("Odgovor d");
		} catch (Exception e) {
			e.printStackTrace();
		}
		odgovori.add(odg4);
		
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
		progressBar.setValue(broj+1);
		progressBar.setMaximum(ukupnoPitanja);
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
		
		JLabel lblPitanje = new JLabel(p.get_tekstPitanja());
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
		
		/*JRadioButton rdbtnRijetko = new JRadioButton("Rijetko");
		rdbtnRijetko.setBounds(6, 7, 200, 41);
		panelOdgovor.add(rdbtnRijetko);
		
		JRadioButton rdbtnUobiajeno = new JRadioButton("Uobi\u010Dajeno");
		rdbtnUobiajeno.setBounds(6, 51, 200, 41);
		panelOdgovor.add(rdbtnUobiajeno);
		
		JRadioButton rdbtnesto = new JRadioButton("\u010Cesto");
		rdbtnesto.setBounds(6, 95, 200, 41);
		panelOdgovor.add(rdbtnesto);*/
		
		int dim = 0;
		Odgovor tmp = new Odgovor();
		ButtonGroup btnGrOdg = new ButtonGroup();
		for(int i=0; i < odgovori.size(); i++){
			tmp = (Odgovor) odgovori.get(i);
			JRadioButton radioButton = new JRadioButton(tmp.get_tekstOdgovora());
			radioButton.setBounds(6, dim, 97, 23);
			panelOdgovor.add(radioButton);
			btnGrOdg.add(radioButton);
			dim += 30;
			if(i == 0){
				radioButton.setSelected(true);
			}
		}
		
		JButton btnNaprijed = new JButton("Naprijed");
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, btnNaprijed, 6, SpringLayout.SOUTH, panelOdgovor);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNaprijed, 0, SpringLayout.EAST, lblPitanje);
		panelPitanje.add(btnNaprijed);
		btnNaprijed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(broj+1 < ukupnoPitanja){
					frmPopunjavanjeAnkete.getContentPane().removeAll();
					panelBrojPitanja.removeAll();
					postaviPitanje((Pitanje) lista.get(broj+1), broj+1);
					panelBrojPitanja.revalidate();
					panelBrojPitanja.repaint();
					frmPopunjavanjeAnkete.validate();
					frmPopunjavanjeAnkete.repaint();
				}else{
					JOptionPane.showMessageDialog(null,
							"Kviz uspješno popunjen.",
							"Registracija klijenta",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
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
		
		JLabel lblPitanjeBroj = new JLabel("Pitanje broj "+String.valueOf(broj+1)+".");
		lblPitanjeBroj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPitanjeBroj = new GridBagConstraints();
		gbc_lblPitanjeBroj.gridx = 0;
		gbc_lblPitanjeBroj.gridy = 0;
		panelBrojPitanja.add(lblPitanjeBroj, gbc_lblPitanjeBroj);
	}
	
	private void ucitajDaNe(Pitanje p, final int broj){
		//Implementiraj
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
		progressBar.setValue(broj+1);
		progressBar.setMaximum(ukupnoPitanja);
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
		
		JLabel lblPitanje = new JLabel(p.get_tekstPitanja());
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
		
		ButtonGroup btngr = new ButtonGroup();
		JRadioButton radioBtnDa = new JRadioButton("Da");
		radioBtnDa.setBounds(6, 7, 200, 41);
		radioBtnDa.setSelected(true);
		panelOdgovor.add(radioBtnDa);
		
		JRadioButton radioBtnNe = new JRadioButton("Ne");
		radioBtnNe.setBounds(6, 51, 200, 41);
		panelOdgovor.add(radioBtnNe);
		btngr.add(radioBtnDa);
		btngr.add(radioBtnNe);
		
		JButton btnNaprijed = new JButton("Naprijed");
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, btnNaprijed, 6, SpringLayout.SOUTH, panelOdgovor);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNaprijed, 0, SpringLayout.EAST, lblPitanje);
		panelPitanje.add(btnNaprijed);
		btnNaprijed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(broj+1 < ukupnoPitanja){
					frmPopunjavanjeAnkete.getContentPane().removeAll();
					panelBrojPitanja.removeAll();
					postaviPitanje((Pitanje) lista.get(broj+1), broj+1);
					panelBrojPitanja.revalidate();
					panelBrojPitanja.repaint();
					frmPopunjavanjeAnkete.validate();
					frmPopunjavanjeAnkete.repaint();
				}else{
					JOptionPane.showMessageDialog(null,
							"Kviz uspješno popunjen.",
							"Registracija klijenta",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
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
		
		JLabel lblPitanjeBroj = new JLabel("Pitanje broj "+String.valueOf(broj+1)+".");
		lblPitanjeBroj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPitanjeBroj = new GridBagConstraints();
		gbc_lblPitanjeBroj.gridx = 0;
		gbc_lblPitanjeBroj.gridy = 0;
		panelBrojPitanja.add(lblPitanjeBroj, gbc_lblPitanjeBroj);
	}
}
