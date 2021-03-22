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
		int choice = Integer.parseInt(scanner.nextLine());
		
		switch (choice) {
			case 1: {
			//init jdbc
				System.out.println("Starting in JDBC mode");
				
				MenuJDBC menu = new MenuJDBC();
				menu.run();
				
				break;
			}
			
			case 2:{
			//init hibernate
				System.out.println("Starting in Hibernate mode");
				
				ConnectionFactoryHibernate.getInstance().setup();
				MenuHibernate menu = new MenuHibernate();
				menu.run();
				
			}
		}
		scanner.close();
		
	}

}
