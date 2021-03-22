package presentation.HibernateMenu;

import java.util.Scanner;



public class MenuHibernate {
	public void run() {
		boolean menuRunning = true;
		Scanner s = new Scanner(System.in);
		
		while(menuRunning) {
			System.out.println(
					"\n1. Create"
				+ "\n2. Get by id"
				+ "\n3. Get all"
				+ "\n4. Update"
				+ "\n5. Delete"
				+ "\n0. Exit");
		
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
				DeleteMenu deleteMenu = new DeleteMenu();
				deleteMenu.run();
				break;
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
