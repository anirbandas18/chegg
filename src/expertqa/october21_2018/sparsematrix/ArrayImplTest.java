package expertqa.october21_2018.sparsematrix;

public class ArrayImplTest {

	public static void main(String[] args) {
		LinkedSparseArray lsa = new LinkedSparseArray();
		System.out.println("inserted at 1: " + lsa.set(1, 4));
		System.out.println("inserted at 3: " + lsa.set(3, 2));
		System.out.println("inserted at 5: " + lsa.set(5, 77));
		System.out.println("inserted at 7: " + lsa.set(7, 5));
		System.out.println("size of sparse array: " + lsa.size());
		System.out.println("sparse array: " + lsa.toString());
		System.out.println("retrieved from 3: " + lsa.get(3));
		System.out.println("retrieved from 6: " + lsa.get(6));
		System.out.println("size of sparse array: " + lsa.size());
		System.out.println("inserted at 7: " + lsa.set(7, 7));
		System.out.println("inserted at 10: " + lsa.set(10, 23));
		System.out.println("size of sparse array: " + lsa.size());
		System.out.println("sparse array: " + lsa.toString());
		System.out.println("sparse array: " + lsa.toString());
		System.out.println("removed from 2: " + lsa.remove(2));
		System.out.println("removed from 5: " + lsa.remove(5));
		System.out.println("size of sparse array: " + lsa.size());
		System.out.println("sparse array: " + lsa.toString());
	}

}
