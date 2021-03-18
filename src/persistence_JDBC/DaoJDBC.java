package persistence_JDBC;

import java.sql.SQLException;
import java.util.List;

public interface DaoJDBC<T> {

	
	public int create(T t) throws SQLException;
	
	T get(Object id) throws SQLException;
	
	public List<T> getAll() throws SQLException;
	
	public int update(T t) throws SQLException;
	
	public int delete(T t) throws SQLException;

}
