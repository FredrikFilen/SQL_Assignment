package serviceHibernate;

import java.sql.SQLException;
import java.util.List;

import model.Warehouse;
import persistenceHibernate.WarehouseDAO;

public class WarehouseService {
	private WarehouseDAO warehouseDao = new WarehouseDAO();
	
	public void createWarehouse(Warehouse warehouse) {
		try {
		warehouseDao.create(warehouse);	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public Warehouse getWarehouse(int id) {
		Warehouse warehouse = null;
		try {
		warehouse = warehouseDao.get(id);	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		return warehouse;
	}
	
	public List<Warehouse> getAllWarehouses(){
		List<Warehouse> warehouses = null;
		try {
		warehouses = warehouseDao.getAll();	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		return warehouses;
	}
	
	public void updateWarehouse(Warehouse warehouse) {
		try {
		warehouseDao.update(warehouse);	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public void deleteWarehouse(Warehouse warehouse) {
		try {
		warehouseDao.delete(warehouse);	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
}
