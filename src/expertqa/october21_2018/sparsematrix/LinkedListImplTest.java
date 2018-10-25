package expertqa.october21_2018.sparsematrix;

public class LinkedListImplTest {

	public static void main(String[] args) {
		ArraySparseArray asa = new ArraySparseArray(10);
		System.out.println("inserted at 1: " + asa.set(1, 4));
		System.out.println("inserted at 3: " + asa.set(3, 2));
		System.out.println("inserted at 5: " + asa.set(5, 77));
		System.out.println("inserted at 7: " + asa.set(7, 5));
		System.out.println("size of sparse array: " + asa.size());
		System.out.println("sparse array: " + asa.toString());
		System.out.println("retrieved from 3: " + asa.get(3));
		System.out.println("retrieved from 6: " + asa.get(6));
		System.out.println("size of sparse array: " + asa.size());
		System.out.println("inserted at 7: " + asa.set(7, 7));
		System.out.println("inserted at 10: " + asa.set(10, 23));
		System.out.println("size of sparse array: " + asa.size());
		System.out.println("sparse array: " + asa.toString());
		System.out.println("sparse array: " + asa.toString());
		System.out.println("removed from 2: " + asa.remove(2));
		System.out.println("removed from 5: " + asa.remove(5));
		System.out.println("size of sparse array: " + asa.size());
		System.out.println("sparse array: " + asa.toString());
	}

}
