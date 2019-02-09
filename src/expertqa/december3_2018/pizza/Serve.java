package expertqa.december3_2018.pizza;

public class Serve extends Command {

	public Serve() {
		super(CommandType.serve);
	}
	
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Serve [time=" + time + "]";
	}
	
	

}
