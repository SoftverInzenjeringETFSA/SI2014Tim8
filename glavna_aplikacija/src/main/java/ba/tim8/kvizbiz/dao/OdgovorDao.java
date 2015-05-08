package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class OdgovorDao implements IDao<Odgovor> {

	private static OdgovorDao odao = null;

	public static OdgovorDao get() {
		return (odao == null) ? odao = new OdgovorDao() : odao;
	}

	public void create(Odgovor object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		t.commit();
		session.close();
	}

	public Odgovor read(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Odgovor o = (Odgovor) session.get(Odgovor.class, id);
		t.commit();
		session.close();
		return o;
	}

	public void update(Odgovor object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}

	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((Odgovor) session.get(Odgovor.class, id));
		t.commit();
		session.close();
	}

	public Collection<Odgovor> readAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Odgovor");
		t.commit();
		session.close();
		return (Collection<Odgovor>) q.list();
	}
}
