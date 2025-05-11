package lec02;

public class Pattern1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int row = 1;
		int start = n;
		while (row <= n) {
			// star
			int i = 1;
			while (i <= start) {
				System.out.print("* ");
				i++;
			}
			// next Perp
			System.out.println();
			row++;
		}
	}
}
