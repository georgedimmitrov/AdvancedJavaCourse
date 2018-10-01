package ex1.ttl.advjava.app;

import java.util.List;

import ex1.ttl.advjava.domain.Customer;
import ex1.ttl.advjava.service.CustomerService;

public class MainApp {

	public static void main(String[] args) {
		
		request1("Belinda", 333);
		request2();
		
		getStatusValues();
		
	}
	
	public static void request1(String name, int code) {
		CustomerService cs = new CustomerService();
		
		Customer c = new Customer(name, Customer.Status.fromCode(code));
		
		c = cs.addCustomer(c);
	}
	
	public static void request2() {
		CustomerService cs = new CustomerService();
		
		List<Customer> customers = cs.getAllCustomers();
		
		for (Customer customer : customers) {
			System.out.println(customer);
		}	
	}
	
	public static String[] getStatusValues() {
		
		Customer.Status[] statuses = Customer.Status.values();
		String arr[] = new String[statuses.length];
		for (int i = 0; i < statuses.length; i++) {
			arr[i] = statuses[i].toString();
			
			System.out.println("Code is" + statuses[i].getCode());
		}
		
		for (String s : arr) {
			System.out.println(s);
		}
		
		return arr;
	}
}
