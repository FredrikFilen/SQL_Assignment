package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import model.Product;

public class ProductDAO implements DaoHibernate<Product> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public ProductDAO() {
		connectionFactoryHibernate = ConnectionFactoryHibernate.getInstance();
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
		// TODO Auto-generated method stub
		return null;
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
