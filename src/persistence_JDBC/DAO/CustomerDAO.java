package persistence_JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Customer;
import persistence_JDBC.ConnectionFactory;

public class CustomerDAO implements DAO<Customer> {

	@Override
	public int create(Customer customer) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into customers(first_name, last_name, email, adress, customer_comment, organisation_id, discount_group) values(?,?,?,?,?,?,?)");
		statement.setString(1, customer.getFirst_name());
		statement.setString(2, customer.getLast_name());
		statement.setString(3, customer.getEmail());
		statement.setString(4, customer.getAdress());
		statement.setString(5, customer.getCustomer_comment());
		statement.setInt(6, customer.getOrganisation_id());
		statement.setInt(7, customer.getDiscount_group());
		return statement.executeUpdate();
		
		
	}

	@Override
	public Customer get(Object id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Customer object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
