package service;

import java.sql.SQLException;
import java.util.List;

import model.Order;
import persistence_JDBC.DAO.OrderDAO;

public class OrderService {
	
	private OrderDAO orderDAO = new OrderDAO();
	
	public boolean createOrder(Order order) {
		int result = 0;
		try {
			result = orderDAO.create(order);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public Order getOrder(int id) {
		Order order = null;
		try {
			order = orderDAO.get(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public List<Order> getAllOrders(){
		List<Order> orders = null;
		try {
			orders = orderDAO.getAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public boolean updateOrder(Order order) {
		int result = 0;
		try {
			result = orderDAO.update(order);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public boolean deleteOrder(Order order) {
		int result = 0;
		try {
			result = orderDAO.delete(order);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
}
