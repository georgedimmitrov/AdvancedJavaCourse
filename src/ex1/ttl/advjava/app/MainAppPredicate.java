package ex1.ttl.advjava.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import ex1.ttl.advjava.domain.Customer;
import ex1.ttl.advjava.service.CustomerService;

public class MainAppPredicate {
	public static void main(String[] args) {
		
		MainAppPredicate map = new MainAppPredicate();
		map.go();
		
	}
		
	public void go() {
		CustomerService cs = new CustomerService();
		
		List<Customer> customers = cs.getAllCustomers();
		
		// 1st way
//		Checker jNameChecker = new StartsWithChecker("J");
		
		// 2nd way
//		Checker jNameChecker = new Checker<Customer>() {
//			public boolean check(Customer c) {
//				return c.getName().startsWith("J");
//			}
//		};
		
		// 3rd way - java 8 - lambdas
//		Checker<Customer> jNameChecker = (Customer c) -> { return c.getName().startsWith("J"); };
		
		// 3.5th way - java 8 - lambdas - assumption and implicit return
//		Checker<Customer> jNameChecker = (c) -> c.getName().startsWith("J");
		
		List<Customer> result = getCustomersBasedOn(customers, 
				(c) -> c.getName().startsWith("J"));
		
		for (Customer c : result) {
			System.out.println(c);
		}
	}
	
	public <T> List<T> getCustomersBasedOn(List<T> input, Predicate<T> checker) {
		List<T> result = new ArrayList<>();
		for (T c : input) {
			if (checker.test(c)) {
				result.add(c);
			}
		}
		
		return result;
	}
	
	public interface Checker<T> {
		public boolean check(T c);
	}
	
	class StartsWithChecker implements Checker<Customer> {
		private String prefix;
		
		public StartsWithChecker(String prefix) {
			this.prefix = prefix;
		}

		@Override
		public boolean check(Customer c) {
			return c.getName().startsWith(prefix);
		}
		
	}
}
