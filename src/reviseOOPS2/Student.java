package reviseOOPS2;

public class Student {

	String name = "John Doe";
	int age = 18;

	public void introYourself() { // Non static method
//		System.out.println("My name is : " + name + " and age is : " + age);
//		OR
		System.out.println("My name is : " + this.name + " and age is : " + this.age);
	}

	public void sayHey(String name) {
		System.out.println(name + " say hey to " + this.name);
	}

	public static void fun() {
		System.out.println("I am in Fun");
	}

	static {
		System.out.println("Hey all, welcome");
	}

}