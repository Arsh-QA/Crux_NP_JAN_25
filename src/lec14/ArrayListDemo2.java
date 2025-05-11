package lec14;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		ArrayList<Integer> ll = new ArrayList<>();
		ll.add(10);// O(1)
		ll.add(1);// O(1)
		ll.add(7);// O(1)
		ll.add(20);// O(1)
		ll.add(1, -9);// O(N)
		ll.add(71);
		ll.add(201);
		System.out.println(ll);

		// sort
		Collections.sort(ll);
		System.out.println(ll);
		for (int i = 0; i < ll.size(); i++) {
			System.out.print(ll.get(i) + " ");
		}
		System.out.println();

		int[] arr = new int[5];

		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		for (int v : ll) {
			System.out.print(v + " ");
		}
	}
}