package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import model.Warehouse;

public class WarehouseDAO implements DaoHibernate<Warehouse> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public WarehouseDAO() {
		connectionFactoryHibernate = ConnectionFactoryHibernate.getInstance();
	}

	@Override
	public void create(Warehouse t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Warehouse get(Object id) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		Warehouse warehouse = session.get(Warehouse.class, (int)id);
		
		session.getTransaction().commit();
		session.close();
		return warehouse;
	}

	@Override
	public List<Warehouse> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Warehouse t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Warehouse t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
