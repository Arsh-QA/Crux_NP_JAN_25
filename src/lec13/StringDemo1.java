package lec13;

public class StringDemo1 {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s1 == s2);//true
		System.out.println(s1 == s3);// Address//false
		System.out.println(s4 == s3);//false
		System.out.println(s1.equals(s4));// Content//true
	}
}