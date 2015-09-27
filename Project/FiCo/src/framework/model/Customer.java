package framework.model;

import java.util.*;

public class Customer implements ICustomer {

	private String name;
	private String email;
	private IAddress address;
	private List<IAccount> accountList;
	private List<String> emailList;
	private CustomerType customerType;
	public Customer(String name, String email, IAddress address, CustomerType customerType) {
		
		this.name = name;
		this.email = email;
		this.address = address;
		this.accountList = new ArrayList<IAccount>();
		this.emailList = new ArrayList<String>();
		
		this.customerType = customerType;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public void AddAccount(IAccount acct) {
		this.accountList.add(acct);

	}

	@Override
	public void removeAccount(IAccount acct) {
		this.accountList.remove(acct);
	}

	@Override
	public List<IAccount> getAccountList() {
		// TODO Auto-generated method stub
		return this.accountList;
	}

	@Override
	public CustomerType getCustomerType() {
		// TODO Auto-generated method stub
		return this.customerType;
	}

	@Override
	public void update(String emailMessage) {
		// TODO Auto-generated method stub
		this.emailList.add(emailMessage);
	}


	@Override
	public String getCustomerDetails() {

		return "[" + this.name + "]";// maybe add plus address later

	}

}