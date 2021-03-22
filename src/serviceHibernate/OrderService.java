package serviceHibernate;

import java.sql.SQLException;
import java.util.List;

import model.Order;
import persistenceHibernate.OrderDAO;

public class OrderService {
	private OrderDAO orderDao = new OrderDAO();
	
	public void createOrder(Order order) {
		try {
			orderDao.create(order);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}	
	}
	
	public Order getOrder(int id) {
		Order order = null;
		try {
			order = orderDao.get(id);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		return order;
	}
	
	public List<Order> getAllOrders(){
		List<Order> orders = null; 
		try {
			orders = orderDao.getAll();
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		return orders;
	}
	
	public void updateOrder(Order order) {
		try {
		orderDao.update(order);	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public void deleteOrder(Order order) {
		try {
		orderDao.delete(order);	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
}
