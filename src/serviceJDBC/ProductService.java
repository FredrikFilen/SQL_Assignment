package serviceJDBC;

import java.sql.SQLException;
import java.util.List;

import model.Product;
import persistence_JDBC.ProductDAO;

public class ProductService {
	
	private ProductDAO productDAO = new ProductDAO();
	
	public boolean createProduct(Product product) {
		int result = 0;
		try {
			result = productDAO.create(product);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true: false;
	}
	
	public Product getProduct(int id) {
		Product product = null;
		try {
			product = productDAO.get(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = null;
		try {
			products = productDAO.getAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public boolean updateProduct(Product product) {
		int result = 0;
		try {
			result = productDAO.update(product);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
		
	}
	
	public boolean deleteProduct(Product product) {
		int result = 0;
		try {
			result = productDAO.delete(product);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
		
	}
	
	public List<Product> getLowStock(){
		List<Product> products = null;
		try {
			products = productDAO.getLowStock();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
