package expertqa.october21_2018.sparsematrix;

import java.util.ArrayList;
import java.util.List;

public class LinkedSparseArray implements SparseArray {

	private static class SListNode {
		private int index;
		private int value;
		private SListNode next;
		public SListNode(int index, int value) {
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
		public SListNode getNext() {
			return next;
		}
		public void setNext(SListNode next) {
			this.next = next;
		}
		
	}
	
	private SListNode head;
	private int numElements;
	public LinkedSparseArray() {
		this.numElements = 0;
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
		SListNode ptr = head;
		for(; ptr.getNext() != null ; ptr = ptr.getNext()) {
			if(ptr.getIndex() == index) {
				return ptr.getValue();
			}
		}
		if(ptr.getIndex() == index) {
			return ptr.getValue();
		}
		return 0;
	}

	@Override
	public int set(int index, int value) {
		SListNode ndptr = new SListNode(index, value);
		if(head == null) {
			head = ndptr;
			numElements++;
			return ndptr.getValue();
		} else {
			SListNode ptr = head;
			if(head.getIndex() > index) {
				ndptr.setNext(ptr);
				head = ndptr;
				numElements++;
				return ndptr.getValue();
			} else {
				while(ptr.getNext() != null) {
					if(ptr.getIndex() == index) {
						int oldValue = ptr.getValue();
						ptr.setValue(value);
						return oldValue;
					} else if (ptr.getIndex() < index && ptr.getNext().getIndex() > index) {
						ndptr.setNext(ptr.getNext());
						ptr.setNext(ndptr);
						numElements++;
						return ndptr.getValue();
					}
					ptr = ptr.getNext();
				}
				if(ptr.getIndex() == index) {
					int oldValue = ptr.getValue();
					ptr.setValue(value);
					return oldValue;
				} else {
					numElements++;
					ptr.setNext(ndptr);
					return ndptr.getValue();
				}
			}
		}
	}
	
	public int remove(int index) {
		if(head == null) {
			return 0;
		} else if(numElements == 1){
			int oldValue = head.getValue();
			head = null;
			numElements--;
			return oldValue;
		} else {
			SListNode ptr = head;
			while(ptr.getNext() != null) {
				if(ptr.getNext().getIndex() == index) {
					int oldValue = ptr.getNext().getValue();
					ptr.setNext(ptr.getNext().getNext());
					numElements--;
					return oldValue;
				}
				ptr = ptr.getNext();
			}
			return 0;
		}
	}
	
	@Override
	public String toString() {
		List<String> values = new ArrayList<>();
		SListNode ptr = head;
		while(ptr.getNext() != null) {
			values.add(ptr.toString());
			 ptr = ptr.getNext();
		}
		values.add(ptr.toString());
		String sparseRep = String.join(" --> ", values);
		return sparseRep;
	}

}
