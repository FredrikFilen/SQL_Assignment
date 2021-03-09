package service;

import java.sql.SQLException;
import java.util.List;

import model.Employee;
import persistence_JDBC.DAO.EmployeeDAO;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public boolean createEmployee(Employee employee) {
		int result = 0;
		try {
			result = employeeDAO.create(employee);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public Employee getEmployee(int id) {
		Employee employee = null;
		try {
			employee = employeeDAO.get(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = null;
		try {
			employees = employeeDAO.getAll();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return employees;
	}
	
	public boolean updateEmployee(Employee employee) {
		int result = 0;
		try {
			result = employeeDAO.update(employee);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public boolean deleteEmployee(Employee employee) {
		int result = 0;
		try {
			result = employeeDAO.delete(employee);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		return result == 1 ? true : false;
	}
}
