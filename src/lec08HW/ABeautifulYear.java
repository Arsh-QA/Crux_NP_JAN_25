package lec08HW;

public class ABeautifulYear {

	public static void main(String[] args) {
		System.out.println(beautifulYear(9999));
	}

	public static int beautifulYear(int year) {
		year = year + 1;
		while (year <= 9000) {
			int[] occ = new int[10];
			boolean flag = isBeautifulYear(occ, year);
			if (flag)
				return year;
			year++;
		}
		return 0;
	}

	private static boolean isBeautifulYear(int[] occ, int year) {
		for (int i = 3; i >= 0; i--) {
			int x = (int) (year / Math.pow(10, i));
			occ[x]++;
			year = (int) (year % Math.pow(10, i));
		}
		for (int j : occ) {
			if (j > 1) {
				return false;
			}
		}
		return true;
	}

}
