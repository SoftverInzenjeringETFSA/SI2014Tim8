/*
package ba.tim8.kvizbiz.konekcija;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {

		try {
		    Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Exception ex) {

			System.err.println("Initial SessionFactory creation failed." + ex);

			throw new ExceptionInInitializerError(ex);

		}

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

}
*/
package ba.tim8.kvizbiz.konekcija;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.apache.log4j.Logger;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	final static Logger logger = Logger.getLogger(HibernateUtil.class);
	static {
		try {
			java.util.Properties properties = new Properties();
			properties.load(new FileInputStream("db.properties"));
		    Configuration configuration = new Configuration();
		    configuration.configure().addProperties(properties);
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception ex) {
			logger.error("Initial SessionFactory creation failed." + ex.getMessage());
			logger.error("Initial SessionFactory creation failed." + ex.getCause());
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
