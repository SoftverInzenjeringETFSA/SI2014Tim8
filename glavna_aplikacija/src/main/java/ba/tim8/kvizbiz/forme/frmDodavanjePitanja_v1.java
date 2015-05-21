package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class frmDodavanjePitanja_v1 extends JFrame {

	public static int test;
	
	private JPanel contentPane;
	private JTextField tbxTekstPitanja;
	private JComboBox cbbTipPitanja;
	private JCheckBox ckbObaveznoPitanje;
	
	private JPanel pnlPitanjePonudjeniOdgovori;
	private JPanel pnlPitanjeVisestrukiIzbor;
	
	private JButton btnDodajIzbor;
	private JButton btnUkloniIzbor;
	private JButton btnDodajOdgovor;
	private JButton btnUkloniOdgovor;
	
	// Ove varijable se koriste za monitoring broja Izbora/Odgovora
	private int brojIzbor = 1;
	private ArrayList<JLabel> labeleIzbor;
	private ArrayList<JTextField> tbxiIzbor;
	private int brojOdgovor = 1;
	private ArrayList<JLabel> labeleOdgovor;
	private ArrayList<JTextField> tbxiOdgovor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDodavanjePitanja_v1 frame = new frmDodavanjePitanja_v1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmDodavanjePitanja_v1() {
		test = 3;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JPanel pnlPitanje = new JPanel(new BorderLayout());
		contentPane.add(pnlPitanje, BorderLayout.CENTER);
		
		JPanel pnlPodaci = new JPanel(new GridBagLayout());
		pnlPodaci.setBorder(new CompoundBorder(new TitledBorder(null, "Unesite podatke o pitanju:"), new EmptyBorder(10, 10, 10, 10)));
		pnlPitanje.add(pnlPodaci, BorderLayout.PAGE_START);
		
		GridBagConstraints gbcPodaci = new GridBagConstraints();
		
		gbcPodaci.gridx = 0;
		gbcPodaci.gridy = 0;
		gbcPodaci.insets = new Insets(5, 10, 5, 10);
		gbcPodaci.anchor = GridBagConstraints.LINE_END;
		pnlPodaci.add(new JLabel("Tekst pitanja: "), gbcPodaci);
		
		gbcPodaci.gridy++;
		//pnlPodaci.add(new JLabel("Tip pitanja: "), gbcPodaci);
		
		gbcPodaci.gridy++;
		//pnlPodaci.add(new JLabel("Obavezno pitanje: "), gbcPodaci);
		
		gbcPodaci.gridy = 0;
		gbcPodaci.gridx++;
		gbcPodaci.anchor = GridBagConstraints.LINE_START;
		tbxTekstPitanja = new JTextField();
		tbxTekstPitanja.setColumns(12);
		//pnlPodaci.add(tbxTekstPitanja, gbcPodaci);
		
		gbcPodaci.gridy++;
		cbbTipPitanja = new JComboBox();
		cbbTipPitanja.addItem("Pitanje s ponuđenim odgovorima");
		cbbTipPitanja.addItem("Pitanje s otvorenim odgovorom");
		cbbTipPitanja.addItem("Pitanje s višestrukim izborom");
		cbbTipPitanja.addItem("Tačno/netačno pitanje");
		cbbTipPitanja.addItem("Da/ne pitanje");
		//pnlPodaci.add(cbbTipPitanja, gbcPodaci);
		
		gbcPodaci.gridy++;
		ckbObaveznoPitanje = new JCheckBox();
		//pnlPodaci.add(ckbObaveznoPitanje, gbcPodaci);
		
		JPanel pnlPitanjePonudjeniOdgovor = new JPanel(new GridBagLayout());
		pnlPitanjePonudjeniOdgovor.setBorder(new CompoundBorder(new TitledBorder(null, "Unesite podatke o pitanju:"), new EmptyBorder(10, 10, 10, 10)));
		//JScrollPane scrollOdgovor = new JScrollPane(pnlPitanjePonudjeniOdgovor);
		//pnlPitanje.add(scrollOdgovor, BorderLayout.CENTER);
		
		GridBagConstraints btnTipovi = new GridBagConstraints();
		
		btnTipovi.gridx = 2;
		btnTipovi.gridy = 10;
		btnTipovi.anchor = GridBagConstraints.NORTH;
		btnTipovi.fill = GridBagConstraints.VERTICAL;
		btnTipovi.insets = new Insets(10, 10, 10, 10);
		btnDodajOdgovor = new JButton("Dodaj pitanje");
		pnlPitanjePonudjeniOdgovor.add(btnDodajOdgovor, btnTipovi);
		
		btnTipovi.gridx++;
		btnUkloniOdgovor = new JButton("Ukloni odgovor");
		//pnlPitanjePonudjeniOdgovor.add(btnUkloniOdgovor, btnTipovi);
		
		JPanel pnlButtoniVanjska = new JPanel(new BorderLayout());
		pnlPitanje.add(pnlButtoniVanjska, BorderLayout.PAGE_END);
		
		JPanel pnlButtoni = new JPanel(new GridBagLayout());
		pnlButtoniVanjska.add(pnlButtoni, BorderLayout.EAST);
		
		GridBagConstraints gbcButtoni = new GridBagConstraints();
		
		gbcButtoni.gridx = 0;
		gbcButtoni.gridy = 0;
		gbcButtoni.insets = new Insets(15, 15, 15, 15);
		JButton btnOtkazi = new JButton("Otkaži");
		btnOtkazi.setPreferredSize(new Dimension(90, 23));
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDodavanjePitanja_v2 lala = new frmDodavanjePitanja_v2();
				lala.setVisible(true);
				dispose();
			}
		});
		pnlButtoni.add(btnOtkazi, gbcButtoni);
		
		gbcButtoni.gridx++;
		JButton btnOK = new JButton("OK");
		btnOK.setPreferredSize(new Dimension(90, 23));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//pnlButtoni.add(btnOK, gbcButtoni);
		
		JButton btnStatus = new JButton("Statusna traka");
		btnStatus.setEnabled(false);
		btnStatus.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatus.setForeground(SystemColor.textHighlight);
		contentPane.add(btnStatus, BorderLayout.SOUTH);
		
		/*
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		//gbc.anchor = GridBagConstraints.
		JPanel pnlPitanje = new JPanel();
		contentPane.add(pnlPitanje, gbc);
		
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.weighty = 0.0;
		JButton btnOtkazi = new JButton("Otkaži");
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnOtkazi, gbc);
		
		gbc.gridx++;
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnOK, gbc);
		
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		JButton btnStatus = new JButton("Statusna traka");
		btnStatus.setEnabled(false);
		btnStatus.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatus.setForeground(SystemColor.textHighlight);
		contentPane.add(btnStatus, gbc);
		*/
	}

}
