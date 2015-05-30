package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class KvizDao extends BaseDao<Kviz> {

	private static KvizDao kdao = null;

	public static KvizDao get() {
		return (kdao == null) ? kdao = new KvizDao() : kdao;
	}

	private KvizDao() {
	}

	public Collection<Long> ispisAktivnihAnketa() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("select _id from Kviz k where k._aktivan= true");

		t.commit();

		Collection<Long> c = q.list();
		session.close();
		return c;
	}

	public Collection<Long> ispisSvihAnketa() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select _id from Kviz k ");

		t.commit();

		Collection<Long> c = q.list();
		session.close();
		return c;
	}
	
	public Boolean imaSaIstimNazivom(String naziv) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Kviz k where k._naziv = :naziv");
		q.setParameter("naziv", naziv);
		try {
			Long broj = (Long)q.uniqueResult();
		}
		catch (Exception e1) {
			throw new Exception("Anketa s tim imenom već postoji!");
		}
		
		t.commit();
		
		session.close();
		return false;
	}
}
