package model;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "customer_id")
	private int customer_id;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "order_date")
	private String order_date;
	
	@Column(name = "requested_shipping_date")
	private String requested_shipping_date;
	
	@Column(name = "shipping_date")
	private String shipping_date;
	
	public Order(int order_id, int product_id, int customer_id, int amount, String order_date, String requested_shipping_date, String shipping_date) {
		this.order_id = order_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.amount = amount;
		this.order_date = order_date;
		this.requested_shipping_date = requested_shipping_date;
		this.shipping_date = shipping_date;
	}

	public Order() {

	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getRequested_shipping_date() {
		return requested_shipping_date;
	}

	public void setRequested_shipping_date(String requested_shipping_date) {
		this.requested_shipping_date = requested_shipping_date;
	}

	public String getShipping_date() {
		return shipping_date;
	}

	public void setShipping_date(String shipping_date) {
		this.shipping_date = shipping_date;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", product_id=" + product_id + ", customer_id=" + customer_id
				+ ", amount=" + amount + ", order_date=" + order_date + ", requested_shipping_date="
				+ requested_shipping_date + ", shipping_date=" + shipping_date + "]";
	}
	
	
	
	
}
