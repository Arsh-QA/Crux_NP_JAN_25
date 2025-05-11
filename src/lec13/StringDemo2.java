package lec13;

public class StringDemo2 {
	public static void main(String[] args) {
		String s1 = "Hello"; // String Pool ----> 1st way of creating String in String Pool
		String s2 = "Hello"; // String Pool
		String s3 = new String("Hello");// Outside String Pool
		String s4 = new String("Hello");// Outside String Pool
		s1 = s1 + "Bye";// Outside String Pool
		System.out.println(s1);
		s2 = s2.concat("Ok");// Outside String Pool
		System.out.println(s2);
		String s5 = "Raj" + "kaju";// String Pool ----> 2nd way of creating String in String Pool
		String s6 = "RajKaju";// String Pool
		System.out.println(s5 == s6);
		int[] arr = new int[7];
		System.out.println(arr.length);// variable
		System.out.println(s1.length());// method
		System.out.println(s1.charAt(4));
	}
}