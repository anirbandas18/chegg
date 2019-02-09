package expertqa.december3_2018.pizza;

public class Arrive extends Depart {

	
	private String time, driver;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Arrive [time=" + time + ", driver=" + driver + "]";
	}

	

}
