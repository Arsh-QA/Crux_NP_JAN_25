package lec22;

public class Person {

	private String name = "Kaju";
	private int age = 20;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		try {
			if (age < 0 || age > 78) {
				throw new Exception("Age not in range");
			}
			this.age = age;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("I am in finally Block");
		}
	}

//	public void setAge(int age) throws Exception {
//		if (age < 0 || age > 78) {
//			throw new Exception("Age not in range");
//		}
//		this.age = age;
//	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}