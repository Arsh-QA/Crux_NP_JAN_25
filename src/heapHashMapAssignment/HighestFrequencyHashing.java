package heapHashMapAssignment;

import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyHashing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(highestFrequence(arr));
		sc.close();
	}

	public static int highestFrequence(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		int key = 0;
		int max = Integer.MIN_VALUE;
		for (int v : map.keySet()) {
			if (map.get(v) > max) {
				key = v;
				max = map.get(v);
			}
		}
		return key;
	}

}
