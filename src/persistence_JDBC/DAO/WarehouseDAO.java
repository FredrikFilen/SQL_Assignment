package persistence_JDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Warehouse;
import persistence_JDBC.ConnectionFactory;

public class WarehouseDAO implements DAO<Warehouse> {

	@Override
	public int create(Warehouse warehouse) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into warehouse(warehouse_name, address)values(?,?)");
		statement.setString(1, warehouse.getWarehouse_name());
		statement.setString(2, warehouse.getAddress());
		return statement.executeUpdate();
		
	}

	@Override
	public Warehouse get(Object id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from warehouse where warehouse_id = ?");
		statement.setInt(1, (int)id);
		ResultSet rs = statement.executeQuery();
		Warehouse warehouse = null;
		if(rs.next()) {
			warehouse = new Warehouse();
			warehouse.setWarehouse_id(rs.getInt("warehouse_id"));
			warehouse.setWarehouse_name(rs.getString("warehouse_name"));
			warehouse.setAddress(rs.getString("address"));
			
		}
		return warehouse;
	}

	@Override
	public List<Warehouse> getAll() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from warehouse");
		ResultSet rs = statement.executeQuery();
		List<Warehouse> warehouses = new ArrayList<>();
		while(rs.next()) {
			Warehouse warehouse = new Warehouse();
			warehouse.setWarehouse_id(rs.getInt("warehouse_id"));
			warehouse.setWarehouse_name(rs.getString("warehouse_name"));
			warehouse.setAddress(rs.getString("address"));
			warehouses.add(warehouse);
		}
		return warehouses;
	}

	@Override
	public int update(Warehouse warehouse) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("update warehouse"
				+ " set warehouse_name = ?,"
				+ " set address = ?"
				+ " where warehouse_id = ?");
		statement.setString(1, warehouse.getWarehouse_name());
		statement.setString(2, warehouse.getAddress());
		statement.setInt(3, warehouse.getWarehouse_id());
		return statement.executeUpdate();
		
	}

	@Override
	public int delete(Warehouse warehouse) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from warehouse where warehouse_id = ?");
		statement.setInt(1, warehouse.getWarehouse_id());
		return statement.executeUpdate();
		
	}

}
