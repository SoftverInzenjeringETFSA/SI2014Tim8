package ba.tim8.kvizbiz.dao;

import java.util.Collection;

public interface IDao<T> {
	
	public void create(T object);
	public T read(long id);
	public void update(T object);
	public void delete(long id);
	public Collection<T> readAll();
}
