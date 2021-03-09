package model;

public class Office {
	private int office_id;
	private String office_name;
	private String address;
	
	public Office(int office_id, String office_name, String address) {
		this.office_id = office_id;
		this.office_name = office_name;
		this.address = address;
	}

	public Office() {
		// TODO Auto-generated constructor stub
	}

	public int getOffice_id() {
		return office_id;
	}

	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}

	public String getOffice_name() {
		return office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Office [office_id=" + office_id + ", office_name=" + office_name + ", address=" + address + "]";
	}
	
	
}
