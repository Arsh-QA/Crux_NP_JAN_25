package lec03;

public class Pattern13 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int row = 1;
		int star = 1;
		while (row <= 2 * n - 1) {
			// star
			int i = 1;
			while (i <= star) {
				System.out.print("* ");
				i++;
			}
			// mirroring
			if (row < n) {
				star++;
			} else {
				star--;
			}

			// next row ki prep
			System.out.println();
			row++;

		}
	}
}
