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

	public boolean pretraziPoUsernamu(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session
				.createQuery("from Administrator a where a._username = :nesto");
		if (q.setString("nesto", username).getFetchSize() == 1) {
			t.commit();
			session.close();
			return true;
		} else {
			t.commit();
			session.close();
			return false;
		}
	}
}
