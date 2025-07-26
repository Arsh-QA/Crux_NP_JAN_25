package heapHashMapAssignment;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[k][n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void mergeKSortedArrays(int[][] arr) {
//		PriorityQueue<Integer> pq = 
	}
}