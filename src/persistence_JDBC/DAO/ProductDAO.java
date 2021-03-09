package persistence_JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import persistence_JDBC.ConnectionFactory;

public class ProductDAO implements DAO<Product> {

	@Override
	public int create(Product product) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into products(product_name, product_description, product_price, stock_amount, warehouse_id)values(?,?,?,?,?)");
		statement.setString(1, product.getProduct_name());
		statement.setString(2, product.getProduct_description());
		statement.setDouble(3, product.getProduct_price());
		statement.setInt(4, product.getStock_amount());
		statement.setInt(5, product.getWarehouse_id());
		return statement.executeUpdate();
	}

	@Override
	public Product get(Object id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from products where product_id = ?");
		statement.setInt(1, (int)id);
		ResultSet rs = statement.executeQuery();
		Product product = null;
		if(rs.next()) {
			product = new Product();
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_description(rs.getString("product_description"));
			product.setProduct_price(rs.getDouble("product_price"));
			product.setStock_amount(rs.getInt("stock_amount"));
			product.setWarehouse_id(rs.getInt("warehouse_id"));
		}
		
		return product;
	}

	@Override
	public List<Product> getAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from products");
		ResultSet rs = statement.executeQuery();
		List<Product> products = new ArrayList<>();
		while(rs.next()) {
			Product product = new Product();
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_description(rs.getString("product_description"));
			product.setProduct_price(rs.getDouble("product_price"));
			product.setStock_amount(rs.getInt("stock_amount"));
			product.setWarehouse_id(rs.getInt("warehouse_id"));
			products.add(product);
		}
		return products;
	}

	@Override
	public int update(Product product) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("update products"
				+ " set product_name = ?,"
				+ " set product_description = ?,"
				+ " set product_price = ?,"
				+ " set stock_amount = ?,"
				+ " set warehouse_id = ?"
				+ " where product_id = ?");
		statement.setString(1, product.getProduct_name());
		statement.setString(2, product.getProduct_description());
		statement.setDouble(3, product.getProduct_price());
		statement.setInt(4, product.getStock_amount());
		statement.setInt(5, product.getWarehouse_id());
		statement.setInt(6, product.getProduct_id());
		return statement.executeUpdate();
		
		
	}

	@Override
	public int delete(Product product) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from products where product_id = ?");
		statement.setInt(1, product.getProduct_id());
		return statement.executeUpdate();
		
	}

}
