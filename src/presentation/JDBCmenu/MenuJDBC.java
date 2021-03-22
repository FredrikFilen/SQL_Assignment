package presentation.JDBCmenu;

import java.util.Scanner;

import model.Customer;
import serviceJDBC.CustomerService;

public class MenuJDBC {
	public void run() {
		boolean menuRunning = true;
		Scanner s = new Scanner(System.in);
		
		while(menuRunning) {
			System.out.println("1. create"
				+ "\n2. get by id"
				+ "\n3. get all"
				+ "\n4. update"
				+ "\n5. delete"
				+ "\n0. exit");
		
			int choice = Integer.parseInt(s.nextLine());
		
			switch (choice) {
			case 1: {
				//creation menu
				CreateMenu createMenu = new CreateMenu();
				createMenu.run();
				break;
				
			}
			case 2:{
				//get by id
				GetByIdMenu getByIdMenu = new GetByIdMenu();
				getByIdMenu.run();
				break;
		}
		case 3:{
			// get all
			GetAllMenu getAllMenu = new GetAllMenu();
			getAllMenu.run();
			break;
		}
		case 4:{
			//update
			UpdateMenu updateMenu = new UpdateMenu();
			updateMenu.run();
			break;
		}
		case 5:{
			//delete
			System.out.println("delete : "
					+ "\n1. Customer"
					+ "\n2. Employee"
					+ "\n3. Office"
					+ "\n4. Order"
					+ "\n5. Product"
					+ "\n6. Reclaim"
					+ "\n7. Warehouse");
		}
		case 0:{
			menuRunning = false;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		}
		
	}
	
	
}
