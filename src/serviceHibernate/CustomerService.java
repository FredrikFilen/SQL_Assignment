package serviceHibernate;

import java.sql.SQLException;
import java.util.List;

import model.Customer;
import persistenceHibernate.CustomerDAO;

public class CustomerService {
	private CustomerDAO customerDao = new CustomerDAO();
	
	public void createCustomer(Customer customer) {
		try {
			customerDao.create(customer);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	public Customer getCustomer(int id) {
		Customer customer = null;
		try {
			customer = customerDao.get(id);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return customer;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = null;
		try {
			customers = customerDao.getAll();
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return customers;
	}
	
	public void updateCustomer(Customer customer) {
		try {
			customerDao.update(customer);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	public void deleteCustomer(Customer customer) {
		try {
			customerDao.delete(customer);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
