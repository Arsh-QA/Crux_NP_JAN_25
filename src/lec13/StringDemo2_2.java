package lec13;

public class StringDemo2_2 {
	public static void main(String[] args) {
		String s1 = "Hello";// String Pool
		String s2 = "Hello";// String Pool
		String s3 = new String("Hello");// Outside String Pool
		String s4 = new String("Hello");// Outside String Pool
		System.out.println(s1.equals(s4));
		s1 = s1 + "Bye";// Outside String Pool
		System.out.println(s1);
		System.out.println(s1 == s2);// false
		s2 = s2.concat("OK");// Outside String Pool
		System.out.println(s2);
		String s5 = "Raj" + "kaju";// String Pool
		String s6 = "Rajkaju";// String Pool
		System.out.println(s5 == s6);// true
		System.out.println(s1.length());
		System.out.println(s1.charAt(4));
	}
}