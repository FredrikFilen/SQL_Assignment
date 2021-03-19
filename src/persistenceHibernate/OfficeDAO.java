package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Customer;
import model.Office;

public class OfficeDAO implements DaoHibernate<Office> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public OfficeDAO() {
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
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Office> offices = loadAllData(Office.class, session);
		
		session.getTransaction().commit();
		session.close();
		
		return offices;
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
