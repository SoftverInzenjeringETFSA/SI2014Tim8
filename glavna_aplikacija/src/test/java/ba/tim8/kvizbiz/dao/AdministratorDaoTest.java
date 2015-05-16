package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Osoba;
import ba.tim8.kvizbiz.entiteti.Spol;
import junit.framework.TestCase;


public class AdministratorDaoTest {

	
	private static Date testDate = new Date(0);
	private static AdministratorDao adao = AdministratorDao.get();
	private static long testId1;
	private static long testId2;
	private static long testId3;
	
	@BeforeClass
	public static void prepare()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			testDate = sdf.parse("21/12/2012");
		 }
		catch(Exception e){e.printStackTrace();}
		
		
		Administrator admin1 = new Administrator(1, "Orhan", "Ljubuncic", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"orhanljubuncic@yahoo.com", "oljubuncic1", "pass1");
		Administrator admin2 = new Administrator(1, "Orhan", "Ljubuncic", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"orhanljubuncic@yahoo.com", "oljubuncic2", "pass2");
		Administrator admin3 = new Administrator(1, "Orhan", "Ljubuncic", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"orhanljubuncic@yahoo.com", "oljubuncic3", "pass3");
		
		testId1 = adao.create(admin1);
		testId2 = adao.create(admin2);
		testId3 = adao.create(admin3);
		
		
	}
	
	
	@Test
	public void testCreate() {
		
		
		
		
		Administrator admin = new Administrator(1, "Orhan", "Ljubunčić", Spol.muski,
			"Titova 13", testDate, "061-688-900",
			"orhanljubuncic@yahoo.com", "oljubuncic4", "pass4");
		
		
		assertNotNull(adao.create(admin));
		
	}

	@Test
	public void testRead()
	{
		Administrator t = adao.read(testId2);
		
		
		assertEquals("oljubuncic2", t.get_username());
		assertEquals("pass2", t.get_password());
	}
		
	

	@Test
	public void testUpdate() {
		adao.update(new Administrator(testId1, "Toni", "Milicevic", Spol.muski,
			"Titova 13", testDate, "061-688-944",
			"tonimilicevic@yahoo.com", "tmilicevic1", "pass1"));
		
		Administrator t = adao.read(testId1);
		
		assertEquals("Toni", t.get_ime());
		assertEquals("Milicevic", t.get_prezime());
		assertEquals("tmilicevic1", t.get_username());
	}

	@Test
	public void testDelete() {
		adao.delete(testId3);
		assertNull(adao.read(testId3));
	}

	@Test
	
	public void testReadAll() {
		
		assertEquals(3, adao.readAll().size());
		
	}
	
	@AfterClass
	public static void deleteTestDataAfter()
	{
		
		adao.deleteAll();
		
		
		
	}
	
	

}
