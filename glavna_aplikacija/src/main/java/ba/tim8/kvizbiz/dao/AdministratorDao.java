package ba.tim8.kvizbiz.dao;

import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.mapping.List;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class AdministratorDao implements IDao<Administrator> {

	private static AdministratorDao adao = null;

	public static AdministratorDao get() {
		return (adao == null) ? adao = new AdministratorDao() : adao;
	}

	public void create(Administrator object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		t.commit();
		session.close();
	}

	public Administrator read(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Administrator a = (Administrator) session.get(Administrator.class, id);
		t.commit();
		session.close();
		return a;
	}

	public void update(Administrator object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}

	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((Administrator) session.get(Administrator.class, id));
		t.commit();
		session.close();
	}

	public Collection<Administrator> readAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Administrator");
		t.commit();
		session.close();
		return (Collection<Administrator>) q.list();
	}
}
