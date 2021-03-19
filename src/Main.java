import java.sql.SQLException;
import java.util.List;

import model.Customer;
import model.Office;
import model.Order;
import persistenceHibernate.ConnectionFactoryHibernate;
import persistenceHibernate.CustomerDAO;
import persistenceHibernate.OfficeDAO;
import persistenceHibernate.OrderDAO;
import persistence_JDBC.ConnectionFactoryJDBC;
import presentation.MainMenu;
import serviceJDBC.CustomerService;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactoryHibernate.getInstance().setup();
		
		OfficeDAO dao = new OfficeDAO();
		Office office = new Office();
		office.setOffice_name("blablabla");
		office.setAdress("test");
		
		dao.create(office);
		
		
		
		
		
		
		
	

	}

}
