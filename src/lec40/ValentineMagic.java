package lec40;

import java.util.Arrays;

public class ValentineMagic {

	public static void main(String[] args) {
		int[] boys = { 2, 11, 3 };
		int[] girls = { 5, 7, 3, 2 };
		Arrays.sort(boys);
		Arrays.sort(girls);
		System.out.println(valentine(boys, girls, 0, 0));
	}

	public static int valentine(int[] boys, int[] girls, int i, int j) {
		if (i == boys.length)
			return 0;
		if (j == girls.length)
			return 9834849;
		int select = Math.abs(boys[i] - girls[j]) + valentine(boys, girls, i + 1, j + 1);
		int reject = valentine(boys, girls, i, j + 1);
		return Math.min(select, reject);
	}
}