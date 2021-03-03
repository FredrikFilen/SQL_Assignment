package model;

public class Customer {
	private int customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private String adress;
	private String customer_comment;
	private int organisation_id;
	private int discount_group;
	
	public Customer() {
		
	}

	public int getId() {
		return customer_id;
	}

	public void setId(int id) {
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
