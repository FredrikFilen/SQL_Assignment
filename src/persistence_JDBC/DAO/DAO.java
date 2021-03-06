package persistence_JDBC.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

	
	public int create(T t) throws SQLException;
	
	T get(Object id) throws SQLException;
	
	public List<T> getAll() throws SQLException;
	
	public void update(T t) throws SQLException;
	
	public void delete(T t) throws SQLException;

}
