package reviseBitMasking;

public class OddEven {
	public static void main(String[] args) {

		int n = 67;
		if ((n & 1) == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}
}