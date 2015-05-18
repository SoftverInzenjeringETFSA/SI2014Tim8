package ba.tim8.kvizbiz.forme;

import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.TipPitanja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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

import antlr.collections.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;

public class DodavanjePitanja extends JFrame {

	private JFrame frmDodavanjePitanja;
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
	
	public JFrame get_frmDodavanjePitanja()
	{ 
		return frmDodavanjePitanja;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjePitanja window = new DodavanjePitanja();
					window.frmDodavanjePitanja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjePitanja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjePitanja = new JFrame();
		frmDodavanjePitanja.setTitle("Dodavanje pitanja");
		frmDodavanjePitanja.setBounds(100, 100, 600, 500);
		frmDodavanjePitanja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjePitanja.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmDodavanjePitanja);		
		
		JPanel panel1 = new JPanel();
		frmDodavanjePitanja.getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Unesite podatke o pitanju:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 564, 344);
		panel1.add(panel);
		panel.setLayout(null);
		
		pnlPitanjeVisestrukiIzbor = new JPanel();
		pnlPitanjeVisestrukiIzbor.setBorder(new TitledBorder(null, "Unesite podatke o pitanju s vi\u0161estrukim izborom:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPitanjeVisestrukiIzbor.setBounds(10, 107, 544, 226);
		pnlPitanjeVisestrukiIzbor.setVisible(false);
		
		pnlPitanjePonudjeniOdgovori = new JPanel();
		pnlPitanjePonudjeniOdgovori.setBorder(new TitledBorder(null, "Unesite novo pitanje s ponu\u0111enim odgovorima:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPitanjePonudjeniOdgovori.setBounds(10, 107, 544, 226);
		JScrollPane scroll = new JScrollPane(pnlPitanjePonudjeniOdgovori);
		scroll.setAutoscrolls(true);
		panel.add(scroll);
		pnlPitanjePonudjeniOdgovori.setLayout(null);
		
		btnDodajOdgovor = new JButton("Dodaj odgovor");
		btnDodajOdgovor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajOdgovor();
			}
		});
		btnDodajOdgovor.setBounds(185, 112, 158, 23);
		pnlPitanjePonudjeniOdgovori.add(btnDodajOdgovor);
		panel.add(pnlPitanjeVisestrukiIzbor);
		pnlPitanjeVisestrukiIzbor.setLayout(null);
		
		btnDodajIzbor = new JButton("Dodaj izbor");
		btnDodajIzbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajIzbor();
			}
		});
		btnDodajIzbor.setBounds(139, 112, 130, 23);
		pnlPitanjeVisestrukiIzbor.add(btnDodajIzbor);
		
		btnUkloniIzbor = new JButton("Ukloni izbor");
		btnUkloniIzbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (brojIzbor <= 3) {
					JOptionPane.showMessageDialog(null,"Minimalan broj izbora je dva!","Greška",JOptionPane.WARNING_MESSAGE);
					return;
				}
				pnlPitanjeVisestrukiIzbor.remove(labeleIzbor.get(labeleIzbor.size()-1));
				pnlPitanjeVisestrukiIzbor.remove(tbxiIzbor.get(tbxiIzbor.size()-1));
				labeleIzbor.remove(labeleIzbor.size()-1);
				tbxiIzbor.remove(tbxiIzbor.size()-1);
				btnDodajIzbor.setBounds(139, 37 + (brojIzbor-2) * 25, 140, 23);
				btnUkloniIzbor.setBounds(289, 37 + (brojIzbor-2) * 25, 140, 23);
				brojIzbor--;
				pnlPitanjeVisestrukiIzbor.repaint();
			}
		});
		btnUkloniIzbor.setBounds(279, 112, 130, 23);
		pnlPitanjeVisestrukiIzbor.add(btnUkloniIzbor);
		
		btnUkloniOdgovor = new JButton("Ukloni odgovor");
		btnUkloniOdgovor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (brojOdgovor <= 3) {
					JOptionPane.showMessageDialog(null,"Minimalan broj odgovora je dva!","Greška",JOptionPane.WARNING_MESSAGE);
					return;
				}
				pnlPitanjePonudjeniOdgovori.remove(labeleOdgovor.get(labeleOdgovor.size()-1));
				pnlPitanjePonudjeniOdgovori.remove(tbxiOdgovor.get(tbxiOdgovor.size()-1));
				labeleOdgovor.remove(labeleOdgovor.size()-1);
				tbxiOdgovor.remove(tbxiOdgovor.size()-1);
				btnDodajOdgovor.setBounds(139, 37 + (brojOdgovor-2) * 25, 140, 23);
				btnUkloniOdgovor.setBounds(289, 37 + (brojOdgovor-2) * 25, 140, 23);
				brojOdgovor--;
				pnlPitanjePonudjeniOdgovori.repaint();
			}
		});
		btnUkloniOdgovor.setBounds(289, 62, 140, 23);
		pnlPitanjePonudjeniOdgovori.add(btnUkloniOdgovor);
		
		JLabel lblTekst = new JLabel("Tekst:");
		lblTekst.setBounds(10, 28, 46, 14);
		panel.add(lblTekst);
		
		tbxTekstPitanja = new JTextField();
		tbxTekstPitanja.setBounds(66, 25, 488, 20);
		panel.add(tbxTekstPitanja);
		tbxTekstPitanja.setColumns(10);
		
		JLabel lblTip = new JLabel("Tip:");
		lblTip.setBounds(20, 53, 31, 14);
		panel.add(lblTip);
		
		ckbObaveznoPitanje = new JCheckBox("Obavezno");
		ckbObaveznoPitanje.setBounds(66, 77, 97, 23);
		panel.add(ckbObaveznoPitanje);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PitanjeDao pdao = PitanjeDao.get();
								
				TipPitanja tipNovogPitanja = null;
				
				if (cbbTipPitanja.getSelectedIndex() == 0) {
					tipNovogPitanja = TipPitanja.Abc;
				}
				else if (cbbTipPitanja.getSelectedIndex() == 1) {
					tipNovogPitanja = TipPitanja.OtvoreniOdgovor;
				}
				else if (cbbTipPitanja.getSelectedIndex() == 2) {
					tipNovogPitanja = TipPitanja.DaNE;
				}
				else if (cbbTipPitanja.getSelectedIndex() == 3) {
					tipNovogPitanja = TipPitanja.VisestrukiIzbor;
				}
				else if (cbbTipPitanja.getSelectedIndex() == 4) {
					tipNovogPitanja = TipPitanja.TacnoNetacno;
				}
				else {
					JOptionPane.showMessageDialog(null, "Došlo je do nepredviđene situacije u izboru tipa pitanja!");
				}
				
				//TODO: Dodati da se registruje o kojem kvizu je rijec
				Kviz testniKviz = new Kviz(0, "Testni kviz", 5, true, false);
				Pitanje novoPitanje = new Pitanje(0, tbxTekstPitanja.getText(), tipNovogPitanja, ckbObaveznoPitanje.isSelected(), testniKviz);
				
				pdao.create(novoPitanje);
			}
		});
		btnOk.setBounds(484, 366, 90, 23);
		panel1.add(btnOk);
		
		JButton btnOtkazi = new JButton("Otka\u017Ei");
		btnOtkazi.setBounds(384, 366, 90, 23);
		panel1.add(btnOtkazi);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setEnabled(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		frmDodavanjePitanja.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		cbbTipPitanja = new JComboBox();
		cbbTipPitanja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int odabraniId = (int)cbbTipPitanja.getSelectedIndex();
				if (odabraniId == 0) {
					RefreshTipovaPitanja();
					pnlPitanjePonudjeniOdgovori.setVisible(true);
					PopuniOdgovore();
				}
				else if (odabraniId == 1) {
					RefreshTipovaPitanja();
				}
				else if (odabraniId == 2) {
					RefreshTipovaPitanja();
				}
				else if (odabraniId == 3) {
					RefreshTipovaPitanja();
					pnlPitanjeVisestrukiIzbor.setVisible(true);
					PopuniIzbore();
				}
				else if (odabraniId == 4) {
					RefreshTipovaPitanja();
				}
			}
		});
		cbbTipPitanja.setModel(new DefaultComboBoxModel(new String[] {"Ponu\u0111eni odgovor", "Otvoren odgovor", "Da/Ne", "Vi\u0161estruki izbor", "Ta\u010Dno/Neta\u010Dno"}));
		cbbTipPitanja.setBounds(66, 50, 154, 20);
		panel.add(cbbTipPitanja);
		
		PopuniOdgovore();
	}

	// Metoda za postavljanje tipova pitanja na njihove defaultne vrijednosti
	
	private void RefreshTipovaPitanja() {
		pnlPitanjePonudjeniOdgovori.setVisible(false);
		pnlPitanjeVisestrukiIzbor.setVisible(false);
		brojIzbor = 1;
		brojOdgovor = 1;		
	}
	
	private void DodajIzbor() {
		JLabel novaLabela = new JLabel();
		novaLabela.setText(brojIzbor + ". izbor:");
		novaLabela.setBounds(20, 34 + (brojIzbor - 1) * 25, 61, 14);
		pnlPitanjeVisestrukiIzbor.add(novaLabela);
		labeleIzbor.add(novaLabela);
		
		JTextField noviTbx = new JTextField();
		noviTbx.setBounds(91, 31 + (brojIzbor - 1) * 25, 443, 20);
		noviTbx.setColumns(10);
		pnlPitanjeVisestrukiIzbor.add(noviTbx);
		tbxiIzbor.add(noviTbx);
		
		pnlPitanjeVisestrukiIzbor.repaint();
		
		btnDodajIzbor.setBounds(139, 37 + (brojIzbor) * 25, 140, 23);
		btnUkloniIzbor.setBounds(289, 37 + (brojIzbor) * 25, 140, 23);
		
		brojIzbor++;
	}
	
	private void DodajOdgovor() {
		JLabel novaLabela = new JLabel();
		novaLabela.setText(Character.toString((char)('a' + (brojOdgovor-1))) + ")");
		novaLabela.setBounds(33, 34 + (brojOdgovor - 1) * 25, 23, 14);
		novaLabela.setVisible(true);
		pnlPitanjePonudjeniOdgovori.add(novaLabela);
		labeleOdgovor.add(novaLabela);
		
		JTextField noviTbx = new JTextField();
		noviTbx.setBounds(66, 31 + (brojOdgovor - 1) * 25, 468, 20);
		noviTbx.setColumns(10);
		pnlPitanjePonudjeniOdgovori.add(noviTbx);
		tbxiOdgovor.add(noviTbx);
		
		pnlPitanjePonudjeniOdgovori.repaint();
		
		btnDodajOdgovor.setBounds(139, 37 + (brojOdgovor) * 25, 140, 23);
		btnUkloniOdgovor.setBounds(289, 37 + (brojOdgovor) * 25, 140, 23);		
		
		brojOdgovor++;
	}
	
	private void PopuniOdgovore() {
		labeleOdgovor = new ArrayList<JLabel>();
		tbxiOdgovor = new ArrayList<JTextField>();
		
		DodajOdgovor();
		DodajOdgovor();
		DodajOdgovor();
	}
	
	private void PopuniIzbore() {
		labeleIzbor = new ArrayList<JLabel>();
		tbxiIzbor = new ArrayList<JTextField>();
		
		DodajIzbor();
		DodajIzbor();
		DodajIzbor();
	}
}
