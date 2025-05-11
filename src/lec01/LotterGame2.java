package lec01;

public class LotterGame2 {
	public static void main(String[] args) {
		int num = 77;
		if (num >= 30 && num <= 50) {
			System.out.println("Bike");
			if (num >= 30 && num <= 40) {
				System.out.println("Splendor");
			} else {
				System.out.println("Hero");
			}
		} else if (num >= 100 && num <= 110) {
			System.out.println("KurKure");
			if (num >= 100 && num <= 105) {
				System.out.println("Normal Kurkure");
			} else {
				System.out.println("Red Kurkure");
			}
		} else if (num >= 321 && num <= 421) {
			System.out.println("Mac");
			if (num >= 321 && num <= 389) {
				System.out.println("M1 mac");
			} else {
				System.out.println("M2 mac");
			}
		} else if (num >= 500 && num <= 721) {
			System.out.println("Car");
			if (num >= 500 && num <= 600) {
				System.out.println("Thar");
			} else {
				System.out.println("Creta");
			}
		} else {
			System.out.println("Happy Birthday!!");
		}

	}
}
