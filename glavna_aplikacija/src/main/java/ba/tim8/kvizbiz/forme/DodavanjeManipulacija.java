package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import ba.tim8.kvizbiz.dao.*;
import ba.tim8.kvizbiz.entiteti.*;
import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

public class DodavanjeManipulacija extends JFrame {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(DodavanjeManipulacija.class);

	private JPanel contentPane;
	
	public Long id = null;
	private JTextField tbxTekst;
	private JComboBox<String> cbbTip;
	private JCheckBox ckbObavezno;
	
	private ArrayList<JTextField> listaOdgovori;
	private ArrayList<JTextField> listaIzbori;
	private ArrayList<JLabel> listaLabeleOdgovori;
	private ArrayList<JLabel> listaLabeleIzbori;
	
	private JLabel lblStatus;	

	/**
	 * Create the frame.
	 */
	public DodavanjeManipulacija(final Long id, final JFrame proslaForma) {
		
		this.id = id;
		listaOdgovori = new ArrayList<JTextField>();
		listaIzbori = new ArrayList<JTextField>();
		listaLabeleOdgovori = new ArrayList<JLabel>();
		listaLabeleIzbori = new ArrayList<JLabel>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		final JPanel kontejner = new JPanel(new MigLayout("", "[grow][100px][100px]", "[fill][grow][fill]"));
		kontejner.setBorder(null);
		contentPane.add(kontejner, BorderLayout.CENTER);
		
		JPanel pnlPodaci = new JPanel(new MigLayout("", "[grow][fill][220px][grow]", "[fill][fill][fill]"));
		pnlPodaci.setBorder(new TitledBorder("Unesite podatke o pitanju:"));
		kontejner.add(pnlPodaci, "cell 0 0 3 1,growx");
		
		final JScrollPane scroll = new JScrollPane();
		kontejner.add(scroll, "cell 0 1 3 1,growx,growy");
		
		final JPanel pnlOdgovor = new JPanel(new MigLayout("", "[50px][fill][grow][50px]", "[fill][fill][fill][fill][fill][fill][fill][fill][fill][grow]"));
		pnlOdgovor.setBorder(new TitledBorder("Unesite ponuđene odgovore:"));
		
		JButton btnDodajOdgovor = new JButton("Dodaj odgovor");
		btnDodajOdgovor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listaOdgovori.size() >= 8) {
					lblStatus.setText("Ne možete dodati više od 8 ponuđenih odgovora!");
					lblStatus.setForeground(SystemColor.red);
					return;
				}
				
				JLabel novaLabela = new JLabel(Character.toString((char)('a' + listaOdgovori.size())) + ")");
				pnlOdgovor.add(novaLabela, "cell 1 " + listaOdgovori.size());
				listaLabeleOdgovori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlOdgovor.add(noviOdgovor, "cell 2 " + listaOdgovori.size() + ",growx");
				listaOdgovori.add(noviOdgovor);
				
