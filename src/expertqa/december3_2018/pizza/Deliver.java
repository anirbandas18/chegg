package expertqa.december3_2018.pizza;

public class Deliver extends Depart {

	private String time, driver;
	private float tip;
	
	
	public float getTip() {
		return tip;
	}

	public void setTip(float tip) {
		this.tip = tip;
	}

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
		return "Deliver [time=" + time + ", driver=" + driver + ", tip=" + tip + "]";
	}

	
	
}
