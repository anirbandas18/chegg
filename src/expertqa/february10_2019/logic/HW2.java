package expertqa.february10_2019.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class HW2 {
	
	private static char logicSelection;
	private static int total;
	
	private void printMenu() {
		System.out.println("Logic Selections:");
		System.out.println("(a) Logical AND (&&)");
		System.out.println("(b) Logical OR (||)");
		System.out.println();
		System.out.println("Methods:");
		System.out.println("Make Logic Selection");
		System.out.println("Modulo Range");
		System.out.println("Perform Logic");
		System.out.println("Print Truth Table");
	}
	
	private void printTruthTable() {
		switch(HW2.logicSelection) {
		case 'a':
		case 'A':
			System.out.println(String.format("%s%5s%12s", "A", "B", "(A && B)"));
			System.out.println(String.join("", Collections.nCopies(19, "-")));
			System.out.println(String.format("%s%5s%9s", "T", "T", "T"));
			System.out.println(String.format("%s%5s%9s", "T", "F", "F"));
			System.out.println(String.format("%s%5s%9s", "F", "T", "F"));
			System.out.println(String.format("%s%5s%9s", "F", "F", "F"));
			break;
		case 'b':
		case 'B':
			System.out.println(String.format("%s%5s%12s", "A", "B", "(A || B)"));
			System.out.println(String.join("", Collections.nCopies(19, "-")));
			System.out.println(String.format("%s%5s%9s", "T", "T", "T"));
			System.out.println(String.format("%s%5s%9s", "T", "F", "T"));
			System.out.println(String.format("%s%5s%9s", "F", "T", "T"));
			System.out.println(String.format("%s%5s%9s", "F", "F", "F"));
			break;
		}
	}
	
	private void moduloRange(int modValue) {
		System.out.print(String.format("%-19s", "Start of Range:"));
		System.out.println(0);
		System.out.print(String.format("%-19s", "End of Range:"));
		System.out.println(modValue - 1);
		
	}
	
	private boolean makeLogicSelection(char logicSelection) {
		boolean flag = true;
		switch(logicSelection) {
		case 'a':
		case 'A':
			break;
		case 'b':
		case 'B':
			break;
		default:
			flag = false;
			System.out.println("Invalid logic selection\n");
			break;
		}
		HW2.logicSelection = flag ? logicSelection : HW2.logicSelection;
		return flag;
	}

	private void performLogic(boolean operand1, boolean operand2, boolean negation) {
		boolean result = false;
		String symbol = "";
		switch(HW2.logicSelection) {
		case 'a':
		case 'A':
			symbol = "&&";
			result = operand1 && operand2;
			result = negation ? !result : result;
			break;
		case 'b':
		case 'B':
			symbol = "||";
			result = operand1 || operand2;
			result = negation ? !result : result;
			break;
		}
		System.out.println((negation ? "!" : "") + "(" + operand1 + " " + symbol + " " + operand2 + ") yields " + result + "\n");
	}
	
	public void execute(BufferedReader br) throws NumberFormatException, IOException {
		do {
			printMenu();
			System.out.println("\nEnter the number corresponding to your choice of operation: ");
			int choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:
			case 3:
				System.out.println("Operation #" + (++HW2.total) + "\n");
				System.out.print("Logic selection: ");
				char c = (char) br.read();
				br.readLine();
				System.out.println();
				if(makeLogicSelection(c)) {
					System.out.print(String.format("%-18s", "Operand #1:"));
					boolean op1 = Boolean.parseBoolean(br.readLine());
					System.out.print(String.format("%-18s", "Operand #2:"));
					boolean op2 = Boolean.parseBoolean(br.readLine());
					System.out.print(String.format("%-18s", "Negation:"));
					boolean neg = Boolean.parseBoolean(br.readLine());
					System.out.println();
					performLogic(op1, op2, neg);
				}
				break;
			case 2:
				System.out.println("Operation #" + (++HW2.total) + "\n");
				System.out.print(String.format("%-19s", "Mod Value:"));
				int mv = Integer.parseInt(br.readLine());
				moduloRange(mv);
				break;
			case 4:
				System.out.println("Operation #" + (++HW2.total) + "\n");
				printTruthTable();
				break;
			default:
				System.out.println("Invalid choice selection\n");
				break;
			}
		} while(true);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		HW2 ob = new HW2();
		ob.execute(br);
	}

}
