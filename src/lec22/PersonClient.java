package lec22;

public class PersonClient {

	public static void main(String[] args) {
		System.out.println("hey");
		Person p = new Person("Ankita", 22);
		p.setAge(-20);
		System.out.println(p.getAge());
		System.out.println("Bye");
//		p.name = "Ankit";
//		System.out.println(p.name);
//		System.out.println(p.age);
//		p.name = "Ankita";
//		p.age = 22;
//		System.out.println(p.name);
//		System.out.println(p.age);
	}
}