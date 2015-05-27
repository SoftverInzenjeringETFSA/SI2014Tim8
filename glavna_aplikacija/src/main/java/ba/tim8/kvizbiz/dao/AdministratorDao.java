package ba.tim8.kvizbiz.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

import org.apache.log4j.Logger;

public class AdministratorDao extends BaseDao<Administrator> {

	final static Logger logger = Logger.getLogger(AdministratorDao.class);

	private static AdministratorDao adao = null;

	public static AdministratorDao get() {
		return (adao == null) ? adao = new AdministratorDao() : adao;
	}

	private AdministratorDao() {
	}

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

	public boolean pretraziAdmina(String username, char[] password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._username = :nesto and a._password=md5(:nestodrugo)"); // NOSONAR
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
				.createQuery("from Administrator a where a._ime = :nesto order by a._username"); // NOSONAR
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

	public Collection<Administrator> dajPoDatumu(String datum) throws Exception {

		Date date = new Date(0);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			date = sdf.parse(datum);
		}

		catch (Exception e) {
			logger.error("Greska: ", e);
			throw e;
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._datumRodjenja = :nesto order by a._username");
		q.setParameter("nesto", date);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
		t.commit();
		session.close();
		return alist;
	}

	public Collection<Administrator> dajPoTelefonu(String telefon) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._telefon = :nesto order by a._username");
		q.setParameter("nesto", telefon);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
		t.commit();
		session.close();
		return alist;
	}

	public Collection<Administrator> dajPoMailu(String mail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._eMail = :nesto order by a._username");
		q.setParameter("nesto", mail);
		Collection<Administrator> alist = (Collection<Administrator>) q.list();
		t.commit();
		session.close();
		return alist;
	}

	public static Administrator nadjiAdministratora(Session s, String ime) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Criteria k = session.createCriteria(AdministratorDao.class);
		Administrator a = (Administrator) k.uniqueResult();
		t.commit();

		return a;
	}

	public void updatePass(Administrator a) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			String text = a.get_password();
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(text.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			Query q = session
					.createQuery("UPDATE Administrator a set a._password = :nesto WHERE a._id = :idneki");
			q.setParameter("nesto", hashtext);
			q.setParameter("idneki", a.get_id());
			q.executeUpdate();
			t.commit();
			session.close();
		} catch (Exception ex) {
			logger.error("Greska: ", ex);
		}
	}

}
