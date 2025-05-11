package lec16;

public class BoardPath {

	public static void main(String[] args) {
		int end = 3;
		boardPath(0, end, "");
	}

	public static void boardPath(int curr, int dest, String path) {
		if (curr > dest)
			return;
		if (curr == dest) {
			System.out.println(path);
			return;
		}

		for (int dice = 1; dice <= dest; dice++) {
			boardPath(curr + dice, dest, path + dice);
		}

//		boardPath(curr + 1, dest, path + 1);
//		boardPath(curr + 2, dest, path + 2);
//		boardPath(curr + 3, dest, path + 3);
	}
}