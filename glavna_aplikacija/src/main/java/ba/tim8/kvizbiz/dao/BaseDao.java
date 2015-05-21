package ba.tim8.kvizbiz.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

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
		Query q = session.createQuery("select id from " + getClassOfT().getSimpleName());
		Collection<Long> c = (Collection<Long>) q.list();
		t.commit();
		session.close();
		return napraviObjekte(c);
		
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
	
	private Collection<T> napraviObjekte(Collection<Long> ids)
	{
		Collection<T> r = new ArrayList<T>();
		for(int i=0;i<ids.size();i++)
		{
			r.add(read(((ArrayList<Long>)ids).get(i)));
		}
		
		return r;
	}
	


}
