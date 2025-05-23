package reviseRecursion;

public class Power {

	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		System.out.println(pow(a, b));
	}

	public static int pow(int a, int b) {
		if (b == 0)
			return 1;
		int ans = pow(a, b - 1);
		return a * ans;
	}

}
