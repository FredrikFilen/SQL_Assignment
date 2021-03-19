package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Customer;
import model.Reclaim;

public class ReclaimDAO implements DaoHibernate<Reclaim> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public ReclaimDAO() {
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
	public void create(Reclaim t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Reclaim get(Object id) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		Reclaim reclaim = session.get(Reclaim.class, (int)id);
		
		session.getTransaction().commit();
		session.close();
		return reclaim;
	}

	@Override
	public List<Reclaim> getAll() throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Reclaim> reclaims = loadAllData(Reclaim.class, session);
		
		session.getTransaction().commit();
		session.close();
		
		return reclaims;
	}

	@Override
	public void update(Reclaim t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Reclaim t) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(t);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
