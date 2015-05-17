package ba.tim8.kvizbiz.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



import ba.tim8.kvizbiz.konekcija.HibernateUtil;

public abstract class BaseDao<T> implements IDao<T>
{
	
	
	public Class<T> getClassOfT() {
	    final ParameterizedType type = (ParameterizedType) this.getClass()
	            .getGenericSuperclass();
	    Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
	    return clazz;
	}
	
	
	public long create(T object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		long id =  (Long) session.save(object);
		t.commit();
		session.close();
		return id;		
	}

	public T read(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		T k = (T) session.get(getClassOfT(), id);
		t.commit();
		session.close();
		return k;
	}

	public void update(T object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}

	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((T) session.get(getClassOfT(), id));
		t.commit();
		session.close();
	}

	public Collection<T> readAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from " + getClassOfT().getSimpleName());
		t.commit();
		Collection<T> c = q.list();
		session.close();
		return c;
	}
	
	public void deleteAll()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("delete from " + getClassOfT().getSimpleName());
		q.executeUpdate();
		t.commit();
		session.close();
		
	}
	


}
