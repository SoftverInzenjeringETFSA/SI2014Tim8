package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class OdgovorDao extends BaseDao<Odgovor> {

	private static OdgovorDao odao = null;

	public static OdgovorDao get() {
		return (odao == null) ? odao = new OdgovorDao() : odao;
	}
	
	private OdgovorDao(){}
	
	public void izbrisiSveOdgovoreKlijenta(Klijent k)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("delete from Odgovor o join o._klijenti k where k._id = :nesto");
		q.setLong("nesto", k.get_id()).executeUpdate();
		t.commit();
		session.close();		
	}

	
}
