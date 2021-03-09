package model;

public class Reclaim {
	private int reclaim_id;
	private int product_id;
	private int assigned_employee_id;
	private String reclaim_date;
	private String reclaim_reason;
	
	public Reclaim(int reclaim_id, int product_id, int assigned_employee_id, String reclaim_date,
			String reclaim_reason) {
		this.reclaim_id = reclaim_id;
		this.product_id = product_id;
		this.assigned_employee_id = assigned_employee_id;
		this.reclaim_date = reclaim_date;
		this.reclaim_reason = reclaim_reason;
	}

	public Reclaim() {
		// TODO Auto-generated constructor stub
	}

	

	public int getReclaim_id() {
		return reclaim_id;
	}

	public void setReclaim_id(int reclaim_id) {
		this.reclaim_id = reclaim_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getAssigned_employee_id() {
		return assigned_employee_id;
	}

	public void setAssigned_employee_id(int assigned_employee_id) {
		this.assigned_employee_id = assigned_employee_id;
	}

	public String getReclaim_date() {
		return reclaim_date;
	}

	public void setReclaim_date(String reclaim_date) {
		this.reclaim_date = reclaim_date;
	}

	public String getReclaim_reason() {
		return reclaim_reason;
	}

	public void setReclaim_reason(String reclaim_reason) {
		this.reclaim_reason = reclaim_reason;
	}
	
	
	
	
}
