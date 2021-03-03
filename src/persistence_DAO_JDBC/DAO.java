package persistence_DAO_JDBC;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

	
	public void save(T object) throws SQLException;
	
	public T get(int id) throws SQLException;
	
	public List<T> getAll() throws SQLException;
	
	public void update(T object) throws SQLException;
	
	public void delete(T object) throws SQLException;

}
