package service;

import java.sql.SQLException;
import java.util.List;

import model.Customer;
import persistence_JDBC.DAO.CustomerDAO;

public class CustomerService {
	
	private CustomerDAO customerDAO = new CustomerDAO();
	
	public boolean createCustomer(Customer customer) {
		int result = 0;
		try {
			result = customerDAO.create(customer);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public Customer getCustomer(int id) {
		Customer customer = null;
        try {
            customer = customerDAO.get(id);
            // Validate
            // Logging
            // Specific business processing
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = null;
		try {
			customers = customerDAO.getAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}
	
	public boolean updateCustomer(Customer customer) {
		int result = 0;
		try {
			result = customerDAO.update(customer);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public boolean deleteCustomer(Customer customer) {
		int result = 0;
		try {
			result = customerDAO.delete(customer);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	
	
	
	
	
}
