package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

public interface DaoHibernate<T> {
	
	public void create(T t) throws SQLException;
	
	public T get(Object id) throws SQLException;
	
	public List<T> getAll() throws SQLException;
	
	public void update(T t) throws SQLException;
	
	public void delete(T t) throws SQLException;

}
