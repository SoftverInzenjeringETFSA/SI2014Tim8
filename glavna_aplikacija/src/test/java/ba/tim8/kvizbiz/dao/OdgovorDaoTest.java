package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Pitanje;

public class OdgovorDaoTest {

	private static OdgovorDao odao = OdgovorDao.get();
	private static long testId1;
	private static long testId2;
	private static Kviz k = new Kviz();
	private static Pitanje p= new Pitanje();
	private static Set<Klijent> kli= new HashSet<Klijent>();
	
	@BeforeClass
	public static void prepare() throws Exception
	{
		Odgovor odgovor1= new Odgovor (1, "Tekst_odgovora", p, kli);
		Odgovor odgovor2= new Odgovor (5, "Text odgovora5", p , kli);
		testId1 = odao.create(odgovor1);
		testId2 = odao.create(odgovor2);
	}
	
	@Test
	public void testCreate() throws Exception {
		
		Odgovor odgovor1= new Odgovor (2, "Tekst_odgovora2", p, kli);
		
		assertNotNull(odao.create(odgovor1));
		
	}
	@Test
	public void testUpdate() throws Exception {
		odao.update(new Odgovor(4, "Tekst_odgovora4", p, kli));
		
		Odgovor o= odao.read(testId1);
		
		assertEquals("Update pitanja", p.get_tekstPitanja());
		
		assertEquals(4, o.get_id());
	}
	@Test
	public void testRead()
	{
		Odgovor o = odao.read(testId1);
		assertEquals("Tekst_odgovora",o.get_tekstOdgovora());
		assertEquals(1, o.get_id());
	}
	
@Test
	
	public void testDelete() {
		odao.delete(testId2);
		assertNull(odao.read(testId2));
	}

@Test
	public void testReadAll() {
	
		assertEquals(2, odao.readAll().size());
	
	}
	@AfterClass
	public static void deleteTestDataAfter()
	{
	
		odao.deleteAll();
	}

}
