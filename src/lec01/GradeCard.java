package lec01;

public class GradeCard {
	public static void main(String[] args) {
		int m = 67;
		if (m >= 75) {
			System.out.println("A");
		} else if (m >= 65 && m < 75) {
			System.out.println("B");
		} else if (m >= 55 && m < 65) {
			System.out.println("C");
		} else if (m >= 45 && m < 55) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}
}
