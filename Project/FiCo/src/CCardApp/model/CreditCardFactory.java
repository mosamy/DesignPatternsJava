package CCardApp.model;

import framework.model.*;


public class CreditCardFactory extends AccountFactory {

	public IAccount createAccount(ICustomer cust, String acctNo,
			AcctType acctType, String expDate) {
		// TODO Auto-generated method stub

//		if (acctType.equals("Gold")) {
//			return new Gold(cust, acctNo, expDate);
//
//		}
//		if (acctType.equals("Silver")) {
//			return new Silver(cust, acctNo, expDate);
//
//		}
//
//		return new Bronze(cust, acctNo, expDate);
		
		return null;
	}

	public ICustomer createCustomer(String name, CustomerType customerType,
			IAddress add, String email, String anyVal) {
		// TODO Auto-generated method stub
		return super.createCustomer(name, customerType, add, email, anyVal);
	}

	@Override
	public IAccount createAccount(ICustomer customer, String acctNo,
			AcctType acctType) {
		// TODO Auto-generated method stub
		return null;
	}

}
