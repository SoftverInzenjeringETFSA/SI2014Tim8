package ba.tim8.kvizbiz.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.entiteti.TipPitanja;

public class PitanjeTest {

	Pitanje pitanje1 = new Pitanje();
	TipPitanja _tipPitanja;
	
	@Test
	public void test_id() {
		
		
		pitanje1.set_id(1);
		assertEquals(1, pitanje1.get_id());
		
	}
	
	@Test
	public void tekst_pitanja_test() throws Exception {
		
		pitanje1.set_tekstPitanja("tekst ptianja");
		assertEquals("tekst ptianja", pitanje1.get_tekstPitanja());
		
	}
	
	@Test(expected=Exception.class)
	public void tekst_pitanja_izuzetak_test() throws Exception{
		
		pitanje1.set_tekstPitanja("");
		
	}
	
	@Test
	public void tip_pitanja_test() throws Exception {
		
		pitanje1.set_tipPitanja(_tipPitanja);
		assertEquals(_tipPitanja, pitanje1.get_tipPitanja());
		
	}

}
