package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Spol;

public class KlijentDaoTest {

	private static Date testDate = new Date(0);
	private static KlijentDao kdao = KlijentDao.get();
	private static long testId1;
	private static long testId2;
	private static long testId3;
	
	@BeforeClass
	public static void prepare()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			testDate = sdf.parse("21/03/2011");
		 }
		catch(Exception e){e.printStackTrace();}
		
		
		Klijent klijent1 = new Klijent(1, "Faruk", "Ljuca", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"fljuca@yahoo.com", testDate, null, null);
		Klijent klijent2 = new Klijent(1, "Josip", "Kvesic", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"jkvesic@yahoo.com", testDate, null, null);
		Klijent klijent3 = new Klijent(1, "Amina", "Kadrispahic", Spol.zenski,
				"Titova 13", testDate, "061-688-900",
				"amina1@yahoo.com", testDate, null, null);
		
		testId1 = kdao.create(klijent1);
		testId2 = kdao.create(klijent2);
		testId3 = kdao.create(klijent3);
		
		
	}
	
	
	@Test
	public void testCreate() {
		
		
		
		
		Klijent klijent = new Klijent(1, "Faruk", "Ljuca", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"fljuca@yahoo.com", testDate, null, null);
		
		
		assertNotNull(kdao.create(klijent));
		
	}

	@Test
	public void testRead()
	{
		Klijent t = kdao.read(testId2);
		
		
		assertEquals("Josip", t.get_ime());
		assertEquals("Kvesic", t.get_prezime());
		assertEquals("061-688-900", t.get_telefon());
	}
		
	

	@Test
	
	public void testUpdate() {
		kdao.update(new Klijent(testId1, "Muhamed", "Mujic", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"mmujic@yahoo.com", testDate, null, null));
		
		Klijent t = kdao.read(testId1);
		
		assertEquals("Muhamed", t.get_ime());
		assertEquals("Mujic", t.get_prezime());
		assertEquals("mmujic@yahoo.com", t.get_eMail());
	}

	@Test
	
	public void testDelete() {
		kdao.delete(testId3);
		assertNull(kdao.read(testId3));
	}

	@Test
	
	public void testReadAll() {
		
		assertEquals(3, kdao.readAll().size());
		
	}
	
	@AfterClass
	public static void deleteTestDataAfter()
	{
		
		kdao.deleteAll();
		
		
		
	}
	
	

}
