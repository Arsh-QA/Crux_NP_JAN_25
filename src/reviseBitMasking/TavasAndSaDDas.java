package reviseBitMasking;

import java.util.Scanner;

public class TavasAndSaDDas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = Integer.toString(n);
		System.out.println(tavasSaDDas(str));
		sc.close();
	}

	public static int tavasSaDDas(String str) {
		int n = str.length();
		int count = (1 << n) - 2;
		int pos = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '7') {
				count += (1 << pos);
			}
			pos++;
		}
		return count + 1;
	}
}