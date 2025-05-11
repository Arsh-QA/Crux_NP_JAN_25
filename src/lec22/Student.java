package lec22;

public class Student {

	String name;
	int age;

	public void introYourself() {
		System.out.println("My name is : " + this.name + " and age is : " + this.age);
	}

	public void sayHey(String name) {
//		introYourself();
		System.out.println(this.name + " Say Hey " + name);
	}

	public static void mentorName() {
		System.out.println("Monu Bhaiya");
	}
	
	static {
		System.out.println("I am in Student Class");
	}
}