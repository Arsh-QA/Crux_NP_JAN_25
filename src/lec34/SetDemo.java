package lec34;

import java.util.*;

public class SetDemo {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		set.add(3);
		set.add(13);
		set.add(32);
		set.add(-3);
		set.add(7);
		set.add(9);
		set.add(11);
		System.out.println(set);
//		System.out.println(set.contains(11)); // True if present | False if Not present
//		System.out.println(set.contains(1));
//		System.out.println(set.remove(32));
//		System.out.println(set);

		TreeSet<Integer> set1 = new TreeSet<>();
		set1.add(3);
		set1.add(13);
		set1.add(32);
		set1.add(-3);
		set1.add(7);
		set1.add(9);
		set1.add(11);
		System.out.println(set1);

		LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
		set2.add(3);
		set2.add(13);
		set2.add(32);
		set2.add(-3);
		set2.add(7);
		set2.add(9);
		set2.add(11);
		System.out.println(set2);

		for (int v : set1) {
			System.out.print(v + " ");
		}
	}
}