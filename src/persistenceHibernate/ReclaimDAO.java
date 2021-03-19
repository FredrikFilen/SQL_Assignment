package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import model.Reclaim;

public class ReclaimDAO implements DaoHibernate<Reclaim> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public ReclaimDAO() {
		connectionFactoryHibernate = ConnectionFactoryHibernate.getInstance();
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
		// TODO Auto-generated method stub
		return null;
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
