package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Customer;
import model.Order;

public class OrderDAO implements DaoHibernate<Order>{
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public OrderDAO() {
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
	public void create(Order order) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(order);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Order get(Object id) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		Order order = session.get(Order.class, (int)id);
		
		session.getTransaction().commit();
		session.close();
		return order;
	}

	@Override
	public List<Order> getAll() throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Order> orders = loadAllData(Order.class, session);
		
		session.getTransaction().commit();
		session.close();
		
		return orders;
	}

	@Override
	public void update(Order order) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(order);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Order order) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(order);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
