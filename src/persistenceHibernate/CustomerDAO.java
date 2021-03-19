package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import model.Customer;

public class CustomerDAO implements DaoHibernate<Customer> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public CustomerDAO() {
		connectionFactoryHibernate = ConnectionFactoryHibernate.getInstance();
	}

	@Override
	public void create(Customer customer) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(customer);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Customer get(Object id) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		Customer customer = session.get(Customer.class, (int)id);
		
		session.getTransaction().commit();
		session.close();
		
		return customer;
	}

	@Override
	public List<Customer> getAll() throws SQLException {
		
		return null;
	}

	@Override
	public void update(Customer customer) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(customer);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Customer customer) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(customer);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
