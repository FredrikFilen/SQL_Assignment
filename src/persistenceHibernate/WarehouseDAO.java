package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Customer;
import model.Warehouse;

public class WarehouseDAO implements DaoHibernate<Warehouse> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public WarehouseDAO() {
		connectionFactoryHibernate = ConnectionFactoryHibernate.getInstance();
	}
	
	private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
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
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Warehouse> warehouses = loadAllData(Warehouse.class, session);
		
		session.getTransaction().commit();
		session.close();
		
		return warehouses;
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
