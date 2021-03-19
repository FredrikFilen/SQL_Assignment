package serviceHibernate;

import java.sql.SQLException;
import java.util.List;

import model.Reclaim;
import persistenceHibernate.ReclaimDAO;

public class ReclaimService {
	private ReclaimDAO reclaimDao = new ReclaimDAO();
	
	public void createReclaim(Reclaim reclaim) {
		try {
			reclaimDao.create(reclaim);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public Reclaim getReclaim(int id) {
		Reclaim reclaim = null;
		try {
			reclaim = reclaimDao.get(id);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		return reclaim;
	}
	
	public List<Reclaim> getAllReclaims(){
		List<Reclaim> reclaims = null;
		try {
			reclaims = reclaimDao.getAll();
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		return reclaims;
	}
	
	public void updateReclaim(Reclaim reclaim) {
		try {
		reclaimDao.update(reclaim);	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public void deleteReclaim(Reclaim reclaim) {
		try {
		reclaimDao.delete(reclaim);	
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
}
