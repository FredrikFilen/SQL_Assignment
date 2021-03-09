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
	
	public Warehouse() {
		
	}


	public int getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public String getWarehouse_name() {
		return warehouse_name;
	}

	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
	
}
