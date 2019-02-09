package expertqa.december3_2018.pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class PizzaTrackingSystem {
	
	private QueueService queue;
	
	public PizzaTrackingSystem() {
		this.queue = new QueueService();
	}
	
	private void login(String tkns[]) {
		Login login = new Login();
		login.setDriver(tkns[1]);
		queue.loginDriver(login);
	}
	
	private void logout(String tkns[]) {
		Logout logout = new Logout();
		logout.setDriver(tkns[1]);
		queue.logoutDriver(logout);
	}
	
	private void order(String[] tkns) {
		Order o = new Order();
		List<String> info = Arrays.asList(Arrays.copyOfRange(tkns, 2, tkns.length));
		o.setInfo(String.join(" ", info));
		o.setTime(tkns[1]);
		queue.placeOrder(o);
	}
	
	private Order serve(String[] tkns) {
		Order o = queue.serveOrder();
		o.setTime(tkns[1]);
		return o;
	}
	
	private void depart(String[] tkns) {
		Order o = queue.startDelivery();
		Depart d = new Depart();
		d.setDriver(tkns[2]);
		d.setTime(tkns[1]);
		d.setOrder(o);
		queue.doDelivery(d);
	}
	
	private void prepareForDelivery(Order o) {
		queue.initDelivery(o);
	}
	
	private void deliver(String[] tkns) {
		Deliver dl = new Deliver();
		dl.setTime(tkns[1]);
		dl.setDriver(tkns[2]);
		dl.setTip(Float.parseFloat(tkns[2]));
		Depart d = queue.currentDelivery(dl);
		dl.setOrder(d.getOrder());
		queue.currentDelivery(dl);
	}
	
	private void arrive(String[] tkns) {
		Arrive a = new Arrive();
		a.setDriver(tkns[2]);
		a.setTime(tkns[1]);
		queue.completeDelivery(a);
	}
	
	private void status() {
		System.out.println("Orders waiting to cook: ");
		for(Order o : queue.getCooking()) {
			System.out.println("\t" + o);
		}
		System.out.println("Orders waiting to depart: ");
		for(Order o : queue.getPreDelivery()) {
			System.out.println("\t" + o);
		}
		System.out.println("Drivers : ");
		for(Depart o : queue.getDelivery()) {
			System.out.println("\t" + o);
		}
	}
	
	public static void main(String[] args) throws IOException {
		PizzaTrackingSystem pts = new PizzaTrackingSystem();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean execute = true;
		Order o = null;
		while(execute) {
			String line = br.readLine();
			String[] tkns = line.split("\\s");
			String cmd = tkns[0];
			CommandType type = CommandType.valueOf(cmd);
			if(line.matches(type.getRegex())) {
				switch(type) {
				case arrive:
					pts.arrive(tkns);
					break;
				case deliver:
					pts.deliver(tkns);
					break;
				case depart:
					pts.depart(tkns);
					break;
				case login:
					pts.login(tkns);
					break;
				case logout:
					pts.logout(tkns);
					break;
				case order:
					pts.order(tkns);
					break;
				case quit:
					execute = false;
					System.out.println("Terminating pizza tracking system");
					break;
				case serve:
					o = pts.serve(tkns);
					pts.prepareForDelivery(o);
					break;
				case status:
					pts.status();
					break;
				case summary:
					break;
				}
			} else {
				System.out.println("Invalid format: " + type);
			}
		}
	}

}
