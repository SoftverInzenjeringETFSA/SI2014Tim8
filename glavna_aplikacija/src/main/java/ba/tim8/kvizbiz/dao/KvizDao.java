package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class KvizDao implements IDao<Kviz>{

	private static KvizDao kdao=null;	
	public static KvizDao get()
    {
        return (kdao == null) ? kdao = new KvizDao() : kdao;
    }
	
	public void create(Kviz object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		t.commit();
		session.close();		
	}

	public Kviz read(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Kviz k = (Kviz) session.get(Kviz.class, id);
		t.commit();
		session.close();
		return k;
	}

	public void update(Kviz object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}

	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((Kviz) session.get(Kviz.class, id));
		t.commit();
		session.close();
	}

	public Collection<Kviz> readAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Kviz");
		t.commit();
		session.close();
		return (Collection<Kviz>) q.list();
	}
}
