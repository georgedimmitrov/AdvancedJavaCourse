package ex1.ttl.advjava.domain;

public class Customer {
	private int id;
	private String name;
	private Status status;

	public enum Status {
		PRIVILEGED(25),
		NORMAL(3),
		RESTRICTED(333);
		
		private int code;
	
		Status(int code) {
			this.code = code;
		}
		
		public static Status toVal(String s) {
			s = s.toUpperCase();
			
			return valueOf(s);
		}
		
		public static Status fromCode(int code) {
			Status[] all = values();
			
			for (Status a : all) {
				if (a.getCode() == code) {
					return a;
				}
			}
			
			return NORMAL;
		}
		
		public int getCode() {
			return code;
		}
		
		public String toString() {
			return name().substring(0, 1) + name().substring(1).toLowerCase();
		}
	}

	public Customer() {}
	
	public Customer(String customerName, Status customerStatus) {
		super();
		this.name = customerName;
		this.status = customerStatus;
	}

	public Customer(int customerId, String customerName, Status customerStatus) {
		super();
		this.id = customerId;
		this.name = customerName;
		this.status = customerStatus;
	}

	public int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customer id=" + id + ", name=" + name + ", status="
				+ status + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	
	public static class CustomerBuilder {
		private int id;
		private String name;
		private Status status;
		
		public CustomerBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public CustomerBuilder status(Status status) {
			this.status = status;
			return this;
		}
		
		public CustomerBuilder id(int id) {
			this.id = id;
			return this;
		}
		
		public Customer build() {
			return new Customer(id, name, status);
		}
	}
}
