package lec25;

public class Student {

	String name = "Raj";
	int age = 28;

	@Override
	public String toString() {
		return name + " " + age;
	}

	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s);
	}
}