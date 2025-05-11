package lec14;

public class WrapperClass {

	public static void main(String[] args) {
		int a = 10;
		Integer a1 = 10;
		System.out.println(a);
		System.out.println(a1);
		long x = 19;
		Long ll = 19l;
		Long ll1 = (long) 19;
		// Auto Boxing
		int b = 10;
		Integer b1 = 103;
		b1 = b;// auto boxing

		// Un-Boxing
		b = b1;// un boxing

		Integer c1 = 12;
		Integer c2 = 12;
		Integer c3 = 152;
		Integer c4 = 152;
		System.out.println(b1 == c1);// true
		int c = 152;
		System.out.println(c == c3);// true content compare ho raha hai
//		System.out.println(c1 == c2);// true address compare ho rha hai 
//		System.out.println(c3 == c4);// false address compare ho rha hai 
//		Character ch = 'a';
//		Character ch1 = 'a';
//		System.out.println(ch == ch1);// true address compare ho rha hai 
//		Boolean b4 = false;
//		Boolean b5 = false;
//		System.out.println(b4 == b5);// true address compare ho rha hai 
	}
}