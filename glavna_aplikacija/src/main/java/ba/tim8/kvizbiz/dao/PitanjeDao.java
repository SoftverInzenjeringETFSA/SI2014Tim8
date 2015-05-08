package ba.tim8.kvizbiz.dao;

import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ba.tim8.kvizbiz.entiteti.Osoba;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class PitanjeDao implements IDao<Pitanje> {

	private static PitanjeDao pdao = null;

	public static PitanjeDao get() {
		return (pdao == null) ? pdao = new PitanjeDao() : pdao;
	}

	public void create(Pitanje object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		t.commit();
		session.close();
	}

	public Pitanje read(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Pitanje p = (Pitanje) session.get(Pitanje.class, id);
		t.commit();
		session.close();
		return p;
	}

	public void update(Pitanje object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}

	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((Pitanje) session.get(Pitanje.class, id));
		t.commit();
		session.close();
	}

	public Collection<Pitanje> readAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Pitanje");
		t.commit();
		session.close();
		return (Collection<Pitanje>) q.list();
	}
}
