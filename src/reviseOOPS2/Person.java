package reviseOOPS2;

public class Person {

	String name = "Anish";
	int age = 22;

	public void introYourself() {
		System.out.println("My name is " + name + " and my age is " + age);
	}
	
	public Person() {
		
	}

	public Person(int age, String name) { // Parameterized constructor
		this.age = age;
		this.name = name;
	}

}
