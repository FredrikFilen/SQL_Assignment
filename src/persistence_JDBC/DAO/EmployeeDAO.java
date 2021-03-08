package persistence_JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import persistence_JDBC.ConnectionFactory;

public class EmployeeDAO implements DAO<Employee> {

	@Override
	public int create(Employee employee) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into customers(first_name, last_name, email, address, employee_comment, office_id) values(?,?,?,?,?,?)");
		statement.setString(1, employee.getFirst_name());
		statement.setString(2, employee.getLast_name());
		statement.setString(3, employee.getEmail());
		statement.setString(4, employee.getAddress());
		statement.setString(5, employee.getEmployee_comment());
		statement.setInt(6, employee.getOffice_id());
		return statement.executeUpdate();
		
	}

	@Override
	public Employee get(Object id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from employees where employee_id = ?");
		statement.setInt(1, (int)id);
		ResultSet rs = statement.executeQuery();
		Employee employee = null;
		if(rs.next()) {
			employee = new Employee();
			employee.setEmployee_id(rs.getInt("employee_id"));
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setAddress(rs.getString("address"));
			employee.setEmployee_comment(rs.getString("employee_comment"));
			employee.setOffice_id(rs.getInt("office_id"));
		}
		return employee;
	}

	@Override
	public List<Employee> getAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from employees");
		ResultSet rs = statement.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setEmployee_id(rs.getInt("employee_id"));
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setAddress(rs.getString("address"));
			employee.setEmployee_comment(rs.getString("employee_comment"));
			employee.setOffice_id(rs.getInt("office_id"));
			employees.add(employee);
			
		}
		return employees;
	}

	@Override
	public int update(Employee employee) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("update employees"
				+ " set first_name = ?,"
				+ " set last_name = ?,"
				+ " set email = ?,"
				+ " set address = ?,"
				+ " set employee_comment = ?,"
				+ " set office_id = ?,"
				+ " where employee_id = ?");
		statement.setString(1, employee.getFirst_name());
		statement.setString(2, employee.getLast_name());
		statement.setString(3, employee.getEmail());
		statement.setString(4, employee.getAddress());
		statement.setString(5, employee.getEmployee_comment());
		statement.setInt(6, employee.getOffice_id());
		statement.setInt(7, employee.getEmployee_id());
		return statement.executeUpdate();
		
	}

	@Override
	public int delete(Employee employee) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from employees where employee_id = ?");
		statement.setInt(1, employee.getEmployee_id());
		return statement.executeUpdate();
		
	}

}
