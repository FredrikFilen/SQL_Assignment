package persistence_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;

public class OrderDAO implements DaoJDBC<Order> {

	@Override
	public int create(Order order) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into orders(product_id, customer_id, amount, order_date, requested_shipping_date, shipping_date)values(?,?,?,?,?,?)");
		statement.setInt(1, order.getProduct_id());
		statement.setInt(2, order.getCustomer_id());
		statement.setInt(3, order.getAmount());
		statement.setString(4, order.getOrder_date());
		statement.setString(5, order.getRequested_shipping_date());
		statement.setString(6, order.getShipping_date());
		return statement.executeUpdate();
		
	}

	@Override
	public Order get(Object id) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from orders where order_id = ?");
		statement.setInt(1, (int)id);
		ResultSet rs = statement.executeQuery();
		Order order = null;
		if(rs.next()) {
			order = new Order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setProduct_id(rs.getInt("product_id"));
			order.setCustomer_id(rs.getInt("customer_id"));
			order.setAmount(rs.getInt("amount"));
			order.setOrder_date(rs.getString("order_date"));
			order.setRequested_shipping_date(rs.getString("requested_shipping_date"));
			order.setShipping_date(rs.getString("shipping_date"));
		}
		return order;
	}

	@Override
	public List<Order> getAll() throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from orders");
		ResultSet rs = statement.executeQuery();
		List<Order> orders = new ArrayList<>();
		while(rs.next()) {
			Order order = new Order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setProduct_id(rs.getInt("product_id"));
			order.setCustomer_id(rs.getInt("customer_id"));
			order.setAmount(rs.getInt("amount"));
			order.setOrder_date(rs.getString("order_date"));
			order.setRequested_shipping_date(rs.getString("requested_shipping_date"));
			order.setShipping_date(rs.getString("shipping_date"));
			orders.add(order);
			
				
		}
		return orders;
	}

	@Override
	public int update(Order order) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("update orders"
				+ " set product_id = ?,"
				+ " customer_id = ?,"
				+ " amount = ?,"
				+ " order_date = ?,"
				+ " requested_shipping_date = ?,"
				+ " shipping_date = ?"
				+ " where order_id = ?");
		statement.setInt(1, order.getProduct_id());
		statement.setInt(2, order.getCustomer_id());
		statement.setInt(3, order.getAmount());
		statement.setString(4, order.getOrder_date());
		statement.setString(5, order.getRequested_shipping_date());
		statement.setString(6, order.getShipping_date());
		statement.setInt(7, order.getOrder_id());
		return statement.executeUpdate();
		
	}

	@Override
	public int delete(Order order) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from orders where order_id = ?");
		statement.setInt(1, order.getOrder_id());
		return statement.executeUpdate();
		
	}

}
