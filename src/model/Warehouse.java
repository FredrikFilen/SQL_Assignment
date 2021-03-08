package model;

public class Warehouse {
	private int warehouse_id;
	private String warehouse_name;
	private String address;
	
	public Warehouse(int storage_id, String storage_name, String address, int storage_positions) {
		this.warehouse_id = storage_id;
		this.warehouse_name = storage_name;
		this.address = address;
	}

	public int getStorage_id() {
		return warehouse_id;
	}

	public void setStorage_id(int storage_id) {
		this.warehouse_id = storage_id;
	}

	public String getStorage_name() {
		return warehouse_name;
	}

	public void setStorage_name(String storage_name) {
		this.warehouse_name = storage_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	
	
	
	
}
