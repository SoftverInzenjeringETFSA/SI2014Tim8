package ba.tim8.kvizbiz.forme;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// Klasa koja služi za postavljanje menija na forme u svakom prozoru u koujem je to potrebno
public class Menu {	
	public Menu () {}
	
	// Metoda prima JFrame na koji "zakači" meni
	public void NapraviMenu (JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAdmnistratori = new JMenu("Administratori");
		menuBar.add(mnAdmnistratori);		
		JMenuItem mntmDodavanjeAdministratora = new JMenuItem("Dodavanje");
		mnAdmnistratori.add(mntmDodavanjeAdministratora);		
		JMenuItem mntmBrisanjeAdministratora = new JMenuItem("Brisanje");
		mnAdmnistratori.add(mntmBrisanjeAdministratora);		
		JMenuItem mntmPregledAdministratora = new JMenuItem("Pregled");
		mnAdmnistratori.add(mntmPregledAdministratora);
		
		JMenu mnKlijenti = new JMenu("Klijenti");
		menuBar.add(mnKlijenti);	
		JMenuItem mntmPromjenaKlijenta = new JMenuItem("Promjena");
		mnKlijenti.add(mntmPromjenaKlijenta);		
		JMenuItem mntmBrisanjeKlijenta = new JMenuItem("Brisanje");
		mnKlijenti.add(mntmBrisanjeKlijenta);		
		JMenuItem mntmPregledKlijenata = new JMenuItem("Pregled");
		mnKlijenti.add(mntmPregledKlijenata);
		
		JMenu mnAnkete = new JMenu("Ankete");
		menuBar.add(mnAnkete);		
		JMenuItem mntmDodavanje = new JMenuItem("Dodavanje");
		mnAnkete.add(mntmDodavanje);		
		JMenuItem mntmManipulacija = new JMenuItem("Manipulacija");
		mnAnkete.add(mntmManipulacija);
		
		JMenu mnStatistika = new JMenu("Statistika");
		menuBar.add(mnStatistika);
		JMenuItem poAnketama = new JMenuItem("Po anketama");
		JMenuItem poKlijentima = new JMenuItem("Po klijentima");
		mnStatistika.add(poAnketama);
		mnStatistika.add(poKlijentima);
		
		JMenu mnProfil = new JMenu("Profil");
		menuBar.add(mnProfil);	
		JMenuItem mntmPromjenaLicnihPodataka = new JMenuItem("Promjena li\u010Dnih podataka");
		mnProfil.add(mntmPromjenaLicnihPodataka);		
		JMenuItem mntmPromjenaPassworda = new JMenuItem("Promjena passworda");
		mnProfil.add(mntmPromjenaPassworda);		
		JMenuItem mntmOdjava = new JMenuItem("Odjava");
		mnProfil.add(mntmOdjava);
	}
}
