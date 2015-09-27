package framework.model;

public class Transaction implements ITransaction {

	private String date;
	private double amount;
	 public Transaction(String newdate, Double newamount) {
		setDate(newdate);
		amount = newamount;
	}
	
	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	@Override
	public Double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
