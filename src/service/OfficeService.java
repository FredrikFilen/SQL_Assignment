package service;

import java.sql.SQLException;
import java.util.List;

import model.Office;
import persistence_JDBC.DAO.OfficeDAO;

public class OfficeService {
	
	private OfficeDAO officeDAO = new OfficeDAO();
	
	public boolean createOffice(Office office) {
		int result = 0;
		try {
			result = officeDAO.create(office);
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public Office getOffice(int id) {
		Office office = null;
		try {
			office = officeDAO.get(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return office;
	}
	
	public List<Office> getAllOffices(){
		List<Office> offices = null;
		try {
			offices = officeDAO.getAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return offices;
	}
	
	public boolean updateOffice(Office office) {
		int result = 0;
		try {
			result = officeDAO.update(office);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
	
	public boolean deleteOffice(Office office) {
		int result = 0;
		try {
			result = officeDAO.delete(office);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result == 1 ? true : false;
	}
}
