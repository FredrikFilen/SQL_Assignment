package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Customer;

public class CustomerDAO implements DaoHibernate<Customer> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public CustomerDAO() {
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
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Customer> customers = loadAllData(Customer.class, session);
		
		session.getTransaction().commit();
		session.close();
		
		return customers;
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
