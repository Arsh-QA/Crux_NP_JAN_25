package lec34;

public class StringBuilderDemo2 {

	public static void main(String[] args) {
		stringBuilderAdd();
		stringAdd();
	}

	public static void stringAdd() {
		String s = "";
		for (int i = 0; i < 1000000; i++) {
			s = s + i;
		}
	}

	public static void stringBuilderAdd() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000000; i++) {
			sb.append(i);
		}
	}
}