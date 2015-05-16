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

	
}
