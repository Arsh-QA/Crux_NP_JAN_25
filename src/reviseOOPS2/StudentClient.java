package reviseOOPS2;

public class StudentClient {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.name);
		System.out.println(s.age);
		s.name = "Mohini";
		s.age = 20;
		s.introYourself();
		s.sayHey("Raja");

		Student s1 = new Student();
		s1.name = "Hunir";
		s1.age = 25;
		s1.introYourself();
		s1.sayHey("Raja");

		Student.fun();
		s.fun();
		s1.fun();

	}
}