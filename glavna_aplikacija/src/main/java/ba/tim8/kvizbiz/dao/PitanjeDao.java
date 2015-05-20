package ba.tim8.kvizbiz.dao;

import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ba.tim8.kvizbiz.entiteti.Osoba;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public class PitanjeDao extends BaseDao<Pitanje> {

	private static PitanjeDao pdao = null;

	public static PitanjeDao get() {
		return (pdao == null) ? pdao = new PitanjeDao() : pdao;
	}

	private PitanjeDao(){}
}
