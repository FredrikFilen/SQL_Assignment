package model;

public class Customer {
	private int customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private String address;
	private String customer_comment;
	private int organisation_id;
	private int discount_group;
	
	public Customer(int customer_id, String first_name, String last_name, String email, String address, String customer_comment, int organisation_id, int discount_group) {
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address = address;
		this.customer_comment = customer_comment;
		this.organisation_id = organisation_id;
		this.discount_group = discount_group;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_Id() {
		return customer_id;
	}

	public void setCustomer_Id(int id) {
		this.customer_id = id;
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

	public String getCustomer_comment() {
		return customer_comment;
	}

	public void setCustomer_comment(String customer_comment) {
		this.customer_comment = customer_comment;
	}

	public int getOrganisation_id() {
		return organisation_id;
	}

	public void setOrganisation_id(int organisation_id) {
		this.organisation_id = organisation_id;
	}

	public int getDiscount_group() {
		return discount_group;
	}

	public void setDiscount_group(int discount_group) {
		this.discount_group = discount_group;
	}
	
	
	
	
}
