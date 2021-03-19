package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Customer;
import model.Employee;

public class EmployeeDAO implements DaoHibernate<Employee> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public EmployeeDAO() {
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
	public void create(Employee employee) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Employee get(Object id) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		Employee employee = session.get(Employee.class, (int)id);
		
		session.getTransaction().commit();
		session.close();
		return employee;
	}

	@Override
	public List<Employee> getAll() throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Employee> employees = loadAllData(Employee.class, session);
		
		session.getTransaction().commit();
		session.close();
		
		return employees;
	}

	@Override
	public void update(Employee employee) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(employee);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void delete(Employee employee) throws SQLException {
		Session session = connectionFactoryHibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.delete(employee);
		
		session.getTransaction().commit();
		session.close();
	}

}
