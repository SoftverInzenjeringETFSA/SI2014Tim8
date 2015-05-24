package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Kviz;

public class KvizEntitetTest {

	@Test
	public void TestKonstruktoraGeteraISetera() {
		
		Kviz k = new Kviz(0, "test", 15, true, true);
		
		assertEquals(k.get_id(), 0);
		assertEquals(k.get_naziv(), "test");
		assertEquals(k.get_vremenskoOgranicenje(), 15);
		assertEquals(k.is_aktivan(), true);
		assertEquals(k.is_arhiviran(), true);
	}
}
