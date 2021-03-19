package model;
import javax.persistence.*;


@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "product_description")
	private String product_description;
	
	@Column(name = "product_price")
	private double product_price;
	
	@Column(name = "stock_amount")
	private int stock_amount;
	
	@Column(name = "warehouse_id")
	private int warehouse_id;
	
	
	public Product(int product_id, String product_name, String product_description, double product_price,
			int stock_amount, int storage_id) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_price = product_price;
		this.stock_amount = stock_amount;
		this.warehouse_id = storage_id;
	}
	
	public Product() {
		
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getStock_amount() {
		return stock_amount;
	}

	public void setStock_amount(int stock_amount) {
		this.stock_amount = stock_amount;
	}

	public int getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
				+ product_description + ", product_price=" + product_price + ", stock_amount=" + stock_amount
				+ ", warehouse_id=" + warehouse_id + "]";
	}
	
	
	
	
	
}
