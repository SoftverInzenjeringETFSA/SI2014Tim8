package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.TipPitanja;

public class KvizDaoTest {
/*
	private static KvizDao kdao = KvizDao.get();
	private static long testId1;
	private static long testId2;

	private static Long i;
	
	@BeforeClass
	public static void prepare() throws Exception
	{
		
		Kviz kviz1= new Kviz (1, "Kviz1", 25, true, true);
		Kviz kviz2= new Kviz (5, "Kviz2", 30, true, true);
		testId1 = kdao.create(kviz1);
		testId2 = kdao.create(kviz2);
	}
	
	@Test
	public void testCreate() throws Exception {
		
		Kviz kviz1= new Kviz (3, "Kviz3", 25, true, true);
		
		assertNotNull(kdao.create(kviz1));
		
	}
	@Test
	public void testRead()
	{
		Kviz k = kdao.read(testId1);
		assertEquals("Kviz1",k.get_naziv());
		assertEquals(25, k.get_vremenskoOgranicenje());
		assertEquals(true, k.is_aktivan());
		assertEquals(true, k.is_arhiviran());
	}
	@Test
	public void testUpdate() throws Exception {
		kdao.update(new Kviz(2, "Kviz_update", 25, true, true));
		
		Kviz k = kdao.read(testId1);
		
		assertEquals("Kviz_update", k.get_naziv());
		
		assertEquals(false, k.is_aktivan());

	}
@Test
	
	public void testDelete() {
		kdao.delete(testId2);
		assertNull(kdao.read(testId2));
	}

@Test
	public void testReadAll() {
	
		assertEquals(2, kdao.readAll().size());
	
	}
	@AfterClass
	public static void deleteTestDataAfter()
	{
	
		kdao.deleteAll();
	}
*/
}
