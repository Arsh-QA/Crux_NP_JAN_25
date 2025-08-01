package lec32;

import java.util.*;

public class Busyman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			Pair[] arr = new Pair[n];
			for (int i = 0; i < arr.length; i++) {
				int st = sc.nextInt();
				int et = sc.nextInt();
				arr[i] = new Pair(st, et);
			}
			Arrays.sort(arr, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					return o1.et - o2.et;
				}
			});
			int activities = 1;
			int end = arr[0].et;
			for (int i = 1; i < arr.length; i++) {
				if (end <= arr[i].st) {
					end = arr[i].et;
					activities++;
				}
			}
			System.out.println(activities);
			t--;
		}
		sc.close();
	}

	static class Pair {
		int st;
		int et;

		public Pair(int st, int et) {
			this.st = st;
			this.et = et;
		}
	}
}