package framework.model;

public class Person extends Customer implements IPerson {

	private String birthDate;
	public Person(String name, String email, IAddress address, String birthDate) {
		super(name, email, address, CustomerType.PERSONAL);
		// TODO Auto-generated constructor stub
		this.birthDate = birthDate;
	}

	@Override
	public String getBirthDate() {
		// TODO Auto-generated method stub
		return this.birthDate;
	}


}