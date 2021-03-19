package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import model.Order;

public class OrderDAO implements DaoHibernate<Order>{
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public OrderDAO() {
		connectionFactoryHibernate = ConnectionFactoryHibernate.getInstance();
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
		// TODO Auto-generated method stub
		return null;
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
