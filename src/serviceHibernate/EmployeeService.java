package serviceHibernate;

import java.sql.SQLException;
import java.util.List;

import model.Employee;
import persistenceHibernate.EmployeeDAO;

public class EmployeeService {
	private EmployeeDAO employeeDao = new EmployeeDAO();
	
	public void createEmployee(Employee employee) {
		try {
			employeeDao.create(employee);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	public Employee getEmployee(int id) {
		Employee employee = null;
		try {
			employee = employeeDao.get(id);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = null;
		try {
			employees = employeeDao.getAll();
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		
		return employees;
	}
	
	public void updateEmployee(Employee employee) {
		try {
			employeeDao.update(employee);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public void deleteEmployee(Employee employee) {
		try {
			employeeDao.delete(employee);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	

}
