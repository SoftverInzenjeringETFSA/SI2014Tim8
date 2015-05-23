package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.OdgovorDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.TipPitanja;

public class ModifikacijaPitanja extends JFrame {

	private JPanel contentPane;
	
	private JTextField tbxTekst;
	private JComboBox<String> cbbTip;
	private JCheckBox ckbObavezno;
	
	private ArrayList<JTextField> listaOdgovori;
	private ArrayList<JTextField> listaIzbori;
	private ArrayList<JLabel> listaLabeleOdgovori;
	private ArrayList<JLabel> listaLabeleIzbori;
	
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifikacijaPitanja frame = new ModifikacijaPitanja(null, 3);
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
	public ModifikacijaPitanja(final JFrame proslaForma, final int pitanjeZaModicikaciju) {
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
					long idKviza = KreiranjeAnkete.trenutniKvizID;
					Kviz testniKviz = kdao.read(idKviza);
					novoPitanje = new Pitanje(pitanjeZaModicikaciju, tbxTekst.getText(), tipNovogPitanja, ckbObavezno.isSelected(), testniKviz);
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
					return;
				}
				
				// Upis u bazu
				long idPitanja = pitanjeZaModicikaciju;
				ArrayList<Long> idjeviOdgovora = new ArrayList<Long>();
				
