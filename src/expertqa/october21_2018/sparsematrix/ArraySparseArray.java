package expertqa.october21_2018.sparsematrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySparseArray implements SparseArray {

	private static class Pair {
		private int index;
		private int value;
		public Pair(int index, int value) {
			this.index = index;
			this.value = value;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "[index=" + index + ", value=" + value + "]";
		}
		
	}
	
	private Pair[ ] arr; 
	private int numElements;
	public ArraySparseArray(int initSize) 
	{
		this.numElements = 0;
		this.arr = new Pair[initSize];
		Arrays.fill(arr, new Pair(-1, 0));
	}
	
	@Override
	public int size() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public int get(int index) {
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			Pair p = arr[mid];
			if(p.getIndex() == index) {
				return p.getValue();
			} else if(mid == index && p.getIndex() == -1) {
				return 0;
			}
			else if(mid < index) {
				low = mid + 1;
			} else if(mid > index) {
				high = mid - 1;
			}
		}
		return 0;
	}

	@Override
	public int set(int index, int value) {
		if(index < 0) {
			return 0;
		} else {
			if(numElements == arr.length || index >= arr.length) {
				int oldLength = arr.length;
				arr = Arrays.copyOf(arr, 2 * (oldLength - 1));
				Arrays.fill(arr, oldLength, arr.length, new Pair(-1, 0));
			}
			Pair p = arr[index];
			Pair n = new Pair(index, value);
			if(p.getIndex() == -1) {
				numElements++;
				arr[index] = n;
				return p.getValue();
			}
			arr[index] = n;
			return p.getValue();
		}
	}
	
	public int remove(int index) {
		if(index < 0 || index >= arr.length) {
			return 0;
		} else {
			Pair p = arr[index];
			if(p.getIndex() != -1) {
				numElements--;
				arr[index] = new Pair(-1, 0);
			}
			return p.getValue();
		}
	}
	
	@Override
	public String toString() {
		List<String> values = new ArrayList<>();
		for(Pair p : arr) {
			if(p.getIndex() != -1) {
				values.add(p.toString());
			}
		}
		String sparseRep = String.join(" | ", values);
		return sparseRep;
	}

}
