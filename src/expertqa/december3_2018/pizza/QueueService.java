package expertqa.december3_2018.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueService {

	/*
	 * cooking queue
	 * driver list
	 * delivery queue
	 */
	
	private Queue<Order> cooking;
	private Queue<Order> preDelivery;
	private List<Depart> delivery;
	private List<Login> driver;

	
	private int isDriverPresent(Login x) {
		int c = -1;
		for(Login l : driver) {
			if(l.getDriver().equalsIgnoreCase(x.getDriver())) {
				return ++c;
			}
		}
		return c;
	}
	
	private int locateDelivery(Depart x) {
		int c = -1;
		for(Depart d : delivery) {
			if(d.equals(x)) {
				return ++c;
			}
		}
		return c;
	}
	
	public QueueService() {
		this.cooking = new ConcurrentLinkedQueue<>();
		this.preDelivery = new ConcurrentLinkedQueue<>();
		this.driver = new ArrayList<>();
		this.delivery = new ArrayList<>();
	}
	
	public void loginDriver(Login login) {
		int index = isDriverPresent(login);
		if(index == -1) {
			driver.add(login);
			System.out.println(login.getDriver() + " logged in");
		} else {
			System.out.println(login.getDriver() + " already logged in");
		}
	}
	
	public void logoutDriver(Logout logout) {
		int index = isDriverPresent(logout);
		if(index != -1) {
			Login l = driver.remove(index);
			System.out.println(l.getDriver() + " logged out");
		} else {
			System.out.println(logout.getDriver() + " not present at the moment");
		}
	}
	
	public void placeOrder(Order o) {
		cooking.add(o);
		System.out.println(o + " is placed");
	}
	
	public Order serveOrder() {
		Order o = null;
		if(cooking.isEmpty()) {
			System.out.println("No orders to serve");
		} else {
			o = cooking.remove();
			System.out.println(o + " is served");
		}
		return o;
	}
	
	public void initDelivery(Order o) {
		preDelivery.add(o);
		System.out.println(o + " is ready for delivery");
	}
	
	/*
	 * 1
	 */
	public Order startDelivery() {
		Order o = null;
		if(preDelivery.isEmpty()) {
			System.out.println("No orders to deliver");
		} else {
			o = preDelivery.remove();
			System.out.println(o + " is out for delivery");
		}
		return o;
	}
	
	/*
	 * 3
	 */
	public void completeDelivery(Arrive a) {
		int index = locateDelivery(a);
		if(index != -1) {
			delivery.set(index, a);
			System.out.println(a + " completed delivery");
		} else {
			System.out.println(a + " not found");
		}
	}

	/*
	 * 2.1
	 */
	public void doDelivery(Depart d) {
		delivery.add(d);
		System.out.println(d + " is being delivered");
	}
	
	/*
	 * 2.2
	 */
	public Depart currentDelivery(Deliver dl) {
		int index = delivery.size() - 1;
		Depart d = delivery.get(index);
		System.out.println(d + " is underway");
		delivery.set(index, dl);
		return d;
	}

	public Queue<Order> getCooking() {
		return cooking;
	}

	public Queue<Order> getPreDelivery() {
		return preDelivery;
	}

	public List<Depart> getDelivery() {
		return delivery;
	}

	public List<Login> getDriver() {
		return driver;
	}
	
	
	
}
