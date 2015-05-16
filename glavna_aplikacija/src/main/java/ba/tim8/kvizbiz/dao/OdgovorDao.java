package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class OdgovorDao extends BaseDao<Odgovor> {

	private static OdgovorDao odao = null;

	public static OdgovorDao get() {
		return (odao == null) ? odao = new OdgovorDao() : odao;
	}

	
}
