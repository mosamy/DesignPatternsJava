package framework.model;

public class Address implements IAddress {

	private String street;
	private String city;
	private String state;
	private String zip;
	
    public Address(String street, String city, String state, String zip) {
    	this.street = street;
    	this.city = city;
    	this.state = state;
    	this.zip = zip;
    }

 	@Override
	public String getStreet() {
		// TODO Auto-generated method stub
		return this.street;
	}

	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return this.state;
	}

	@Override
	public String getZip() {
		// TODO Auto-generated method stub
		return this.zip;
	}

	@Override
	public String getAddressDetails() {
		// TODO Auto-generated method stub
		return "[" + this.street + " " + this.city + " " + this.state + " " + this.zip + "]";
	}


}