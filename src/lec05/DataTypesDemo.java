package lec05;

import java.util.Scanner;

public class DataTypesDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// byte b = (byte) (300);//--> 44
		byte b = (byte) (428);
		byte b1 = -5;
		short s = 8;
		int i = 9;
		long l = 4966768691l;
		System.out.println(b);
		i = b1;
		Scanner sc = new Scanner(System.in);
		b = sc.nextByte();
		s = sc.nextShort();
		i = sc.nextInt();
		l = sc.nextLong();

	}
}
