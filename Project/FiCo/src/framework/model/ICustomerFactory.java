package framework.model;

public interface ICustomerFactory {

	public ICustomer createCustomer(String name, CustomerType customerType,
			IAddress add, String email, String anyVal);

}