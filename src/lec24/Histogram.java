package lec24;

import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {
		long[] arr = { 2, 1, 5, 6, 2, 3 };
		long[] arr1 = { 1, 2, 3, 4, 5 };
		System.out.println(maximumArea(arr1));
	}

	public static long maximumArea(long[] arr) {
		Stack<Integer> st = new Stack<>();
		long area = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
				long h = arr[st.pop()];
				long r = i;
				if (!st.isEmpty()) {
					long l = st.peek();
					area = Math.max(area, h * (r - l - 1));
				} else {
					area = Math.max(area, h * r);
				}
			}
			st.push(i);
		}
		int r = arr.length;
		while (!st.isEmpty()) {
			long h = arr[st.pop()];
			if (!st.isEmpty()) {
				long l = st.peek();
				area = Math.max(area, h * (r - l - 1));
			} else {
				area = Math.max(area, h * r);
			}
		}
		return area;
	}
}