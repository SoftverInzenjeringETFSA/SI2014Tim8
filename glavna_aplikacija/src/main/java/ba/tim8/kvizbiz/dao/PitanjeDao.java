package ba.tim8.kvizbiz.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Osoba;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class PitanjeDao extends BaseDao<Pitanje> {

	private static PitanjeDao pdao = null;

	public static PitanjeDao get() {
		return (pdao == null) ? pdao = new PitanjeDao() : pdao;
	}

	private PitanjeDao(){}
	public Collection<Pitanje> dajPitanja(long kvizID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select _id, _tipPitanja, _kviz, _tekstPitanja, obavezno from Pitanje p where p._kviz=:id");
		q.setLong("id", kvizID).executeUpdate();
		t.commit();
		Collection<Pitanje> c = q.list();
		session.close();
		return c;
	}
	
	public Collection<Long> DajSveIdZaKviz(long kviz) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select _id from Pitanje where _kviz.id = :parametar");
		q.setParameter("parametar", kviz);
		Collection<Long> plist = (Collection<Long>) q.list();
		t.commit();
		session.close();
		return plist;
	}
	
	public Collection<Pitanje> DajSveZaKviz(long kviz) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select _id from Pitanje where _kviz.id = :parametar");
		q.setParameter("parametar", kviz);
		Collection<Long> plist = (Collection<Long>) q.list();
		t.commit();
		session.close();
		return napraviObjekte(plist);
	}
	
	private Collection<Pitanje> napraviObjekte(Collection<Long> idAnkete)
	{
		Collection<Pitanje> rezultat = new ArrayList<Pitanje>();
		for(int i=0;i<idAnkete.size();i++)
		{
			rezultat.add(read(((ArrayList<Long>)idAnkete).get(i)));
		}
		
		return rezultat;
	}
}
