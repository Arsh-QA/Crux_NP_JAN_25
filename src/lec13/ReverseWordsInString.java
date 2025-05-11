package lec13;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String s = "      the  sky     is     blue      ";
		System.out.println(s);
		s = s.trim();
		System.out.println(s);
		String[] arr = s.split(" +");
		String ans = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			ans = ans + arr[i] + " ";
		}
		System.out.print(ans.trim());
	}
}