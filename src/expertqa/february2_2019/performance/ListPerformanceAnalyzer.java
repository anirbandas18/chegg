package expertqa.february2_2019.performance;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListPerformanceAnalyzer {
	
	private static final int N = 9;
	private static final BigInteger INPUT[] = new BigInteger[N];
	private static final int STEPS[] = {1, 10, 100};
	private static final int U = 1;
	private static final int K = 1000;
	private static final int M = 1000000;
	private static final int SAMPLE_SPACE = 10;
	
	static {
		System.out.println("At class load: initializing " + N + " data sets for input");
		for(int i = 0 ; i < STEPS.length ; i++) {
			INPUT[i] = new BigInteger(String.valueOf(STEPS[i] * U));
			INPUT[i + 3] = new BigInteger(String.valueOf(STEPS[i] * K));
			INPUT[i + 6] = new BigInteger(String.valueOf(STEPS[i] * M));
		}
		System.out.println("At class load: data sets for input: " + Arrays.toString(INPUT));
	}
	
	private long timeAddition(BigInteger size, POSITIONS pos) {
		List<Integer> list = new ArrayList<>();
		long start = System.nanoTime();
		for(int i = 0 ; i < size.intValue() ; i++) {
			int element = i + 1;
			int index = -1;
			switch(pos) {
			case END:
				index = list.size() == 0 ? 0 : list.size() - 1;
				break;
			case FRONT: 
				index = 0;
				break;
			case MIDDLE:
				index = list.size() / 2;
				break;
			}
			list.add(index, element);
		}
		long end = System.nanoTime();
		long duration = end - start;
		return duration;
	}
	
	private long timeDeletion(BigInteger size, POSITIONS pos) {
		List<Integer> list = new ArrayList<>(Collections.nCopies(size.intValue(), 1));
		long start = System.nanoTime();
		for(int i = 0 ; i < size.intValue() ; i++) {
			int index = -1;
			switch(pos) {
			case END:
				index = list.size() - 1;
				break;
			case FRONT: 
				index = 0;
				break;
			case MIDDLE:
				index = list.size() / 2;
				break;
			}
			list.remove(index);
		}
		long end = System.nanoTime();
		long duration = end - start;
		return duration;
	}
	
	private long getAverageTime(BigInteger size, POSITIONS pos, ACTIONS act) {
		long totalDuration = 0l;
		for(int i = 0 ; i < SAMPLE_SPACE ; i++) {
			switch(act) {
			case ADD:
				totalDuration = totalDuration + timeAddition(size, pos);
				break;
			case DELETE:
				totalDuration = totalDuration + timeDeletion(size, pos);
				break;
			}
		}
		long averageDuration = totalDuration / SAMPLE_SPACE;
		//averageDuration = TimeUnit.SECONDS.convert(averageDuration, TimeUnit.NANOSECONDS);
		return averageDuration;
	}
	
	public void analyze() {
		for(BigInteger i : INPUT) {
			System.out.print("n = " + i);
			PerformanceAttributes pa = new PerformanceAttributes();
			pa.setAddToFrontOfList(getAverageTime(i, POSITIONS.FRONT, ACTIONS.ADD));
			pa.setAddToMiddleOfList(getAverageTime(i, POSITIONS.MIDDLE, ACTIONS.ADD));
			pa.setAddToEndOfList(getAverageTime(i, POSITIONS.END, ACTIONS.ADD));
			pa.setDelFromFrontOfList(getAverageTime(i, POSITIONS.FRONT, ACTIONS.DELETE));
			pa.setDelFromMiddleOfList(getAverageTime(i, POSITIONS.MIDDLE, ACTIONS.DELETE));
			pa.setDelFromEndOfList(getAverageTime(i, POSITIONS.END, ACTIONS.DELETE));
			System.out.println(", performance = " + pa);
		}
	}
	
	public static void main(String[] args) {
		ListPerformanceAnalyzer lpa = new ListPerformanceAnalyzer();
		lpa.analyze();
	}

}
