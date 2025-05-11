package lec05;

import java.util.Scanner;

public class DataTypesDemo3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'a';
		System.out.println((int) (ch));
		ch++;// ch = (char)(ch + 1);
		System.out.println(ch);
		ch += 1;// // ch = (char)(ch + 1);
		System.out.println(ch);
		ch = (char) (ch + 1);
		Scanner sc = new Scanner(System.in);
		ch = sc.next().charAt(0);
	}
}
