package framework.model;

public interface IAccountFactory {

	public IAccount createAccount(ICustomer customer, String acctNo, AcctType acctType);

	public ICustomer createCustomer(String name, CustomerType customerType,
			IAddress add, String email, String anyVal);

}
