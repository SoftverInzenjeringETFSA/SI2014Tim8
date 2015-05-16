package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Osoba;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class OsobaDao extends BaseDao<Osoba> {

	private static OsobaDao odao = null;

	public static OsobaDao get() {
		return (odao == null) ? odao = new OsobaDao() : odao;
	}

	
}
