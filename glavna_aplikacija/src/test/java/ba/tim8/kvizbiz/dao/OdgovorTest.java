package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Pitanje;

public class OdgovorTest {

	private static Pitanje p= new Pitanje();
	private static Set<Klijent> kli= new HashSet<Klijent>();
	Odgovor odgovor1= new Odgovor ();
	
	@Test
	public void test_id() {
		odgovor1.set_id(1);
		assertEquals(1, odgovor1.get_id());
	}
	
	@Test
	public void test_pitanje() {
		odgovor1.set_pitanje(p);
		assertEquals(p, odgovor1.get_pitanje());
	}
	
	@Test
	public void test_tekst_odgovora() throws Exception {
		odgovor1.set_tekstOdgovora("tekst odgovora");
		assertEquals("tekst odgovora", odgovor1.get_tekstOdgovora());
	}

}
