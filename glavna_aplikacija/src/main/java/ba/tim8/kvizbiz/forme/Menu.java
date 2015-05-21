package ba.tim8.kvizbiz.forme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// Klasa koja služi za postavljanje menija na forme u svakom prozoru u koujem je to potrebno
public class Menu {
	/**
	 * @wbp.parser.entryPoint
	 */
	public Menu() {
	}

	// Metoda prima JFrame na koji "zakači" meni
	public void NapraviMenu(final JFrame frame) {

		if (LoginAdmin_stara.usernameLogiranogAdmina != "") {
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);

			// Podmeni Administratori
			JMenu mnAdmnistratori = new JMenu("Administratori");
			menuBar.add(mnAdmnistratori);

			JMenuItem mntmDodavanjeAdministratora = new JMenuItem("Dodavanje");
			mntmDodavanjeAdministratora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DodavanjeAdministratora noviProzor = new DodavanjeAdministratora();
					JFrame noviFrame = noviProzor
							.get_frmDodavanjeAdministratora();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnAdmnistratori.add(mntmDodavanjeAdministratora);

			JMenuItem mntmBrisanjeAdministratora = new JMenuItem("Brisanje");
			mntmBrisanjeAdministratora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					BrisanjeAdministratora noviProzor = new BrisanjeAdministratora();
					JFrame noviFrame = noviProzor
							.get_frmBrisanjeAdministratora();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnAdmnistratori.add(mntmBrisanjeAdministratora);

			JMenuItem mntmPregledAdministratora = new JMenuItem("Pregled");
			mntmPregledAdministratora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PregledAdministratora noviProzor = new PregledAdministratora();
					JFrame noviFrame = noviProzor
							.get_frmPregledAdministratora();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnAdmnistratori.add(mntmPregledAdministratora);

			// Podmeni Klijenti
			JMenu mnKlijenti = new JMenu("Klijenti");
			menuBar.add(mnKlijenti);

			JMenuItem mntmPromjenaKlijenta = new JMenuItem("Promjena");
			mntmPromjenaKlijenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PromjenaKlijenta noviProzor = new PromjenaKlijenta();
					JFrame noviFrame = noviProzor.get_frmPromjenaKlijenta();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnKlijenti.add(mntmPromjenaKlijenta);

			JMenuItem mntmBrisanjeKlijenta = new JMenuItem("Brisanje");
			mntmBrisanjeKlijenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					BrisanjeKlijenta noviProzor = new BrisanjeKlijenta();
					JFrame noviFrame = noviProzor.get_frmBrisanjeKlijenta();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnKlijenti.add(mntmBrisanjeKlijenta);

			JMenuItem mntmPregledKlijenata = new JMenuItem("Pregled");
			mntmPregledKlijenata.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PregledKlijenata noviProzor = new PregledKlijenata();
					JFrame noviFrame = noviProzor.get_frmPregledKlijenata();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnKlijenti.add(mntmPregledKlijenata);

			// Podmeni Ankete
			JMenu mnAnkete = new JMenu("Ankete");
			menuBar.add(mnAnkete);

			JMenuItem mntmDodavanje = new JMenuItem("Dodavanje");
			mntmDodavanje.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					KreiranjeAnkete noviProzor = new KreiranjeAnkete();
					JFrame noviFrame = noviProzor.get_frmKreiranjeAnkete();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnAnkete.add(mntmDodavanje);

			JMenuItem mntmManipulacija = new JMenuItem("Manipulacija");
			mntmManipulacija.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ManipulacijaAnketama noviProzor = new ManipulacijaAnketama();
					JFrame noviFrame = noviProzor.get_frmManipulacijaAnketama();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnAnkete.add(mntmManipulacija);

			JMenuItem mntmPregledAnketa = new JMenuItem("Pregled");
			mntmPregledAnketa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PocetnaKlijent noviProzor = new PocetnaKlijent();
					noviProzor.setVisible(true);
					frame.dispose();
				}
			});
			mnAnkete.add(mntmPregledAnketa);

			// Podmeni Statistika
			JMenu mnStatistika = new JMenu("Statistika");
			menuBar.add(mnStatistika);

			JMenuItem poAnketama = new JMenuItem("Po anketama");
			poAnketama.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					StatistikaPoAnketama noviProzor = new StatistikaPoAnketama();
					JFrame noviFrame = noviProzor.get_frmGlavnaForma();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnStatistika.add(poAnketama);

			JMenuItem poKlijentima = new JMenuItem("Po klijentima");
			poKlijentima.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					StatistikaPoKlijentima noviProzor = new StatistikaPoKlijentima();
					JFrame noviFrame = noviProzor
							.get_frmStatistikaPoKlijentimaForma();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnStatistika.add(poKlijentima);

			// Podmeni Profil
			JMenu mnProfil = new JMenu("Profil");
			menuBar.add(mnProfil);

			JMenuItem mntmPromjenaLicnihPodataka = new JMenuItem(
					"Promjena li\u010Dnih podataka");
			mntmPromjenaLicnihPodataka.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PromjenaLicnihPodataka noviProzor = new PromjenaLicnihPodataka();
					JFrame noviFrame = noviProzor
							.get_frmPromjenaLicnihPodataka();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnProfil.add(mntmPromjenaLicnihPodataka);

			JMenuItem mntmPromjenaPassworda = new JMenuItem(
					"Promjena passworda");
			mntmPromjenaPassworda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PromjenaPassworda noviProzor = new PromjenaPassworda();
					JFrame noviFrame = noviProzor.get_frmPromjenaPassworda();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnProfil.add(mntmPromjenaPassworda);

			JMenuItem mntmOdjava = new JMenuItem("Odjava");
			mntmOdjava.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					KvizBiz noviProzor = new KvizBiz();
					JFrame noviFrame = noviProzor.get_frame();
					noviFrame.setVisible(true);
					frame.dispose();
				}
			});
			mnProfil.add(mntmOdjava);
		}
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
