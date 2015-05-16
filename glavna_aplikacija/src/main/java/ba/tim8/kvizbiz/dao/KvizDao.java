package ba.tim8.kvizbiz.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class KvizDao extends BaseDao<Kviz>{

	private static KvizDao kdao=null;	
	public static KvizDao get()
    {
        return (kdao == null) ? kdao = new KvizDao() : kdao;
    }
	
	
}
