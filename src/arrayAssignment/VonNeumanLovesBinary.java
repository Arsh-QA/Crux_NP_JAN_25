package arrayAssignment;

import java.util.Scanner;

public class VonNeumanLovesBinary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		for (int i = 0; i < n; i++) {
			System.out.println(binaryToDecimal(arr[i]));
		}
		sc.close();
	}

	public static long binaryToDecimal(long i) {
		long sum = 0;
		long pos = 0;
		while (i > 0) {
			long r = i % 10;
			sum = sum + r * (long) Math.pow(2, pos);
			i = i / 10;
			pos++;
		}
		return sum;
	}
}