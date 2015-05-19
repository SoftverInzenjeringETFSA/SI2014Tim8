package ba.tim8.kvizbiz.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class KlijentDao extends BaseDao<Klijent> {

	private static KlijentDao kdao = null;

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
}
