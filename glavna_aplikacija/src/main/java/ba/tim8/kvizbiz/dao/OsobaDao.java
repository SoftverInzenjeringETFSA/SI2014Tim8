package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Osoba;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class OsobaDao implements IDao<Osoba> {

	private static OsobaDao odao = null;

	public static OsobaDao get() {
		return (odao == null) ? odao = new OsobaDao() : odao;
	}

	public void create(Osoba object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		t.commit();
		session.close();
	}

	public Osoba read(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Osoba o = (Osoba) session.get(Osoba.class, id);
		t.commit();
		session.close();
		return o;
	}

	public void update(Osoba object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}

	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((Osoba) session.get(Osoba.class, id));
		t.commit();
		session.close();
	}

	public Collection<Osoba> readAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Osoba");
		t.commit();
		session.close();
		return (Collection<Osoba>) q.list();
	}
}
