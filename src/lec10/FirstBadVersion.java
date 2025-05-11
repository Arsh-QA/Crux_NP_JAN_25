package lec10;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s = (int) Math.pow(2, 31);
		int p = (int) Math.pow(2, 31);
		System.out.println(s + p);
		System.out.println(s - p);
	}

	public static int firstBadVersion(int n) {
		int low = 1;
		int high = n;
		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid) == true) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}
}