				pnlOdgovor.revalidate();
			}
		});
		pnlOdgovor.add(btnDodajOdgovor, "cell 0 8 4 1,alignx center");
		
		for (int i = 0; i < 3; i++) {
			JLabel novaLabela = new JLabel(Character.toString((char)('a' + listaOdgovori.size())) + ")");
			pnlOdgovor.add(novaLabela, "cell 1 " + listaOdgovori.size());
			listaLabeleOdgovori.add(novaLabela);
			JTextField noviOdgovor = new JTextField();
			pnlOdgovor.add(noviOdgovor, "cell 2 " + listaOdgovori.size() + ",growx");
			listaOdgovori.add(noviOdgovor);
		}
		pnlOdgovor.revalidate();
		
		JButton btnObrisiOdgovor = new JButton("Obrisi odgovor");
		btnObrisiOdgovor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listaOdgovori.size() <= 2) {
					lblStatus.setText("Ne možete imati manje od 2 ponuđena odgovora!");
					lblStatus.setForeground(SystemColor.red);
					return;
				}
				
				pnlOdgovor.remove(listaLabeleOdgovori.get(listaLabeleOdgovori.size()-1));
				pnlOdgovor.remove(listaOdgovori.get(listaOdgovori.size()-1));
				listaLabeleOdgovori.remove(listaLabeleOdgovori.size()-1);
				listaOdgovori.remove(listaOdgovori.size()-1);
				
				pnlOdgovor.repaint();
				pnlOdgovor.revalidate();
			}
		});
		pnlOdgovor.add(btnObrisiOdgovor, "cell 0 8 4 1,alignx center");
		
		final JPanel pnlIzbor = new JPanel(new MigLayout("", "[50px][fill][grow][50px]", "[fill][fill][fill][fill][fill][fill][fill][fill][fill][grow]"));
		pnlIzbor.setBorder(new TitledBorder("Unesite visestruke izbore:"));
		
		JButton btnDodajIzbor = new JButton("Dodaj izbor");
		btnDodajIzbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listaIzbori.size() >= 8) {
					lblStatus.setText("Ne možete dodati više od 8 višestrukih izbora!");
					lblStatus.setForeground(SystemColor.red);
					return;
				}
				
				JLabel novaLabela = new JLabel(listaIzbori.size() + ". izbor: ");
				pnlIzbor.add(novaLabela, "cell 1 " + listaIzbori.size());
				listaLabeleIzbori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlIzbor.add(noviOdgovor, "cell 2 " + listaIzbori.size() + ",growx");
				listaIzbori.add(noviOdgovor);
				
				pnlIzbor.revalidate();
			}
		});
		pnlIzbor.add(btnDodajIzbor, "cell 0 8 4 1,alignx center");
		
		for (int i = 0; i < 3; i++) {
			JLabel novaLabela = new JLabel(listaIzbori.size() + ". izbor: ");
			pnlIzbor.add(novaLabela, "cell 1 " + listaIzbori.size());
			listaLabeleIzbori.add(novaLabela);
			JTextField noviOdgovor = new JTextField();
			pnlIzbor.add(noviOdgovor, "cell 2 " + listaIzbori.size() + ",growx");
			listaIzbori.add(noviOdgovor);
		}
		pnlIzbor.revalidate();
		
		JButton btnObrisiIzbor = new JButton("Obrisi Odgovor");
		btnObrisiIzbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listaIzbori.size() <= 2) {
					lblStatus.setText("Ne možete imati manje od 2 višestruka izbor!");
					lblStatus.setForeground(SystemColor.red);
					return;
				}
				
				pnlIzbor.remove(listaLabeleIzbori.get(listaLabeleIzbori.size()-1));
				pnlIzbor.remove(listaIzbori.get(listaIzbori.size()-1));
				listaLabeleIzbori.remove(listaLabeleIzbori.size()-1);
				listaIzbori.remove(listaIzbori.size()-1);
				
				pnlIzbor.repaint();
				pnlIzbor.revalidate();
			}
		});
		pnlIzbor.add(btnObrisiIzbor, "cell 0 8 4 1,alignx center");
		
		pnlPodaci.add(new JLabel("Tekst pitanja: "), "cell 1 0,alignx right");
		pnlPodaci.add(new JLabel("Tip pitanja: "), "cell 1 1,alignx right");
		pnlPodaci.add(new JLabel("Obavezno pitanje: "), "cell 1 2,alignx right");
		
		tbxTekst = new JTextField();
		pnlPodaci.add(tbxTekst, "cell 2 0,growx");
		
		cbbTip = new JComboBox<String>();
		cbbTip.addItem("Odaberite tip pitanja");
		cbbTip.addItem("Pitanje s ponuđenim odgovorima");
		cbbTip.addItem("Pitanje s otvorenim odgovorom");
		cbbTip.addItem("Pitanje s višestrukim izborom");
		cbbTip.addItem("Tačno/netačno pitanje");
		cbbTip.addItem("Da/ne pitanje");
		cbbTip.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbbTip.getSelectedIndex() == 1) {
					scroll.setViewportView(pnlOdgovor);
				}
				else if (cbbTip.getSelectedIndex() == 3) {
					scroll.setViewportView(pnlIzbor);
				}
				else {
					scroll.setViewportView(null);
				}
				kontejner.revalidate();
			}
		});
		pnlPodaci.add(cbbTip, "cell 2 1,alignx left");
		
		ckbObavezno = new JCheckBox();
		pnlPodaci.add(ckbObavezno, "cell 2 2,alignx left");
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PitanjeDao pdao = PitanjeDao.get();
				OdgovorDao odao = OdgovorDao.get();
				
				TipPitanja tipNovogPitanja = null;
				
				if (cbbTip.getSelectedIndex() == 0) {
					lblStatus.setText("Niste odabrali tip pitanja!");
					lblStatus.setForeground(Color.red);
					return;
				}
				else if (cbbTip.getSelectedIndex() == 1) {
					tipNovogPitanja = TipPitanja.Abc;
				}
				else if (cbbTip.getSelectedIndex() == 2) {
					tipNovogPitanja = TipPitanja.OtvoreniOdgovor;
				}
				else if (cbbTip.getSelectedIndex() == 3) {
					tipNovogPitanja = TipPitanja.VisestrukiIzbor;
				}
				else if (cbbTip.getSelectedIndex() == 4) {
					tipNovogPitanja = TipPitanja.TacnoNetacno;
				}
				else if (cbbTip.getSelectedIndex() == 5) {
					tipNovogPitanja = TipPitanja.DaNE;
				}
				else {
					JOptionPane.showMessageDialog(null, "Došlo je do nepredviđene situacije u izboru tipa pitanja!");
				}
				
				Pitanje novoPitanje = null;
				ArrayList<Odgovor> noviOdgovori = new ArrayList<Odgovor>();
				
				// Kreiranje objekata
				try {
					KvizDao kdao = KvizDao.get();
//					long idKviza = KreiranjeAnkete.trenutniKvizID;
					Kviz testniKviz = kdao.read(id);
					
					novoPitanje = new Pitanje(0, tbxTekst.getText(), tipNovogPitanja, ckbObavezno.isSelected(), testniKviz);
					if (tipNovogPitanja == TipPitanja.Abc) {
						for (int i = 0; i < listaOdgovori.size(); i++) {
							Odgovor noviOdgovor = new Odgovor(0, listaOdgovori.get(i).getText(), null, null);
							noviOdgovori.add(noviOdgovor);
						}
					}
					else if (tipNovogPitanja == TipPitanja.DaNE) {
						Odgovor da = new Odgovor(0, "Da", null, null);
						noviOdgovori.add(da);
						Odgovor ne = new Odgovor(0, "Ne", null, null);
						noviOdgovori.add(ne);
					}
					else if (tipNovogPitanja == TipPitanja.OtvoreniOdgovor) {
						
					}
					else if (tipNovogPitanja == TipPitanja.TacnoNetacno) {
						Odgovor tacno = new Odgovor(0, "Tacno", null, null);
						noviOdgovori.add(tacno);
						Odgovor netacno = new Odgovor(0, "Netacno", null, null);
						noviOdgovori.add(netacno);
					}
					else if (tipNovogPitanja == TipPitanja.VisestrukiIzbor) {
						for (int i = 0; i < listaIzbori.size(); i++) {
							Odgovor noviOdgovor = new Odgovor(0, listaIzbori.get(i).getText(), null, null);
							noviOdgovori.add(noviOdgovor);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Došlo je do nepredviđene situacije kod prepoznavanja tipa pitanja!");
					}
				}
				catch (Exception e1) {
					lblStatus.setText(e1.getMessage());
					lblStatus.setForeground(Color.red);
					logger.error("Greska: ", e1);
				}
				
				// Upis u bazu
				long idPitanja = -1;
				ArrayList<Long> idjeviOdgovora = new ArrayList<Long>();
				
				try {
					idPitanja = pdao.create(novoPitanje);
					
					for (int i = 0; i < noviOdgovori.size(); i++) {
						noviOdgovori.get(i).set_pitanje(novoPitanje);
						idjeviOdgovora.add(odao.create(noviOdgovori.get(i)));
					}
				}
				catch (Exception e1) {
					if (idPitanja != -1) {
						pdao.delete(idPitanja);
						for (int i = 0; i < idjeviOdgovora.size(); i++) {
							odao.delete(idjeviOdgovora.get(i));
						}
					}
					lblStatus.setText("Došlo je do greško prilikom upisa u bazu");
					lblStatus.setForeground(Color.red);
					
					logger.error("Greska: ", e1);
					
					return;
				}
				
				lblStatus.setText("Novo pitanje je uspješno uneseno.");
				lblStatus.setForeground(Color.green);
			}
		});
		kontejner.add(btnOk, "flowx,cell 2 2,growx");
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//((KreiranjeAnkete) proslaForma).refresh();
				//proslaForma.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		kontejner.add(btnNazad, "cell 1 2,growx");		
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
	}

}
