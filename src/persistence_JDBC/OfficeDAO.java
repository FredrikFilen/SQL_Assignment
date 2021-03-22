package persistence_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Office;

public class OfficeDAO implements DaoJDBC<Office> {

	@Override
	public int create(Office office) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into offices(office_name, address) values(?,?)");
		statement.setString(1, office.getOffice_name());
		statement.setString(2, office.getAddress());
		return statement.executeUpdate();
	}

	@Override
	public Office get(Object id) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from offices where office_id = ?");
		statement.setInt(1, (int)id);
		ResultSet rs = statement.executeQuery();
		Office office = null;
		if(rs.next()) {
			office = new Office();
			office.setOffice_id(rs.getInt("office_id"));
			office.setOffice_name(rs.getString("office_name"));
			office.setAdress(rs.getString("address"));
		}
		return office;
	}

	@Override
	public List<Office> getAll() throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from offices");
		ResultSet rs = statement.executeQuery();
		List<Office> offices = new ArrayList<>();
		while(rs.next()) {
			Office office = new Office();
			office.setOffice_id(rs.getInt("office_id"));
			office.setOffice_name(rs.getString("office_name"));
			office.setAdress(rs.getString("address"));
			offices.add(office);
		}
		return offices;
	}

	@Override
	public int update(Office office) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("update offices "
				+ "set office_name = ?,"
				+ "address = ?"
				+ "where office_id = ?");
		statement.setString(1, office.getOffice_name());
		statement.setString(2, office.getAddress());
		statement.setInt(3, office.getOffice_id());
		return statement.executeUpdate();
		
	}

	@Override
	public int delete(Office office) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from offices where office_id = ?");
		statement.setInt(1, office.getOffice_id());
		return statement.executeUpdate();
		
		
	}

}
