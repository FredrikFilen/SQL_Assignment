package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import model.Office;

public class OfficeDAO implements DaoHibernate<Office> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public OfficeDAO() {
		connectionFactoryHibernate = ConnectionFactoryHibernate.getInstance();
	}

	@Override
	public void create(Office office) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(office);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Office get(Object id) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		Office office = session.get(Office.class, (int)id);
		
		session.getTransaction().commit();
		session.close();
		return office;
	}

	@Override
	public List<Office> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Office office) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(office);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Office office) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(office);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
