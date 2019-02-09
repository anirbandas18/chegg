package expertqa.december3_2018.pizza;

public abstract class Command {
	
	private CommandType type;

	public CommandType getType() {
		return type;
	}

	public Command(CommandType type) {
		this.type = type;
	}

}
