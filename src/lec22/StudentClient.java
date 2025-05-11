package lec22;

public class StudentClient {

	public static void main(String[] args) {
//		ArrayList<Integer> ll = new ArrayList<Integer>();
		System.out.println("Hey");
		Student s = new Student();
		System.out.println(s.name);
		System.out.println(s.age);
		s.name = "Raj";
		s.age = 22;
		System.out.println(s.name);
		System.out.println(s.age);
		s.introYourself();
		Student s1 = new Student();
		s1.name = "Kaju";
		s1.age = 21;
		s1.introYourself();
		s1.sayHey("Kamlesh");
		s1.mentorName();
		Student.mentorName();
	}

	static {
		System.out.println("I am in Student Client Class1");
	}
	static {
		System.out.println("I am in Student Client Class2");
	}
}