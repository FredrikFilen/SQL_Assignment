package serviceJDBC;

import java.sql.SQLException;
import java.util.List;

import model.Warehouse;
import persistence_JDBC.WarehouseDAO;

public class WarehouseService {

	private WarehouseDAO warehouseDAO = new WarehouseDAO();
	
	public boolean createWarehouse(Warehouse warehouse) {
		int result = 0;
		try {
			result = warehouseDAO.create(warehouse);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public Warehouse getWarehouse(int id) {
		Warehouse warehouse = null;
		try {
			warehouse = warehouseDAO.get(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return warehouse;
	}
	
	public List<Warehouse> getAllWarehouses(){
		List<Warehouse> warehouses = null;
		try {
			warehouses = warehouseDAO.getAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return warehouses;
	}
	
	public boolean updateWarehouse(Warehouse warehouse) {
		int result = 0;
		try {
			result = warehouseDAO.update(warehouse);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public boolean deleteWarehouse(Warehouse warehouse) {
		int result = 0;
		try {
			result = warehouseDAO.delete(warehouse);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
}
