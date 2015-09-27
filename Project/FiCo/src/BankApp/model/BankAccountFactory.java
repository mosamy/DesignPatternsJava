package BankApp.model;

import framework.model.AccountFactory;
import framework.model.AcctType;
import framework.model.IAccount;
import framework.model.ICustomer;

public class BankAccountFactory extends AccountFactory {

	@Override
	public IAccount createAccount(ICustomer cust, String acctNo, AcctType acctType) {
		// TODO Auto-generated method stub

		if (acctType == AcctType.CHECKING) {
			return new Checking(cust, acctNo);
		}
		return new Savings(cust, acctNo);
	}

//	@Override
//	public ICustomer createCustomer(String name, String customerType,
//			IAddress add, String email, String anyVal) {
//		return super.createCustomer(name, customerType, add, email, anyVal);
//
//	}
}
