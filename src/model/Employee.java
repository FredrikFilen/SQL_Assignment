package model;

public class Employee {
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String address;
	private String employee_comment;
	private int office_id;
	
	public Employee(int employee_id, String first_name, String last_name, String email, String address, String employee_comment, int office_id) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address = address;
		this.employee_comment = employee_comment;
		this.office_id = office_id;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmployee_comment() {
		return employee_comment;
	}

	public void setEmployee_comment(String employee_comment) {
		this.employee_comment = employee_comment;
	}

	public int getOffice_id() {
		return office_id;
	}

	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", address=" + address + ", employee_comment=" + employee_comment
				+ ", office_id=" + office_id + "]";
	}
	
	
	
	
}
