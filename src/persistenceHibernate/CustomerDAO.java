package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

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
	
	public Customer getBestCustomer() throws SQLException{
		Customer customer = null;
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "SELECT customer_id, SUM(p.product_price * o.amount) AS total"
				+ " FROM orders o left join customers c using (customer_id) left join products p using(product_id)"
				+ " group by customer_id order by total desc limit 1";
		Query q = session.createNativeQuery(sql);
		List<Object[]> results = q.getResultList();
		
		for(Object[] o : results) {
			customer = get(o[0]);
		}
		session.getTransaction().commit();
		session.close();
		return customer;
		
	}

}
