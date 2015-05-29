package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;

public class KvizTest {
	
	private static Kviz kviz1= new Kviz (1, "Kviz1", 25, true, true);
	private static Set<Klijent> _klijenti = new HashSet<Klijent>();
	private static Set<Pitanje> _pitanja = new HashSet<Pitanje>();
	
	@Test
	public void test_get_id() {
		
		assertEquals(1, kviz1.get_id());
	}
	
	@Test
	public void test_set_id() {
		
		kviz1.set_id(2);
		assertEquals(2, kviz1.get_id());
	}
	
	@Test
	public void test_naziv() {
		
		kviz1.set_naziv("kviz2");
		assertEquals("kviz2", kviz1.get_naziv());
		
	}
	
	@Test
	public void test_vremensko_ogranicenje() {
		
		kviz1.set_vremenskoOgranicenje(30);
		assertEquals(30, kviz1.get_vremenskoOgranicenje());
		
	}
	
	@Test
	public void test_is_aktivan() {
		
		assertEquals(true, kviz1.is_aktivan());
		
	}
	
	@Test
	public void test_set_arhiviran() {
		kviz1.set_arhiviran(false);
		assertEquals(false, kviz1.is_arhiviran());
		
	}
	
	@Test
	public void test_klijenti() {
		
		kviz1.set_klijenti(_klijenti);
		assertEquals(_klijenti, kviz1.get_klijenti());
		
	}
	
	@Test
	public void test_pitanja() {
		
		kviz1.set_pitanja(_pitanja);
		assertEquals(_pitanja, kviz1.get_pitanja());
		
	}
}
