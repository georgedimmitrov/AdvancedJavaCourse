package ex1.ttl.advjava.service;

import java.util.List;

import ex1.ttl.advjava.dao.CustomerDAO;
import ex1.ttl.advjava.domain.Customer;

public class CustomerService {

	private CustomerDAO dao = new CustomerDAO();
	
	public List<Customer> getAllCustomers() {
		return dao.selectAll();
	}
	
	public Customer getCustomer(int id) {
		return dao.selectOne(id);
	}
	
	public Customer addCustomer(Customer c) {
		return dao.insert(c);
	}
	
}
