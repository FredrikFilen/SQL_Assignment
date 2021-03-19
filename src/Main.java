import java.sql.SQLException;

import model.Customer;
import persistenceHibernate.ConnectionFactoryHibernate;
import serviceHibernate.CustomerService;


public class Main {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactoryHibernate.getInstance().setup();
		
		CustomerService customerService = new CustomerService();
		
		Customer customer = customerService.getCustomer(1);
		System.out.println(customer.toString());
		
		
		
		
		
		
		
	

	}

}
