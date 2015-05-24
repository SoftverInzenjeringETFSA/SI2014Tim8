package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Osoba;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.Spol;
import ba.tim8.kvizbiz.entiteti.TipPitanja;
import junit.framework.TestCase;


public class AdministratorDaoTest {

	
	private static Date testDate = new Date(0);
	private static Date testDate2 = new Date(0);
	private static AdministratorDao adao = AdministratorDao.get();
	private static long testId1;
	private static long testId2;
	private static long testId3;
	private static long testId4;
	private static long testId5;
	
	@Before
	
	public void prepare()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			testDate = sdf.parse("21/12/2012");
			testDate2 = sdf.parse("21/11/2012");
		 }
		catch(Exception e){e.printStackTrace();}
		
		
		Administrator admin1 = new Administrator(1, "Orhan", "Ljubuncic", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"orhanljubuncic@yahoo.com", "oljubuncic1", "pass1");
		Administrator admin2 = new Administrator(1, "Orhan", "Ljubuncic", Spol.muski,
				"Titova 13", testDate, "061-688-900",
				"orhanljubuncic@yahoo.com", "oljubuncic2", "pass2");
		Administrator admin3 = new Administrator(1, "Orhan", "Ljubuncic", Spol.muski,
				"Titova 12", testDate, "061-688-900",
				"orhanljubuncic@yahoo.com", "oljubuncic3", "pass3");
		Administrator admin4 = new Administrator(1, "Josip", "Kvesic", Spol.muski,
				"Titova 10", testDate2, "061-328-900",
				"jkvesic@yahoo.com", "jkvesic1", "pass");
		Administrator admin5 = new Administrator(1, "Josip", "Kvesic", Spol.muski,
				"Titova 10", testDate2, "061-328-900",
				"jkvesic@yahoo.com", "jkvesic2", "pass");
		
		
		
		testId1 = adao.create(admin1);
		testId2 = adao.create(admin2);
		testId3 = adao.create(admin3);
		testId4 = adao.create(admin4);
		testId5 = adao.create(admin5);
		
		
	}
	
	
	

	@Test
	public void testRead()
	{
		Administrator t = adao.read(testId2);
		
		
		assertEquals("oljubuncic2", t.get_username());
		assertEquals("pass2", t.get_password());
	}
	
	@Test
	
	public void testReadAll() {
		
		assertEquals(5, adao.readAll().size());
		
	}
	
	@Test
	public void testdajPoUsernamu() {
		
		ArrayList<Administrator> alist = (ArrayList<Administrator>) adao.dajPoUsernamu("oljubuncic1");
		
		assertEquals(alist.get(0).get_id(), testId1);
		assertEquals(alist.size(), 1);
		
		
	}
	
	@Test
	public void testdajPoImenu() {
		
		ArrayList<Administrator> alist = (ArrayList<Administrator>) adao.dajPoImenu("Orhan");
		
		assertEquals(alist.get(0).get_id(), testId1);
		assertEquals(alist.get(1).get_id(), testId2);
		assertEquals(alist.get(2).get_id(), testId3);
		assertEquals(alist.size(), 3);
		
		
	}
	
	@Test
	public void testdajPoPrezimenu() {
		
		ArrayList<Administrator> alist = (ArrayList<Administrator>) adao.dajPoPrezimenu("Ljubuncic");
		
		assertEquals(alist.get(0).get_id(), testId1);
		assertEquals(alist.get(1).get_id(), testId2);
		assertEquals(alist.get(2).get_id(), testId3);
		assertEquals(alist.size(), 3);
		
		
	}
	
	@Test
	public void testdajPoAdresi() {
		
		ArrayList<Administrator> alist = (ArrayList<Administrator>) adao.dajPoAdresi("Titova 13");
		
		assertEquals(alist.get(0).get_id(), testId1);
		assertEquals(alist.get(1).get_id(), testId2);
		
		assertEquals(alist.size(), 2);
		
		
	}
	
	@Test(expected=Exception.class)
	public void testdajPoDatumu() throws Exception {
		
		ArrayList<Administrator> alist = (ArrayList<Administrator>) adao.dajPoDatumu("pogresan format datuma");
		
		
		
		
	}
	
	@Test
	public void testdajPoTelefonu() {
		
		ArrayList<Administrator> alist = (ArrayList<Administrator>) adao.dajPoTelefonu("061-688-900");
		
		assertEquals(alist.get(0).get_id(), testId1);
		assertEquals(alist.get(1).get_id(), testId2);
		assertEquals(alist.get(2).get_id(), testId3);
		
		assertEquals(alist.size(), 3);
		
		
	}
	
	@Test
	public void testdajPoDatumu2() throws Exception {
		
		ArrayList<Administrator> alist = (ArrayList<Administrator>) adao.dajPoDatumu("21/12/2012");
		
		assertEquals(alist.get(0).get_id(), testId1);
		assertEquals(alist.get(1).get_id(), testId2);
		assertEquals(alist.get(2).get_id(), testId3);
		
		assertEquals(alist.size(), 3);
		
		
	}
	
	@Test
	public void testdajPoMailu() {
		
		ArrayList<Administrator> alist = (ArrayList<Administrator>) adao.dajPoMailu("orhanljubuncic@yahoo.com");
		
		assertEquals(alist.get(0).get_id(), testId1);
		assertEquals(alist.get(1).get_id(), testId2);
		assertEquals(alist.get(2).get_id(), testId3);
		
		assertEquals(alist.size(), 3);
		
		
	}
	
	@Test
	public void testCreate() {
		
		
		
		
		Administrator admin = new Administrator(1, "Muhamed", "Mujic", Spol.muski,
			"Titova 10", testDate, "061-688-900",
			"mmujic@yahoo.com", "mmujic1", "pass4");
		
		
		assertNotNull(adao.create(admin));
		
	}

	@Test
	
	public void testUpdate() {
		adao.update(new Administrator(testId5, "Toni", "Milicevic", Spol.muski,
			"Titova 11", testDate, "061-688-944",
			"tonimilicevic@yahoo.com", "tmilicevic1", "pass1"));
		
		Administrator t = adao.read(testId5);
		
		assertEquals("Toni", t.get_ime());
		assertEquals("Milicevic", t.get_prezime());
		assertEquals("tmilicevic1", t.get_username());
		assertEquals("Titova 11", t.get_adresa());
	}

	@Test
	
	public void testDelete() {
		adao.delete(testId4);
		assertNull(adao.read(testId4));
	}
	
	@Test
	public void testpretraziPoUsernamu() {
		assertTrue(adao.pretraziPoUsernamu("oljubuncic1"));
		assertFalse(adao.pretraziPoUsernamu("oljubuncic1222"));
		
	}

	
	@After
	public void deleteTestDataAfter()
	{
		
		adao.deleteAll();
	
	}
	
	
	

}
