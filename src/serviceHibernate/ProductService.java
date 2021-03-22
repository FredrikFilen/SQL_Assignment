package serviceHibernate;

import java.sql.SQLException;
import java.util.List;

import model.Product;
import persistenceHibernate.ProductDAO;

public class ProductService {
	private ProductDAO productDao = new ProductDAO();
	
	public void createProduct(Product product) {
		try {
			productDao.create(product);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public Product getProduct(int id) {
		Product product = null;
		try {
			product = productDao.get(id);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		return product;
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = null;
		try {
			products = productDao.getAll();
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		return products;
	}
	
	public void updateProduct(Product product) {
		try {
			productDao.update(product);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public void deleteProduct(Product product) {
		try {
			productDao.delete(product);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public List<Product> getLowStock(){
		List<Product> products = null;
		try {
			products = productDao.getLowStock();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
