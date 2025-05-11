package lec16;

public class BoardPath2 {

	public static void main(String[] args) {
		int dest = 4;
		boardPath(0, dest, "");
		System.out.println("==============");
		boardPathLoop(0, dest, "");

	}

	public static void boardPath(int curr, int dest, String path) {
		if (curr == dest) {
			System.out.println(path);
			return;
		}
		if (curr > dest)
			return;

		boardPath(curr + 1, dest, path + 1);
		boardPath(curr + 2, dest, path + 2);
		boardPath(curr + 3, dest, path + 3);
	}

	public static void boardPathLoop(int curr, int dest, String path) {
		if (curr == dest) {
			System.out.println(path);
			return;
		}
		if (curr > dest)
			return;

		for (int dice = 1; dice <= 3; dice++) {
			boardPath(curr + dice, dest, path + dice);
		}
	}
}