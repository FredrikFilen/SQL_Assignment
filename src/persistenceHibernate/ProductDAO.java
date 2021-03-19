package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Customer;
import model.Product;

public class ProductDAO implements DaoHibernate<Product> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public ProductDAO() {
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
	public void create(Product t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Product get(Object id) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		Product product = session.get(Product.class, (int)id);
		
		session.getTransaction().commit();
		session.close();
		return product;
	}

	@Override
	public List<Product> getAll() throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Product> products = loadAllData(Product.class, session);
		
		session.getTransaction().commit();
		session.close();
		
		return products;
	}

	@Override
	public void update(Product t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Product t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
