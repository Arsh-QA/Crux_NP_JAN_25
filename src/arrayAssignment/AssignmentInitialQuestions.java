package arrayAssignment;

import java.util.Scanner;

public class AssignmentInitialQuestions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			if (i > 0)
				arr[i] = arr[i - 1] + sc.nextInt();
			else
				arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

	/*
	 * public static void sort(int[] arr) { int i = 0; int j = arr.length - 1; while
	 * (i < j) { if (arr[i] == 1 && arr[j] == 0) { int temp = arr[i]; arr[i] =
	 * arr[j]; arr[j] = temp; i++; j--; } else if (arr[i] == 1 && arr[j] == 1) {
	 * j--; } else if (arr[i] == 0 && arr[j] == 0) { i++; } else if (arr[i] == 0 &&
	 * arr[j] == 1) { i++; j--; } } }
	 * 
	 */

	/*
	 * public static void sort(int[] arr){ for(int i = 0; i < arr.length; i++){ int
	 * idx = minimumIndex(arr, i); int temp = arr[i]; arr[i] = arr[idx]; arr[idx] =
	 * temp; } }
	 * 
	 * 
	 * 
	 * public static int minimumIndex(int[] arr, int idx){ int mini = idx; for(int i
	 * = idx+1; i < arr.length; i ++){ if(arr[i] < arr[mini]){ mini = i; } } return
	 * mini; }
	 */

	/*
	 * public static boolean isShopkeeperCorrect(int[] arr, int money, int items) {
	 * int count = 0; for (int i = 0; i < arr.length; i++) { if (money % arr[i] ==
	 * 0) count++; } if (count >= items) return true; else return false; }
	 * 
	 * 
	 */

	/*
	 * 
	 * public static void pairOfRoses(int[] arr, int target) { int i = 0; int j =
	 * arr.length - 1; int diff = Integer.MAX_VALUE; int m = i; int n = j; while (i
	 * < j) { if (arr[i] + arr[j] > target) { j--; } else if (arr[i] + arr[j] <
	 * target) { i++; } else { if(arr[j] - arr[i] < diff){ diff = arr[j] - arr[i]; m
	 * = i; n = j; } i++; j--; } }
	 * System.out.println("Deepak should buy roses whose prices are " + arr[m] +
	 * " and " + arr[n] + "."); }
	 * 
	 */

	/*
	 * public static void inverseOfArray(int[] arr) { int i = 0; int j = arr.length
	 * - 1; while (i < j) { int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp; i++;
	 * j--; } }
	 * 
	 */

	/*
	 * public static int helpRamu(int[] rickshawRides, int[] cabRides, int c1, int
	 * c2, int c3, int c4) { int rickshawCost = 0; for (int i = 0; i <
	 * rickshawRides.length; i++) { rickshawCost += Math.min(c2, rickshawRides[i] *
	 * c1); } rickshawCost = Math.min(rickshawCost, c3); int cabCost = 0; for (int i
	 * = 0; i < cabRides.length; i++) { cabCost += Math.min(c2, cabRides[i] * c1); }
	 * cabCost = Math.min(cabCost, c3); int totalCost = rickshawCost + cabCost;
	 * totalCost = Math.min(totalCost, c4); return totalCost; }
	 * 
	 */

	public static void targetSumTriplets(int[] arr, int target) {
		int i = 0;
		int k = arr.length - 1;
		int j = k - 1;
		while (k > 1) {
			while (i < j) {
				if (arr[i] + arr[j] > target - arr[k]) {
					j--;
				} else if (arr[i] + arr[j] < target - arr[k]) {
					i++;
				} else if (arr[i] + arr[j] == target - arr[k]) {
					System.out.println(arr[i] + ", " + arr[j] + " and " + arr[k]);
					i++;
					j--;
				}
			}
			k--;
			i = 0;
			j = k - 1;
		}
	}
}