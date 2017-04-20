
public class Customer {
	private static String customerName;
	private static String customerAddress;
	private static String customerNic;
	private static int customerTel;

	public Customer() {

	}

	public String getCustomerName() {

		return customerName;

	}

	public void setCustomerName(String customerName) {

		Customer.customerName = customerName;

	}

	public String getCustomerAddress() {

		return customerAddress;

	}

	public void setCustomerAddress(String customerAddress) {

		Customer.customerAddress = customerAddress;

	}

	public String getCustomerNic() {

		return customerNic;

	}

	public void setCustomerNic(String customerNic) {

		Customer.customerNic = customerNic;

	}

	public int getCustomerTel() {

		return customerTel;

	}

	public void setCustomerTel(int customerTel) {

		Customer.customerTel = customerTel;

	}
}
