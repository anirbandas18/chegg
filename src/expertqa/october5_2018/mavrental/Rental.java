package expertqa.october5_2018.mavrental;

public class Rental {
	
	private int id;
	private String customerName;
	private double rate;
	private int days;
	private RentalType rental;
	private EnumType payment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public RentalType getRental() {
		return rental;
	}
	public void setRental(RentalType rental) {
		this.rental = rental;
	}
	public EnumType getPayment() {
		return payment;
	}
	public void setPayment(EnumType payment) {
		this.payment = payment;
	}

}
