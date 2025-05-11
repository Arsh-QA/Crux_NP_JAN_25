package lec14;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeSkillerArraySumOfTwoArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> al1 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al1.add(sc.nextInt());
		}
		int m = sc.nextInt();
		ArrayList<Integer> al2 = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			al2.add(sc.nextInt());
		}
		ArrayList<Integer> result = sumOfTwoArrays(al1, al2);
		for (int i = result.size() - 1; i >= 0; i--) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print("END");
		sc.close();
	}

	public static ArrayList<Integer> sumOfTwoArrays(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i = al1.size() - 1;
		int j = al2.size() - 1;
		int sum = 0;
		int rem = 0;
		int carry = 0;
		while (i >= 0 && j >= 0) {
			sum += al1.get(i) + al2.get(j) + carry;
			if (sum >= 10) {
				rem = sum % 10;
				carry = sum / 10;
				result.add(rem);
			} else {
				result.add(sum);
				carry = 0;
			}
			i--;
			j--;
			sum = 0;
		}
		if (carry != 0) {
			result.add(carry);
		}
		if (i >= 0) {
			while (i >= 0) {
				sum += al1.get(i);
				result.add(sum);
				i--;
				sum = 0;
			}
		}
		if (j >= 0) {
			while (j >= 0) {
				sum += al2.get(j);
				result.add(sum);
				j--;
				sum = 0;
			}
		}
		return result;
	}
}