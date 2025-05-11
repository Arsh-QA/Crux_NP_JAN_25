package lec03;

public class Pattern27 {
	public static void main(String[] args) {
		int n = 5;
		int row = 1;
		int star = 1;
		int space = n - 1;
		while (row <= n) {
			// space
			int i = 1;
			while (i <= space) {
				System.out.print("  ");
				i++;
			}
			// star
			int j = 1;
			int val = 1;
			while (j <= star) {
				System.out.print(val + " ");
				if (j < star / 2 + 1) {
					val++;
				} else {
					val--;
				}
				j++;
			}
			// next row ki prep
			row++;
			star += 2;
			space--;
			System.out.println();

		}
	}
}
