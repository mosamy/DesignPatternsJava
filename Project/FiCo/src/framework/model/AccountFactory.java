package framework.model;

import java.util.*;

/**
 * 
 */
public abstract  class AccountFactory implements IAccountFactory {


	

	@Override
	public ICustomer createCustomer(String name, CustomerType customerType,
			IAddress add, String email, String bdate) {
	    CustomerFactory cf = new CustomerFactory();
	    return cf.createCustomer(name, customerType, add, email, bdate);
	}

}