package recursionRevision;

public class BoardPath {

	public static void main(String[] args) {
		boardPath(0, 4, "");

	}

	public static void boardPath(int curr, int dest, String path) {
		if (curr == dest) {
			System.out.print(path + " ");
			return;
		}
		if (curr > dest) {
			return;
		}

		for (int dice = 1; dice <= 3; dice++) {
			boardPath(curr + dice, dest, path + dice);
		}
//		boardPath(curr + 1, dest, path + 1);
//		boardPath(curr + 2, dest, path + 2);
//		boardPath(curr + 3, dest, path + 3);
	}
}