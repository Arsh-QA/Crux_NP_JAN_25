package lec16;

public class CountBoardPath {

	public static void main(String[] args) {
		int end = 4;
		System.out.println(countBoardPath(0, end, ""));
	}

	public static int countBoardPath(int curr, int dest, String path) {
		if (curr > dest)
			return 0;
		if (curr == dest) {
			System.out.println(path);
			return 1;
		}
		int count = 0;
		for (int dice = 1; dice <= 3; dice++) {
			count += countBoardPath(curr + dice, dest, path + dice);
		}
		return count;

//		boardPath(curr + 1, dest, path + 1);
//		boardPath(curr + 2, dest, path + 2);
//		boardPath(curr + 3, dest, path + 3);
	}
}