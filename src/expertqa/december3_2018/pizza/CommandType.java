package expertqa.december3_2018.pizza;

public enum CommandType {
	
	login(1, "login [a-zA-Z]{1,}"),
	logout(2, "logout [a-zA-Z]{1,}"),
	order(3, "order [0-9]{1,2}:[0-9]{2} [a-zA-Z\\s0-9]{1,}"),
	serve(4, "serve [0-9]{1,2}:[0-9]{2}"),
	depart(5, "depart [0-9]{1,2}:[0-9]{2} [a-zA-Z]{1,}"),
	deliver(6, "deliver [0-9]{1,2}:[0-9]{2} [a-zA-Z]{1,} [0-9]{1,2}\\.[0-9]{1,2}"),
	arrive(7, "arrive [0-9]{1,2}:[0-9]{2} [a-zA-Z]{1,}"),
	status(8, "status"),
	summary(9, "summary"),
	quit(10, "quit");

	private int code;
	private String regex;
	
	private CommandType(int code, String regex) {
		this.code = code;
		this.regex = regex;
	}

	public int getCode() {
		return code;
	}

	public String getRegex() {
		return regex;
	}
	
	
}
