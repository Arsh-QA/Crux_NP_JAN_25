package heapHashMapAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubarraysWithDistinctElements {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 3 };
		printSubArray(arr);
		System.out.println("*******************************");
		distintElements(arr);
	}

	public static void distintElements(int[] arr) {
//		HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
		ArrayList<ArrayList<Integer>> ll1 = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				ArrayList<Integer> ll = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					ll.add(arr[k]);
				}
				ll1.add(ll);
			}
		}
		System.out.println(ll1);
	}

	public static void printSubArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
//				System.out.println(i + " - " + j);
				for (int k = i; k <= j; k++)
					System.out.print(arr[k] + " ");
				System.out.println();
			}
		}
	}
}