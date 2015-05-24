package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Set;

import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Spol;

public class KvizEntitetDao {

	@Test
	public void test() {
			
		Date datum = new Date();
		
		Klijent klijent1 = new Klijent(0, "Faruk", "Ljuca", Spol.muski, "Neka adresa", datum, "061111111", "fljuca1@etf.unsa.ba", null, null, null);
			
		Klijent klijent2 = new Klijent();
		klijent2.set_id(0);
		klijent2.set_ime("Faruk");
		klijent2.set_prezime("Ljuca");
		klijent2.set_spol(Spol.muski);
		klijent2.set_adresa("Neka adresa");
		klijent2.set_datumRodjenja(datum);
		klijent2.set_telefon("061111111");
		klijent2.set_eMail("fljuca1@etf.unsa.ba");
			
		Klijent klijent3 = new Klijent(klijent2.get_id(), klijent2.get_ime(), klijent2.get_prezime(),
				klijent2.get_spol(), klijent2.get_adresa(), klijent2.get_datumRodjenja(), klijent2.get_telefon(),
				klijent2.get_eMail(), null, null, null);
		
		assertEquals(klijent1.get_id(), klijent3.get_id());
		assertEquals(klijent1.get_ime(), klijent3.get_ime());
		assertEquals(klijent1.get_prezime(), klijent3.get_prezime());
		assertEquals(klijent1.get_spol(), klijent3.get_spol());
		assertEquals(klijent1.get_adresa(), klijent3.get_adresa());
		assertEquals(klijent1.get_datumRodjenja(), klijent3.get_datumRodjenja());
		assertEquals(klijent1.get_telefon(), klijent3.get_telefon());
		assertEquals(klijent1.get_eMail(), klijent3.get_eMail());
	}
}
