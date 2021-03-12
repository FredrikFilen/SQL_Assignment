package service;

import java.sql.SQLException;
import java.util.List;

import model.Reclaim;
import persistence_JDBC.DAO.ReclaimDAO;

public class ReclaimService {
	
	private ReclaimDAO reclaimDAO = new ReclaimDAO();
	
	public boolean createReclaim(Reclaim reclaim) {
		int result = 0;
		try {
			result = reclaimDAO.create(reclaim);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public Reclaim getReclaim(int id) {
		Reclaim reclaim = null;
		try {
			reclaim = reclaimDAO.get(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reclaim;
	}
	
	public List<Reclaim> getAllReclaims(){
		List<Reclaim> reclaims = null;
		try {
			reclaims = reclaimDAO.getAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reclaims;
	}
	
	public boolean updateReclaim(Reclaim reclaim) {
		int result = 0;
		try {
			result = reclaimDAO.update(reclaim);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public boolean deleteReclaim(Reclaim reclaim) {
		int result = 0;
		try {
			result = reclaimDAO.delete(reclaim);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
}
