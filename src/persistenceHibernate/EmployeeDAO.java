package persistenceHibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import model.Employee;

public class EmployeeDAO implements DaoHibernate<Employee> {
	
	ConnectionFactoryHibernate connectionFactoryHibernate;
	public EmployeeDAO() {
		connectionFactoryHibernate = ConnectionFactoryHibernate.getInstance();
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
		// TODO Auto-generated method stub
		return null;
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
