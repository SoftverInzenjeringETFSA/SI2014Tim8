package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.TipPitanja;

public class PitanjeDaoTest {

	
	private static PitanjeDao pdao = PitanjeDao.get();
	private static KvizDao ldao = KvizDao.get();
	private static long testId1;
	private static long testId2;
	private static Kviz k = new Kviz();
	private static Long i;
	
	@BeforeClass
	public static void prepare() throws Exception
	{
		
		i = ldao.create(new Kviz(1, "naziv", 10, true, false));
		k = ldao.read(i);
		
		Pitanje pitanje1= new Pitanje (1, "Tekst pitanja", TipPitanja.DaNE, true, k);
		Pitanje pitanje2= new Pitanje (5, "Tekst pitanja 5", TipPitanja.DaNE, true, k);
		testId1 = pdao.create(pitanje1);
		testId2 = pdao.create(pitanje2);
	}
	
	@Test
	public void testCreate() throws Exception {
		
		Pitanje pitanje1= new Pitanje (1, "Tekst pitanja1", TipPitanja.DaNE, true, k);
		
		assertNotNull(pdao.create(pitanje1));
		
	}
	@Test
	public void testRead()
	{
		Pitanje p = pdao.read(testId1);
		
		
		assertEquals("Tekst pitanja", p.get_tekstPitanja());
		assertEquals(TipPitanja.DaNE, p.get_tipPitanja());
		assertEquals(true, p.isObavezno());
	}

	@Test
	public void testUpdate() throws Exception {
		pdao.update(new Pitanje(testId1, "Update pitanja", TipPitanja.DaNE, false, k));
		
		Pitanje p = pdao.read(testId1);
		
		assertEquals("Update pitanja", p.get_tekstPitanja());
		
		assertEquals(false, p.isObavezno());
	}
@Test
	
	public void testDelete() {
		pdao.delete(testId2);
		assertNull(pdao.read(testId2));
	}

@Test
	public void testReadAll() {
	
		assertEquals(2, pdao.readAll().size());
	
	}

@Test
public void testdajPitanja() {

	assertEquals(2, pdao.DajSveIdZaKviz(i).size());

}


@Test
public void testdajPitanja2() {

	assertEquals(2, pdao.DajSveZaKviz(i).size());
	

}


	@AfterClass
	public static void deleteTestDataAfter()
	{
	
		pdao.deleteAll();
	}
}
