package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import org.apache.log4j.Logger;

import ba.tim8.kvizbiz.dao.KlijentDao;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.OdgovorDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.TipPitanja;

public class odgovaranje {
	final static Logger logger = Logger.getLogger(RegistracijaKlijenta.class);
	private JFrame frmPopunjavanjeAnkete;
	public JFrame getFrmPopunjavanjeAnkete() {
		return frmPopunjavanjeAnkete;
	}

	public void setFrmPopunjavanjeAnkete(JFrame frmPopunjavanjeAnkete) {
		this.frmPopunjavanjeAnkete = frmPopunjavanjeAnkete;
	}

	private final JProgressBar progressBar = new JProgressBar();
	private final JPanel panelBrojPitanja = new JPanel();
	private int ukupnoPitanja;
	private List lista;
	private Klijent klijent;
	private HashSet<Odgovor> realOdgovori;
	private JLabel lblStatus;
	private JTextArea txtAreaOdgovor;
	private long idKviz;
	
	/**
	 * Create the application.
	 */
	public odgovaranje(long kvizID) {
		idKviz = kvizID;
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
		
		realOdgovori = new HashSet<Odgovor>();
		//klijent = new Klijent();
		klijent = RegistracijaKlijenta.logiraniKlijent;
		//klijent=KlijentDao.get().read(76);
		if(klijent==null)
		{
			try {
				throw new Exception("Sve je isto samo njega nema");
			} catch (Exception e) {
				logger.error("Greska: ", e);
			}
		}
		KvizDao kdao = KvizDao.get();
		Kviz kviz = kdao.read(kvizID);
		Collection<Pitanje> pitanja = kviz.get_pitanja();
				ukupnoPitanja = pitanja.size();
		
		lista = new ArrayList(pitanja);
		Collections.sort(lista, new Comparator() {
			public int compare(Object synchronizedListOne, Object synchronizedListTwo) {
			//use instanceof to verify the references are indeed of the type in question
			long id1=((Pitanje)synchronizedListOne).get_id();
			long id2=((Pitanje)synchronizedListTwo).get_id();
			if(id1>id2){
				return 1;
			}else if(id1==id2){
				return 0;
			}else{
				return -1;
			}
			}}); 
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

	private void ucitajVisestrukiIzbor(final Pitanje pitanje, final int broj) {
		Collection<Odgovor> odgs = pitanje.get_listaOdgovora();
		List odgovori = new ArrayList(odgs);
		
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
		
		lblStatus = new JLabel("Odgovaranje na pitanje "+String.valueOf(broj+1)+"/"+ String.valueOf(ukupnoPitanja));
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
				boolean empty = true;
				Set<Odgovor> predef = pitanje.get_listaOdgovora();
				for(Odgovor o:predef){
					for(int i=0; i < panelOdgovor.getComponentCount(); i++){
						tmp = (JCheckBox) panelOdgovor.getComponent(i);
						if(tmp.isSelected() && tmp.getText().equals(o.get_tekstOdgovora())){
							empty = false;
							realOdgovori.add(o);
						}
					}
				}
				if(pitanje.isObavezno() && empty){
					if(pitanje.isObavezno() && txtAreaOdgovor.getText().equals("")){
						lblStatus.setText("Odgovor ne smije biti prazan");
						lblStatus.setForeground(Color.red);
						return;
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
					klijent.set_listaOdgovora(realOdgovori);
					klijent.set_popunjeniKviz(pitanje.get_kviz());
					KlijentDao.get().update(klijent);
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
		
		int dim = 0;
		int visina = 390;
		Odgovor tmp = new Odgovor();
		for(int i=0; i < odgovori.size(); i++){
			tmp = (Odgovor) odgovori.get(i);
			JCheckBox checkBox = new JCheckBox(tmp.get_tekstOdgovora());
			checkBox.setBounds(6, dim, 97, 23);
			panelOdgovor.add(checkBox);
			dim += 25;
			if(i > 3){
				frmPopunjavanjeAnkete.setSize(450, visina);
				visina+=20;
			}
		}
		
		panelPitanje.add(btnNazad);
		
		
		JLabel lblpitanjeJeObavezno = new JLabel("*Pitanje je obavezno");
		lblpitanjeJeObavezno.setForeground(new Color(255, 0, 0));
		sl_panelPitanje.putConstraint(SpringLayout.SOUTH, lblpitanjeJeObavezno, -10, SpringLayout.SOUTH, panelPitanje);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, lblpitanjeJeObavezno, -157, SpringLayout.EAST, panelPitanje);
		if(pitanje.isObavezno()){
			panelPitanje.add(lblpitanjeJeObavezno);
		}
		
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

	private void ucitajTacnoNetacno(final Pitanje p, final int broj) {
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
		
		lblStatus = new JLabel("Odgovaranje na pitanje "+String.valueOf(broj+1)+"/"+ String.valueOf(ukupnoPitanja));;
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
		final JRadioButton radioBtnTacno = new JRadioButton("Tacno");
		radioBtnTacno.setBounds(6, 7, 200, 41);
		radioBtnTacno.setSelected(true);
		panelOdgovor.add(radioBtnTacno);
		
		final JRadioButton radioBtnNetacno = new JRadioButton("Netacno");
		radioBtnNetacno.setBounds(6, 51, 200, 41);
		panelOdgovor.add(radioBtnNetacno);
		btngr.add(radioBtnTacno);
		btngr.add(radioBtnNetacno);
		
		JButton btnNaprijed = new JButton("Naprijed");
		sl_panelPitanje.putConstraint(SpringLayout.NORTH, btnNaprijed, 6, SpringLayout.SOUTH, panelOdgovor);
		sl_panelPitanje.putConstraint(SpringLayout.EAST, btnNaprijed, 0, SpringLayout.EAST, lblPitanje);
		panelPitanje.add(btnNaprijed);
		btnNaprijed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioBtnTacno.isSelected()){
					Set<Odgovor> odgs = p.get_listaOdgovora();
					for(Odgovor o:odgs){
						if(o.get_tekstOdgovora().equals(radioBtnTacno.getText())){
							realOdgovori.add(o);
							break;
						}
					}
				}else{
					Set<Odgovor> odgs = p.get_listaOdgovora();
					for(Odgovor o:odgs){
						if(o.get_tekstOdgovora().equals(radioBtnNetacno.getText())){
							realOdgovori.add(o);
							break;
						}
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
					klijent.set_listaOdgovora(realOdgovori);
					klijent.set_popunjeniKviz(p.get_kviz());
					KlijentDao.get().update(klijent);
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
		
		lblStatus = new JLabel("Odgovaranje na pitanje "+String.valueOf(broj+1)+"/"+ String.valueOf(ukupnoPitanja));;
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
				if(pitanje.isObavezno() && txtAreaOdgovor.getText().equals("")){
					lblStatus.setText("Odgovor ne smije biti prazan");
					lblStatus.setForeground(Color.red);
					return;
				}
				Odgovor odg = new Odgovor();
				odg.set_pitanje(pitanje);
				try {
					odg.set_tekstOdgovora(txtAreaOdgovor.getText());
				} catch (Exception e) {
					logger.error("Greska: ", e);
				}
				OdgovorDao.get().create(odg);
				realOdgovori.add(odg);
				if(broj+1 < ukupnoPitanja){
					
					frmPopunjavanjeAnkete.getContentPane().removeAll();
					panelBrojPitanja.removeAll();
					postaviPitanje((Pitanje) lista.get(broj+1), broj+1);
					panelBrojPitanja.revalidate();
					panelBrojPitanja.repaint();
					frmPopunjavanjeAnkete.validate();
					frmPopunjavanjeAnkete.repaint();
				}else{
					klijent.set_listaOdgovora(realOdgovori);
					klijent.set_popunjeniKviz(pitanje.get_kviz());
					KlijentDao.get().update(klijent);
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
		
		txtAreaOdgovor = new JTextArea();
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

	private void ucitajAbc(final Pitanje p, final int broj){
		Collection<Odgovor> odgs = p.get_listaOdgovora();
		List odgovori = new ArrayList(odgs);
		
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
		
		lblStatus = new JLabel("Odgovaranje na pitanje "+String.valueOf(broj+1)+"/"+ String.valueOf(ukupnoPitanja));;
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
		
		int dim = 0;
		Odgovor tmp = new Odgovor();
		final ButtonGroup btnGrOdg = new ButtonGroup();
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
				for(Enumeration<AbstractButton> buttons = btnGrOdg.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button = buttons.nextElement();
		            if (button.isSelected()) {
		            	Set<Odgovor> odgs = p.get_listaOdgovora();
						for(Odgovor o:odgs){
							if(o.get_tekstOdgovora().equals(button.getText())){
								realOdgovori.add(o);
								break;
							}
						}
						break;
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
					klijent.set_listaOdgovora(realOdgovori);
					klijent.set_popunjeniKviz(p.get_kviz());
					KlijentDao.get().update(klijent);
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
	
	private void ucitajDaNe(final Pitanje p, final int broj){
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
		
		lblStatus = new JLabel("Odgovaranje na pitanje "+String.valueOf(broj+1)+"/"+ String.valueOf(ukupnoPitanja));;
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
		final JRadioButton radioBtnDa = new JRadioButton("Da");
		radioBtnDa.setBounds(6, 7, 200, 41);
		radioBtnDa.setSelected(true);
		panelOdgovor.add(radioBtnDa);
		
		final JRadioButton radioBtnNe = new JRadioButton("Ne");
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
				if(radioBtnDa.isSelected()){
					Set<Odgovor> odgs = p.get_listaOdgovora();
					for(Odgovor o:odgs){
						if(o.get_tekstOdgovora().equals(radioBtnDa.getText())){
							realOdgovori.add(o);
							break;
						}
					}
				}else{
					Set<Odgovor> odgs = p.get_listaOdgovora();
					for(Odgovor o:odgs){
						if(o.get_tekstOdgovora().equals(radioBtnNe.getText())){
							realOdgovori.add(o);
							break;
						}
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
					klijent.set_listaOdgovora(realOdgovori);
					klijent.set_popunjeniKviz(p.get_kviz());
					KlijentDao.get().update(klijent);
					prikaziKviz(frmPopunjavanjeAnkete);
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
	public void prikaziKviz(JFrame forma){
		forma.dispose();
		forma = new JFrame();
		forma.setVisible(true);
		forma.setTitle("Statistika po klijentima");
		forma.setBounds(100, 100, 430, 518);
		forma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forma.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		
		final JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		forma.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
				"Kviz uspješno popunjen.",
				"Registracija klijenta",
				JOptionPane.ERROR_MESSAGE);
				PocetnaKlijentZaKlijenta noviProzor = new PocetnaKlijentZaKlijenta();
				noviProzor.setVisible(true);
				frmPopunjavanjeAnkete.dispose();
			}});
		
		final JScrollPane scrollPane = new JScrollPane();
		forma.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.black);
		textArea.setBackground(forma.getBackground());
		

				Kviz anketa = KvizDao.get().read(idKviz);
				String tekst = "\n";
				tekst += "\tNaziv kviza: "+anketa.get_naziv()+"\n"; 
				Set<Pitanje> pitanja = anketa.get_pitanja();
				int count = 1;
				for(Pitanje p:pitanja){
					Set<Odgovor> odgs = klijent.get_listaOdgovora();
					tekst += "\n  "+count+". "+p.get_tekstPitanja()+"\n";
					for(Odgovor o:odgs){
						if(o.get_pitanje().equals(p)){
							tekst += "        "+o.get_tekstOdgovora()+"\n";
						}
					}
					count++;
				}
				textArea.setText(tekst);
		
	
	}
}
