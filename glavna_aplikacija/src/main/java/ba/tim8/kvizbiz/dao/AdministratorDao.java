package ba.tim8.kvizbiz.dao;

import java.util.Collection;
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
	
	

	
}
