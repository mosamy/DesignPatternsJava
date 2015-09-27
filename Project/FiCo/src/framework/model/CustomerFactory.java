package framework.model;


public class CustomerFactory implements ICustomerFactory {

    @Override
	public ICustomer createCustomer(String name, CustomerType customerType,
			IAddress add, String email, String birtdate) {
		// TODO Auto-generated method stub
    	if (customerType == CustomerType.PERSONAL) {
    		return new Person(name, email, add, birtdate);
   		}
    	
   		//return new Organization(name, email, add, 10);
    	return new Organization(name, email, add, 10); // will fix number employee parameter later
	}
}