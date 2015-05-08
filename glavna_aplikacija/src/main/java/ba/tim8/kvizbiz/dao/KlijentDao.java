package ba.tim8.kvizbiz.dao;

import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class KlijentDao implements IDao<Klijent> {

	private static KlijentDao kdao = null;

	public static KlijentDao get() {
		return (kdao == null) ? kdao = new KlijentDao() : kdao;
	}

	public void create(Klijent object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		t.commit();
		session.close();
	}

	public Klijent read(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Klijent k = (Klijent) session.get(Klijent.class, id);
		t.commit();
		session.close();
		return k;
	}

	public void update(Klijent object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}

	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((Klijent) session.get(Klijent.class, id));
		t.commit();
		session.close();
	}

	public Collection<Klijent> readAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Klijent");
		t.commit();
		session.close();
		return (Collection<Klijent>) q.list();
	}
}
