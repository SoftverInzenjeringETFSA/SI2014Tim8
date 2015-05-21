package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.mapping.List;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class AdministratorDao extends BaseDao<Administrator> {

	private static AdministratorDao adao = null;

	public static AdministratorDao get() {
		return (adao == null) ? adao = new AdministratorDao() : adao;
	}
	private AdministratorDao () {}

	public boolean pretraziPoUsernamu(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._username = :nesto");
		q.setParameter("nesto", username);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
		
		if (!alist.isEmpty()) {
			t.commit();
			session.close();
			return true;
		} else {
			t.commit();
			session.close();
			return false;
		}
	}
	
	public boolean pretraziAdmina(String username,char [] password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._username = :nesto and a._password=md5(:nestodrugo)");
		q.setParameter("nesto", username);
		q.setParameter("nestodrugo", password);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
		
		if (!alist.isEmpty()) {
			t.commit();
			session.close();
			return true;
		} else {
			t.commit();
			session.close();
			return false;
		}
	}
	
	public Collection<Administrator> dajPoUsernamu(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._username = :nesto order by a._username");
		q.setParameter("nesto", username);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	
	public Collection<Administrator> dajPoImenu(String ime) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._ime = :nesto order by a._username");
		q.setParameter("nesto", ime);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	
	public Collection<Administrator> dajPoAdresi(String adresa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._adresa = :nesto order by a._username");
		q.setParameter("nesto", adresa);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	
	public Collection<Administrator> dajPoPrezimenu(String prezime) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._prezime = :nesto order by a._username");
		q.setParameter("nesto", prezime);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	
	public Collection<String> dajUsernames()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select distinct a._username from Administrator a order by a._username");
		t.commit();
		Collection<String> c = q.list();
		session.close();
		return c;
	}
	
	public Collection<String> dajPassword()
	{Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	Query q = session.createQuery("select distinct a._password from Administrator a order by a._password");
	t.commit();
	Collection<String> c = q.list();
	session.close();
	return c;
		
		
	}
	
	public Collection<String> dajImena()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select distinct a._ime from Administrator a  order by a._ime");
		t.commit();
		Collection<String> c = q.list();
		session.close();
		return c;
	}
	
	public Collection<String> dajPrezimena()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select distinct a._prezime from Administrator a order by a._prezime");
		t.commit();
		Collection<String> c = q.list();
		session.close();
		return c;
	}

	
	public Collection<String> dajAdrese()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select distinct a._adresa from Administrator a order by a._adresa");
		t.commit();
		Collection<String> c = q.list();
		session.close();
		return c;
	}
	
	public static Administrator  nadjiAdministratora(Session s, String ime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	Criteria k= session. createCriteria(AdministratorDao.class);
	Administrator a=(Administrator)k.uniqueResult();
	t.commit();
		
		return a;
	}
	
	
}
