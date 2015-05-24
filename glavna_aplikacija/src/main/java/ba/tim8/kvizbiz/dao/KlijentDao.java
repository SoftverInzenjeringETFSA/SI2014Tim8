package ba.tim8.kvizbiz.dao;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.forme.KreiranjeAnkete;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

import org.apache.log4j.Logger;

public class KlijentDao extends BaseDao<Klijent> {
	
	final static Logger logger = Logger.getLogger(KlijentDao.class);

	private static KlijentDao kdao = null;
	public KlijentDao() {}
	public static KlijentDao get() {
		return (kdao == null) ? kdao = new KlijentDao() : kdao;
	}
	
	public Collection<Klijent> dajKlijenta(String proslijedjeno) {
		String ime,prezime;
		int razmak=proslijedjeno.indexOf(" ");
		prezime=proslijedjeno.substring(razmak+1,proslijedjeno.length());
		ime=proslijedjeno.substring(0,razmak);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Klijent k where k._ime = :nesto and k._prezime=:nestodrugo");
		q.setParameter("nesto", ime);
		q.setParameter("nestodrugo", prezime);
		Collection<Klijent> klist = (Collection<Klijent>) q.list();
			t.commit();
			session.close();
			return klist;
		 }
	
	public Collection<String>  ispisImenaPrezimenaKlijenata()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select concat(k._prezime,' ',k._ime) from Klijent k  order by k._prezime");
		t.commit();
		Collection<String> c = q.list();
		session.close();
		return c;
	}	
	
	public Collection<Klijent> dajPoImenu(String ime) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Klijent a where a._ime = :nesto order by a._prezime");
		q.setParameter("nesto", ime);
		Collection<Klijent> alist = (Collection<Klijent>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	
	public Collection<Klijent> dajPoAdresi(String adresa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Klijent a where a._adresa = :nesto order by a._prezime");
		q.setParameter("nesto", adresa);
		Collection<Klijent> alist = (Collection<Klijent>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	
	public Collection<Klijent> dajPoPrezimenu(String prezime) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Klijent a where a._prezime = :nesto order by a._prezime");
		q.setParameter("nesto", prezime);
		Collection<Klijent> alist = (Collection<Klijent>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	public Collection<Klijent> dajPoDatumu(String datum) throws Exception {
		
		Date date = new Date(0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			date = sdf.parse(datum);
		 }
		catch(Exception e){logger.error("Greska: ", e); throw e;}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Klijent a where a._datumRodjenja = :nesto order by a._prezime");
		q.setParameter("nesto", date);
		Collection<Klijent> alist = (Collection<Klijent>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	public Collection<Klijent> dajPoTelefonu(String telefon) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Klijent a where a._telefon = :nesto order by a._prezime");
		q.setParameter("nesto", telefon);
		Collection<Klijent> alist = (Collection<Klijent>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
	public Collection<Klijent> dajPoMailu(String mail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Klijent a where a._eMail = :nesto order by a._prezime");
		q.setParameter("nesto", mail);
		Collection<Klijent> alist = (Collection<Klijent>) q.list();
			t.commit();
			session.close();
			return alist;
		 }
}
