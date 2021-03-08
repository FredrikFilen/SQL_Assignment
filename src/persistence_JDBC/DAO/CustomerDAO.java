package persistence_JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import persistence_JDBC.ConnectionFactory;

public class CustomerDAO implements DAO<Customer> {

	@Override
	public int create(Customer customer) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into customers(first_name, last_name, email, address, customer_comment, organisation_id, discount_group) values(?,?,?,?,?,?,?)");
		statement.setString(1, customer.getFirst_name());
		statement.setString(2, customer.getLast_name());
		statement.setString(3, customer.getEmail());
		statement.setString(4, customer.getAddress());
		statement.setString(5, customer.getCustomer_comment());
		statement.setInt(6, customer.getOrganisation_id());
		statement.setInt(7, customer.getDiscount_group());
		return statement.executeUpdate();
		
		
	}

	@Override
	public Customer get(Object id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from customers where customer_id = ?");
		statement.setInt(1, (int)id);
		ResultSet rs = statement.executeQuery();
		Customer customer = null;
		if(rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("customer_id"));
			customer.setFirst_name(rs.getString("first_name"));
			customer.setLast_name(rs.getString("last_name"));
			customer.setEmail(rs.getString("email"));
			customer.setAddress(rs.getString("address"));
			customer.setCustomer_comment(rs.getString("customer_comment"));
			customer.setOrganisation_id(rs.getInt("organisation_id"));
			customer.setDiscount_group(rs.getInt("discount_group"));
		}
		return customer;
	}

	@Override
	public List<Customer> getAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from customers");
		ResultSet rs = statement.executeQuery();
		List<Customer> customers = new ArrayList<>();
		while(rs.next()){
			Customer customer = new Customer();
			customer.setId(rs.getInt("customer_id"));
			customer.setFirst_name(rs.getString("first_name"));
			customer.setLast_name(rs.getString("last_name"));
			customer.setEmail(rs.getString("email"));
			customer.setAddress(rs.getString("address"));
			customer.setCustomer_comment(rs.getString("customer_comment"));
			customer.setOrganisation_id(rs.getInt("organisation_id"));
			customer.setDiscount_group(rs.getInt("discount_group"));
			customers.add(customer);
			
		}
		return customers;
	}

	@Override
	public int update(Customer object) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("update customers"
				+ " set first_name = ?,"
				+ " set last_name = ?,"
				+ " set email = ?,"
				+ " set address = ?,"
				+ " set customer_comment = ?,"
				+ " set organisation_id = ?,"
				+ " set discount_group = ?"
				+ " where customer_id = ?");
		statement.setString(1, object.getFirst_name());
		statement.setString(2, object.getLast_name());
		statement.setString(3, object.getEmail());
		statement.setString(4, object.getAddress());
		statement.setString(5, object.getCustomer_comment());
		statement.setInt(6, object.getOrganisation_id());
		statement.setInt(7, object.getDiscount_group());
		statement.setInt(8, object.getId());
		return statement.executeUpdate();
		
	}

	@Override
	public int delete(Customer object) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from customers where customer_id = ?");
		statement.setInt(1, object.getId());
		return statement.executeUpdate();
		
	}

}
