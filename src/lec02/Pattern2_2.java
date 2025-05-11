package lec02;

public class Pattern2_2 {

	public static void main(String[] args) {
		int n = 5;
		int row = 1;
		int star = 1;
		while (row <= n) {
			// star
			int i = 1;
			while (i <= star) {
				System.out.print("* ");
				i++;
			}
			row++;
			star++;
			System.out.println();
		}
	}
}