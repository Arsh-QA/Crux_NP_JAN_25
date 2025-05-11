package binary2DArrayAssignment;

import java.util.Scanner;

public class BookAllocationProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int pages = sc.nextInt();
			int students = sc.nextInt();
			int[] books = new int[pages];
			for (int i = 0; i < pages; i++) {
				books[i] = sc.nextInt();
			}
			System.out.println(maximumPages(books, students));
			t--;
		}
		sc.close();
	}

	public static int maximumPages(int[] books, int students) {
		int low = 0;
		int high = 0;
		int ans = 0;
		for (int i = 0; i < books.length; i++) {
			high = high + books[i];
		}
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isItPossible(books, mid, students)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static boolean isItPossible(int[] books, int maxPages, int students) {
		int student = 1;
		int readPage = 0;
		for (int i = 0; i < books.length;) {
			if (readPage + books[i] <= maxPages) {
				readPage += books[i];
				i++;
			} else {
				student++;
				readPage = 0;
			}
			if (student > students) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 public static boolean isItPossible(int[] books, int maxPages, int students) {
		int pagesRead = 0;
		int student = 1;
		for (int i = 0; i < books.length; i++) {
			if (pagesRead + books[i] > maxPages) {
				student++;
				pagesRead = books[i];
				if (student > students) {
					return false;
				}
			} else {
				pagesRead += books[i];
			}
		}
		return true;
	}
	 */
}