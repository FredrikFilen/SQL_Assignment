import java.sql.SQLException;
import java.util.Scanner;

import model.Customer;
import persistenceHibernate.ConnectionFactoryHibernate;
import presentation.HibernateMenu.MenuHibernate;
import presentation.JDBCmenu.MenuJDBC;
import serviceHibernate.CustomerService;


public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose architecture: \n1. JDBC \n2. Hibernate");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) {
			case 1: {
			//init jdbc
				MenuJDBC menu = new MenuJDBC();
				menu.run();
				break;
			}
			
			
		
		
			case 2:{
			//init hibernate
				ConnectionFactoryHibernate.getInstance().setup();
				MenuHibernate menu = new MenuHibernate();
				
			}
		}
		
		
		
		
		
		
		
		
	

	}

}
