package ba.tim8.kvizbiz.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Odgovor;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class OdgovorDao extends BaseDao<Odgovor> {

	private static OdgovorDao odao = null;

	public static OdgovorDao get() {
		return (odao == null) ? odao = new OdgovorDao() : odao;
	}
	
	private OdgovorDao(){}
	
	public void izbrisiSveOdgovoreKlijenta(Klijent k)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("delete from Odgovor o join o._klijenti k where k._id = :nesto");
		q.setLong("nesto", k.get_id()).executeUpdate();
		t.commit();
		session.close();		
	}
	
	public List dajOdgovore(int pitanjeID){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select _id, _pitanje, _tekstOdgovora from Odgovor o where o._pitanje = :qId");
		q.setLong("qId", pitanjeID).executeUpdate();
		List c = q.list();
		t.commit();
		session.close();
		return c;
	}

	public void IzbrisiSveOdgovorePitanja(int pitanjeZaModicikaciju) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("delete from Odgovor where _pitanje = :nesto");
		q.setLong("nesto", pitanjeZaModicikaciju).executeUpdate();
		t.commit();
		session.close();		
	}
	
	public Collection<Odgovor> DajSveZaPitanje(long pitanje) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("select _id from Odgovor where _pitanje._id = :parametar");
		q.setParameter("parametar", pitanje);
		Collection<Long> plist = (Collection<Long>) q.list();
		t.commit();
		session.close();
		return napraviObjekte(plist);
	}
	
	private Collection<Odgovor> napraviObjekte(Collection<Long> idAnkete)
	{
		Collection<Odgovor> rezultat = new ArrayList<Odgovor>();
		for(int i=0;i<idAnkete.size();i++)
		{
			rezultat.add(read(((ArrayList<Long>)idAnkete).get(i)));
		}
		
		return rezultat;
	}
}
