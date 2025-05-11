package lec04;

public class ContinueDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		for (int i = 0; i <= n; i++) {
			if (i == 2) {
				continue;
			}
			System.out.println(i);
		}

	}
}
