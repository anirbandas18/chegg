package expertqa.october5_2018.mavrental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMethods {
	
	private static final String DATABASE_NAME = "MavRental";
	private static final String CONNECTION_URL = "jdbc:derby:%s/%s;create=true";
	
	private static String INSERT_CUSTOMER = "INSERT INTO CUSTOMER (NAME, STREET, CITY, STATE, ZIP, CREDIT_CARD_NUMBER) VALUES(?,?,?,?,?,?)";
	private static String INSERT_RENTAL = "INSERT INTO RENTAL (NAME, RENTAL_TYPE, ENUM_TYPE, RATE, DAYS) VALUES(?,?,?,?,?)";
	private static String GET_ALL_CUSTOMERS = "SELECT NAME, STREET, CITY, STATE, ZIP, CREDIT_CARD_NUMBER FROM CUSTOMER";
	private static String GET_ALL_RENTALS = "SELECT NAME, RENTAL_TYPE, ENUM_TYPE, RATE, DAYS FROM RENTAL";
	
	private String url;
	private Connection connection;
	private PreparedStatement customerInsertion, rentalInsertion;
	private PreparedStatement allCustomerRetrieval, allRentalRetrieval;
	
	public DatabaseMethods() {
		this.url = String.format(CONNECTION_URL,  System.getProperty("user.dir"), DATABASE_NAME);
	}
	
	public void connectToDatabase()  {
		try {
			connection = DriverManager.getConnection(url);
			customerInsertion = connection.prepareStatement(INSERT_CUSTOMER);
			rentalInsertion = connection.prepareStatement(INSERT_RENTAL);
			allCustomerRetrieval = connection.prepareStatement(GET_ALL_CUSTOMERS);
			allRentalRetrieval = connection.prepareStatement(GET_ALL_RENTALS);
			System.out.println("Connected to database: " + url);
		} catch (SQLException e) {
			System.err.println("Connection to database failed: " + e.getMessage());
		}
		
	}
	public List<Customer> writeCustomerToDatabase() {
		List<Customer> customers = new ArrayList<>();
		try {
			ResultSet rows = allCustomerRetrieval.executeQuery();
			while(rows.next()) {
				Customer c = new Customer();
				c.setName(rows.getString(1));
				c.setStreet(rows.getString(2));
				c.setCity(rows.getString(3));
				c.setState(rows.getString(4));
				c.setZip(rows.getString(5));
				c.setCreditCardNumber(rows.getString(6));
				customers.add(c);
			}
			System.out.println("Retrieved customers: " + customers.size());
		} catch (SQLException e) {
			System.err.println("Failed to retrieve customers: " + e.getMessage());
		}
		return customers;
	}
	public List<Rental> writeRentalToDatabase() {
		List<Rental> rentals = new ArrayList<>();
		try {
			ResultSet rows = allRentalRetrieval.executeQuery();
			while(rows.next()) {
				Rental r = new Rental();
				r.setCustomerName(rows.getString(1));
				r.setRental(RentalType.valueOf(rows.getString(2)));
				r.setPayment(EnumType.valueOf(rows.getString(3)));
				r.setRate(rows.getDouble(4));
				r.setDays(rows.getInt(5));
				rentals.add(r);
			}
			System.out.println("Retrieved rentals: " + rentals.size());
		} catch (SQLException e) {
			System.err.println("Failed to retrieve rentals: " + e.getMessage());
		}
		return rentals;
	}
	public void writeCustomerTable(Customer c) {
		try{
			customerInsertion.setString(1, c.getName());
			customerInsertion.setString(2, c.getStreet());
			customerInsertion.setString(3, c.getCity());
			customerInsertion.setString(4, c.getState());
			customerInsertion.setString(5, c.getZip());
			customerInsertion.setString(6, c.getCreditCardNumber());
			int rowsAffected = customerInsertion.executeUpdate();
			System.out.println("Successfully wrote customer data: " + rowsAffected);
		} catch (SQLException e) {
			System.err.println("Failed to write customer data: " + e.getMessage());
		}
	}
	public void writeRentalTable(Rental r) {
		try{
			rentalInsertion.setString(1, r.getCustomerName());
			rentalInsertion.setString(2, r.getRental().name());
			rentalInsertion.setString(3, r.getPayment().name());
			rentalInsertion.setDouble(4, r.getRate());
			rentalInsertion.setInt(5, r.getDays());
			int rowsAffected = rentalInsertion.executeUpdate();
			System.out.println("Successfully wrote rental data: " + rowsAffected);
		} catch (SQLException e) {
			System.err.println("Failed to write rental data: " + e.getMessage());
		}
	} 
	public void disconnectFromDatabse() {
		try {
			connection.close();
			System.out.println("Disconnectd from database");
		} catch (SQLException e) {
			System.err.println("Disconnection from database failed: " + e.getMessage());
		}
	} 

}
