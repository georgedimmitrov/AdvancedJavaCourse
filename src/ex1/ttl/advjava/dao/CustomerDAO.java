package ex1.ttl.advjava.dao;

import java.util.ArrayList;
import java.util.List;

import ex1.ttl.advjava.domain.Customer;
import ex1.ttl.advjava.domain.Customer.CustomerBuilder;

public class CustomerDAO {

	private static List<Customer> customers = new ArrayList<>();
	
	private static int nextId = 0;
	
	static {
		customers.add(new CustomerBuilder().id(nextId++).name("Joe")
				.status(Customer.Status.NORMAL).build());
		
		customers.add(new CustomerBuilder().id(nextId++).name("JSammy")
				.status(Customer.Status.RESTRICTED).build());
		
		customers.add(new CustomerBuilder().id(nextId++).name("Ana")
				.status(Customer.Status.PRIVILEGED).build());
	}
	
	public List<Customer> selectAll() {
		return customers;
	}
	
	public Customer selectOne(int id) {
		for (Customer c : customers) {
			if (c.getId() == id) {
				return c;
			}
		}
		
		return null;
	}
	
	public Customer insert(Customer c) {
		c = new CustomerBuilder()
				.id(++nextId)
				.name(c.getName())
				.status(c.getStatus())
				.build();
		
		customers.add(c);
		
		return c;
	}
	
}
