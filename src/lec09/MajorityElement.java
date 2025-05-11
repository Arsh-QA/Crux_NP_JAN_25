package lec09;

public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(mooreVoting(arr));
	}

	public static int mooreVoting(int[] arr) {
		int e = arr[0];
		int vote = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == e) {
				vote++;
			} else {
				vote--;
				if (vote == 0) {
					e = arr[i];
					vote = 1;
				}
			}
		}
		return e;
	}

}