				try {
					pdao.update(novoPitanje);
					
					odao.IzbrisiSveOdgovorePitanja(pitanjeZaModicikaciju);
					
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
					
					e1.printStackTrace();
					
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
				((KreiranjeAnkete) proslaForma).refresh();
				proslaForma.setVisible(true);
				dispose();
			}
		});
		kontejner.add(btnNazad, "cell 1 2,growx");		
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		
		PitanjeDao pdao = PitanjeDao.get();
		Pitanje pitanjeZaUcitanjavanje = pdao.read((long) pitanjeZaModicikaciju);
		tbxTekst.setText(pitanjeZaUcitanjavanje.get_tekstPitanja());
		if (pitanjeZaUcitanjavanje.get_tipPitanja() == TipPitanja.Abc) {
			cbbTip.setSelectedIndex(1);
			
			OdgovorDao odao = OdgovorDao.get();
			Collection<Odgovor> odgovori = odao.DajSveZaPitanje(pitanjeZaModicikaciju);
			
			for (int i = 0; i < odgovori.size(); i++) {
				JLabel novaLabela = new JLabel(Character.toString((char)('a' + listaOdgovori.size())) + ")");
				pnlOdgovor.add(novaLabela, "cell 1 " + listaOdgovori.size());
				listaLabeleOdgovori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				noviOdgovor.setText(((Odgovor)odgovori.toArray()[i]).get_tekstOdgovora());
				pnlOdgovor.add(noviOdgovor, "cell 2 " + listaOdgovori.size() + ",growx");
				listaOdgovori.add(noviOdgovor);
			}
			pnlOdgovor.revalidate();
			
			for (int i = 0; i < 3; i++) {
				JLabel novaLabela = new JLabel(listaIzbori.size() + ". izbor: ");
				pnlIzbor.add(novaLabela, "cell 1 " + listaIzbori.size());
				listaLabeleIzbori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlIzbor.add(noviOdgovor, "cell 2 " + listaIzbori.size() + ",growx");
				listaIzbori.add(noviOdgovor);
			}
			pnlIzbor.revalidate();
		}
		else if (pitanjeZaUcitanjavanje.get_tipPitanja() == TipPitanja.OtvoreniOdgovor) {
			cbbTip.setSelectedIndex(2);
			
			for (int i = 0; i < 3; i++) {
				JLabel novaLabela = new JLabel(Character.toString((char)('a' + listaOdgovori.size())) + ")");
				pnlOdgovor.add(novaLabela, "cell 1 " + listaOdgovori.size());
				listaLabeleOdgovori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlOdgovor.add(noviOdgovor, "cell 2 " + listaOdgovori.size() + ",growx");
				listaOdgovori.add(noviOdgovor);
			}
			pnlOdgovor.revalidate();
			
			for (int i = 0; i < 3; i++) {
				JLabel novaLabela = new JLabel(listaIzbori.size() + ". izbor: ");
				pnlIzbor.add(novaLabela, "cell 1 " + listaIzbori.size());
				listaLabeleIzbori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlIzbor.add(noviOdgovor, "cell 2 " + listaIzbori.size() + ",growx");
				listaIzbori.add(noviOdgovor);
			}
			pnlIzbor.revalidate();
		}
		else if (pitanjeZaUcitanjavanje.get_tipPitanja() == TipPitanja.VisestrukiIzbor) {
			cbbTip.setSelectedIndex(3);
			
			for (int i = 0; i < 3; i++) {
				JLabel novaLabela = new JLabel(Character.toString((char)('a' + listaOdgovori.size())) + ")");
				pnlOdgovor.add(novaLabela, "cell 1 " + listaOdgovori.size());
				listaLabeleOdgovori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlOdgovor.add(noviOdgovor, "cell 2 " + listaOdgovori.size() + ",growx");
				listaOdgovori.add(noviOdgovor);
			}
			pnlOdgovor.revalidate();
			
			OdgovorDao odao = OdgovorDao.get();
			Collection<Odgovor> odgovori = odao.DajSveZaPitanje(3);
			
			JOptionPane.showMessageDialog(null, odgovori.size());
			
			for (int i = 0; i < odgovori.size(); i++) {
				JLabel novaLabela = new JLabel(listaIzbori.size() + ". izbor: ");
				pnlIzbor.add(novaLabela, "cell 1 " + listaIzbori.size());
				listaLabeleIzbori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				noviOdgovor.setText(((Odgovor)odgovori.toArray()[i]).get_tekstOdgovora());
				pnlIzbor.add(noviOdgovor, "cell 2 " + listaIzbori.size() + ",growx");
				listaIzbori.add(noviOdgovor);
			}
			pnlIzbor.revalidate();
		}
		else if (pitanjeZaUcitanjavanje.get_tipPitanja() == TipPitanja.TacnoNetacno) {
			cbbTip.setSelectedIndex(4);
			
			for (int i = 0; i < 3; i++) {
				JLabel novaLabela = new JLabel(Character.toString((char)('a' + listaOdgovori.size())) + ")");
				pnlOdgovor.add(novaLabela, "cell 1 " + listaOdgovori.size());
				listaLabeleOdgovori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlOdgovor.add(noviOdgovor, "cell 2 " + listaOdgovori.size() + ",growx");
				listaOdgovori.add(noviOdgovor);
			}
			pnlOdgovor.revalidate();
			
			for (int i = 0; i < 3; i++) {
				JLabel novaLabela = new JLabel(listaIzbori.size() + ". izbor: ");
				pnlIzbor.add(novaLabela, "cell 1 " + listaIzbori.size());
				listaLabeleIzbori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlIzbor.add(noviOdgovor, "cell 2 " + listaIzbori.size() + ",growx");
				listaIzbori.add(noviOdgovor);
			}
			pnlIzbor.revalidate();
		}
		else if (pitanjeZaUcitanjavanje.get_tipPitanja() == TipPitanja.DaNE) {
			cbbTip.setSelectedIndex(5);
			
			for (int i = 0; i < 3; i++) {
				JLabel novaLabela = new JLabel(Character.toString((char)('a' + listaOdgovori.size())) + ")");
				pnlOdgovor.add(novaLabela, "cell 1 " + listaOdgovori.size());
				listaLabeleOdgovori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlOdgovor.add(noviOdgovor, "cell 2 " + listaOdgovori.size() + ",growx");
				listaOdgovori.add(noviOdgovor);
			}
			pnlOdgovor.revalidate();
			
			for (int i = 0; i < 3; i++) {
				JLabel novaLabela = new JLabel(listaIzbori.size() + ". izbor: ");
				pnlIzbor.add(novaLabela, "cell 1 " + listaIzbori.size());
				listaLabeleIzbori.add(novaLabela);
				JTextField noviOdgovor = new JTextField();
				pnlIzbor.add(noviOdgovor, "cell 2 " + listaIzbori.size() + ",growx");
				listaIzbori.add(noviOdgovor);
			}
			pnlIzbor.revalidate();
		}
		ckbObavezno.setSelected(pitanjeZaUcitanjavanje.isObavezno());
	}

}
