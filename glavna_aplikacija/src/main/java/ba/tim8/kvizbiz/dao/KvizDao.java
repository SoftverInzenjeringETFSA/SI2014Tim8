package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class KvizDao extends BaseDao<Kviz>{

	private static KvizDao kdao=null;	
	public static KvizDao get()
    {
        return (kdao == null) ? kdao = new KvizDao() : kdao;
    }
	
	public void izbrisiKlijenta(Klijent k)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("delete from Kviz k join k._klijenti kl where kl._id = :nesto");
		q.setLong("nesto", k.get_id()).executeUpdate();
		t.commit();
		session.close();		
	}	
	
	public Collection<Object>  ispisAktivnihAnketa()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select id,naziv from Kviz k where k._aktivan= 1");
	
		t.commit();
		
		Collection<Object> c = q.list();
		session.close();
		return c;
	}
}
