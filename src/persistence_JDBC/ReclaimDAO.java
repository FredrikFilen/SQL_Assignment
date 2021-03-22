package persistence_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reclaim;

public class ReclaimDAO implements DaoJDBC<Reclaim> {

	@Override
	public int create(Reclaim reclaim) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into reclaims(product_id, assigned_employee_id, reclaim_date, reclaim_reason)values(?,?,?,?)");
		statement.setInt(1, reclaim.getProduct_id());
		statement.setInt(2, reclaim.getAssigned_employee_id());
		statement.setString(3, reclaim.getReclaim_date());
		statement.setString(4, reclaim.getReclaim_reason());
		return statement.executeUpdate();
		
	}

	@Override
	public Reclaim get(Object id) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from reclaims where reclaim_id = ?");
		statement.setInt(1, (int)id);
		ResultSet rs = statement.executeQuery();
		Reclaim reclaim = null;
		if(rs.next()) {
			reclaim = new Reclaim();
			reclaim.setReclaim_id(rs.getInt("reclaim_id"));
			reclaim.setProduct_id(rs.getInt("product_id"));
			reclaim.setAssigned_employee_id(rs.getInt("assigned_employee_id"));
			reclaim.setReclaim_date(rs.getString("reclaim_date"));
			reclaim.setReclaim_reason(rs.getString("reclaim_reason"));
		}
		return reclaim;
	}

	@Override
	public List<Reclaim> getAll() throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from reclaims");
		ResultSet rs = statement.executeQuery();
		List<Reclaim> reclaims = new ArrayList<>();
		while(rs.next()) {
			Reclaim reclaim = new Reclaim();
			reclaim.setReclaim_id(rs.getInt("reclaim_id"));
			reclaim.setProduct_id(rs.getInt("product_id"));
			reclaim.setAssigned_employee_id(rs.getInt("assigned_employee_id"));
			reclaim.setReclaim_date(rs.getString("reclaim_date"));
			reclaim.setReclaim_reason(rs.getString("reclaim_reason"));
			reclaims.add(reclaim);
		}
		return reclaims;
	}

	@Override
	public int update(Reclaim reclaim) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("update reclaims"
				+ " set product_id = ?,"
				+ " assigned_employee_id = ?,"
				+ " reclaim_date = ?,"
				+ " reclaim_reason = ?"
				+ " where reclaim_id = ?");
		statement.setInt(1, reclaim.getProduct_id());
		statement.setInt(2, reclaim.getAssigned_employee_id());
		statement.setString(3, reclaim.getReclaim_date());
		statement.setString(4, reclaim.getReclaim_reason());
		statement.setInt(5, reclaim.getReclaim_id());
		return statement.executeUpdate();
		
	}

	@Override
	public int delete(Reclaim reclaim) throws SQLException {
		Connection connection = ConnectionFactoryJDBC.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from reclaims where reclaim_id = ?");
		statement.setInt(1, reclaim.getReclaim_id());
		return statement.executeUpdate();
		
	}

}
