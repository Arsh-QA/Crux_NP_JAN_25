package heapHashMapAssignment;

import java.util.*;

public class MedianInAStreamOfRunningIntegers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> high = new PriorityQueue<>();
			int count = 1;
			low.add(sc.nextInt());
			System.out.println(low.peek());
			count++;
			while (n-- > 0) {
				int next = sc.nextInt();
				if (next > low.peek()) {
					high.add(next);
				} else {
					low.add(next);
				}
				if (count % 2 == 0) {
					int ans = (low.peek() + high.peek()) / 2;
					System.out.println(ans);
				} else {
					if (low.size() > high.size())
						System.out.println(low.peek());
					else
						System.out.println(high.peek());
				}
				count++;
			}
		}
		sc.close();
	}
}