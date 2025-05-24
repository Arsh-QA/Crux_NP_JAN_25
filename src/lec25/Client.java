package lec25;

public class Client {
	public static void main(String[] args) {

//		Case 1
//		P obj = new P();
//		System.out.println(obj.d);
//		System.out.println(obj.d1);
//		obj.fun();
//		obj.fun1();

//		Case 2
//		P obj = new C();
//		System.out.println(obj.d);// 1
//		System.out.println(obj.d1);// 10
//		System.out.println(((C) obj).d2);// 20
//		System.out.println(((C) obj).d);// 2
//		obj.fun();
//		obj.fun1();
//		((C) obj).fun2();

//		Case 3 - Not allowed as the object created is of P, not C
//		C obj = new P();
//		System.out.println(obj.d);
//		System.out.println(obj.d1);
//		System.out.println(obj.d2);

//		Case 4
		C obj = new C();
		System.out.println(obj.d);
		System.out.println(obj.d1);
		System.out.println(obj.d2);
		System.out.println(((P) obj).d);
		obj.fun();
		obj.fun1();
		obj.fun2();
		((P) obj).fun();
	}
}