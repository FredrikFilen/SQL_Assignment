import java.sql.SQLException;
import java.util.List;

import model.Customer;
import persistence_JDBC.ConnectionFactory;
import presentation.MainMenu;
import service.CustomerService;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		
		CustomerService customerservice = new CustomerService();
		List<Customer> customers = customerservice.getAllCustomers();
		for(Customer customer : customers) {
			System.out.println(customer);
		}
		
		Customer customer = customerservice.getCustomer(1);
		System.out.println(customer.toString());
		
		
		
		
		
	

	}

}
