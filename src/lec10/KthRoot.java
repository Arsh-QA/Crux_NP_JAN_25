package lec10;

public class KthRoot {

	public static void main(String[] args) {
		int n = 143;
		int k = 3;
		System.out.println(kthRoot(n, k));
	}

	public static int kthRoot(int n, int k) {
		int lo = 1, hi = n;
		int ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (Math.pow(mid, k) <= n) {
				ans = mid;
				lo = mid + 1;
			} else
				hi = mid - 1;
		}
		return ans;
	}
}