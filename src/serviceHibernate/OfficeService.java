package serviceHibernate;

import java.sql.SQLException;
import java.util.List;

import model.Office;
import persistenceHibernate.OfficeDAO;

public class OfficeService {
	private OfficeDAO officeDao = new OfficeDAO();
	
	public void createOffice(Office office) {
		try {
			officeDao.create(office);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public Office getOffice(int id) {
		Office office = null;
		try {
			office = officeDao.get(id);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		
		return office;
	}
	
	public List<Office> getAllOffices(){
		List<Office> offices = null;
		try {
			offices = officeDao.getAll();
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
		
		return offices;
	}
	
	public void updateOffice(Office office) {
		try {
			officeDao.update(office);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
	
	public void deleteOffice(Office office) {
		try {
			officeDao.delete(office);
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}
	}
}
