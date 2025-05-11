package leetcodeQuestions1;

public class FindTheHighestAltitude {

	public static void main(String[] args) {
		int[] gain = { -4, -3, -2, -1, 4, 3, 2 };
		System.out.println(largestAltitude(gain));

	}

	public static int largestAltitude(int[] gain) {
		int[] altitude = new int[gain.length + 1];
		for (int i = 1; i < altitude.length; i++) {
			altitude[i] = altitude[i - 1] + gain[i - 1];
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < altitude.length; i++) {
			if (altitude[i] > max) {
				max = altitude[i];
			}
		}
		return max;
	}
}