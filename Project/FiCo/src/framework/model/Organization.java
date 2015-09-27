package framework.model;

public class Organization extends Customer implements IOrganization {

	private int numOfEmployees;
	public Organization(String name, String email, IAddress address, int numOfEmployees) {
		super(name, email, address, CustomerType.ORGANIZATION);
		// TODO Auto-generated constructor stub
		this.numOfEmployees = numOfEmployees;
	}

	@Override
	public int getNumOfEmployees() {
		// TODO Auto-generated method stub
		return this.numOfEmployees;
	}
}