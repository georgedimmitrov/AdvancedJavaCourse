package ex1.ttl.advjava.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import ex1.ttl.advjava.app.MainAppPredicate.Checker;
import ex1.ttl.advjava.domain.Customer;
import ex1.ttl.advjava.service.CustomerService;

public class MainAppFunction {
	public static void main(String[] args) {
		
		MainAppFunction map = new MainAppFunction();
		map.go();
		
	}
		
	public void go() {
		CustomerService cs = new CustomerService();

		List<Customer> customers = cs.getAllCustomers();

		List<String> l2 = getCustomerNames(customers);

		List<String> l3 = getCustomerInfo(customers, s -> s.getName());
		
		List<Integer> ids = getCustomerInfo(customers, s -> s.getId());

		// for (Integer it : ids) { System.out.println(it); }
		
		ids.forEach((it) -> System.out.println(it));

		// ids.forEach(System.out::println);
		ids.forEach(this::processIds);
	}
	
	public void processIds(Integer it) {
		//process it
		System.out.println("_" + it + "_");
	}

	public <T, R> List<R> getCustomerInfo(List<T> input, Function<T, R> ne) {
		List<R> result = new ArrayList<>();
		for (T s : input) {
			result.add(ne.apply(s));
		}
		return result;

	}

	public interface NameExtractor<T, R> {
		public R extract(T s);
	}

	public List<String> getCustomerNames(List<Customer> input) {
		List<String> result = new ArrayList<>();
		for (Customer s : input) {
			result.add(s.getName());
		}
		return result;

	}
	

	public interface Checker<T> {
		public boolean check(T s);
	}

	public <T> List<T> getCustomersBasedOnPred(List<T> input, Predicate<T> checker) {
		List<T> result = new ArrayList<>();
		for (T s : input) {
			if (checker.test(s)) {
				result.add(s);
			}
		}
		return result;
	}
	
}
