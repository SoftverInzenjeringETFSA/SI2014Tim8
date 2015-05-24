package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Spol;

public class AdministratorEntitetTest {

	@Test
	public void TestKonstruktoraGeteraISetera() {
			
		Date datum = new Date();
		
		Administrator admin1 = new Administrator(0, "Faruk", "Ljuca", Spol.muski, "Neka adresa", datum,
				"061111111", "fljuca1@etf.unsa.ba", "admin", "pass");
		
		Administrator admin2 = new Administrator();
		admin2.set_id(0);
		admin2.set_ime("Faruk");
		admin2.set_prezime("Ljuca");
		admin2.set_spol(Spol.muski);
		admin2.set_adresa("Neka adresa");
		admin2.set_datumRodjenja(datum);
		admin2.set_telefon("061111111");
		admin2.set_eMail("fljuca1@etf.unsa.ba");
		admin2.set_username("admin");
		admin2.set_password("pass");
		
		Administrator admin3 = new Administrator(admin2.get_id(), admin2.get_ime(), admin2.get_prezime(),
				admin2.get_spol(), admin2.get_adresa(), admin2.get_datumRodjenja(), admin2.get_telefon(),
				admin2.get_eMail(), admin2.get_username(), admin2.get_password());
		
		assertEquals(admin1.get_id(), admin3.get_id());
		assertEquals(admin1.get_ime(), admin3.get_ime());
		assertEquals(admin1.get_prezime(), admin3.get_prezime());
		assertEquals(admin1.get_spol(), admin3.get_spol());
		assertEquals(admin1.get_adresa(), admin3.get_adresa());
		assertEquals(admin1.get_datumRodjenja(), admin3.get_datumRodjenja());
		assertEquals(admin1.get_telefon(), admin3.get_telefon());
		assertEquals(admin1.get_eMail(), admin3.get_eMail());
		assertEquals(admin1.get_username(), admin3.get_username());
		assertEquals(admin1.get_password(), admin3.get_password());
	}

}
