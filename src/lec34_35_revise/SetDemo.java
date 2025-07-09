package lec34_35_revise;

import java.util.HashSet;

public class SetDemo {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		set.add(20);
		set.add(2);
		set.add(201);
		set.add(1023);
		set.add(-10);
		set.add(5);
		System.out.println(set);

		// Contains - O(1)
		System.out.println(set.contains(2));
		System.out.println(set.contains(25));

		System.out.println(set.remove(2));

		System.out.println(set);

		for (int v : set) {
			System.out.print(v + " ");
		}
	}
}