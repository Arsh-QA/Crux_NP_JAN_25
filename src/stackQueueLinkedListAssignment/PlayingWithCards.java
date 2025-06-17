package stackQueueLinkedListAssignment;

import java.util.Scanner;
import java.util.Stack;

public class PlayingWithCards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
//		playingWithCards(a, q);
		recursionMethod(a, q, 1);
		sc.close();
	}

	public static void recursionMethod(int[] a, int q, int count) {
		if (a.length == 0)
			return;
		for (int i = count; i <= q; i++) {
			System.out.println("In the iteration");
			int prime = qthPrimeNumber(i);
			Stack<Integer> divisible = new Stack<>();
			Stack<Integer> notDivisible = new Stack<>();
			for (int j = 0; j < a.length; j++) {
				if (a[j] % prime == 0) {
					addLast(divisible, a[j]);
				} else {
					addLast(notDivisible, a[j]);
				}
			}
			int[] a1 = new int[divisible.size()];
			while (!divisible.isEmpty()) {
				int count1 = 0;
				a1[count1] = divisible.peek();
				System.out.println(divisible.pop());
				count++;
			}
			while (!notDivisible.isEmpty()) {
				System.out.println(notDivisible.pop());
			}
		}
	}

	private static void playingWithCards(int[] a, int q) {
		int count = 1;
		Stack<Integer> notDivisible = new Stack<>();
		Stack<Integer> divisible = new Stack<>();
		while (count <= q) {
			int prime = qthPrimeNumber(count);
			for (int i = 0; i < a.length; i++) {
				if (a[i] % prime == 0) {
					addLast(divisible, a[i]);
				} else {
					addLast(notDivisible, a[i]);
				}
			}
			int[] a1 = new int[notDivisible.size()];
			int index = a1.length - 1;
			while (!notDivisible.isEmpty()) {
				a1[index] = notDivisible.pop();
				index--;
			}
			a = a1;
			if (count != q) {
				while (!divisible.isEmpty())
					divisible.pop();
			}
			count++;
		}
		while (!divisible.isEmpty()) {
			System.out.println(divisible.pop());
		}
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.println(a[i]);
		}
	}

	private static void addLast(Stack<Integer> st, int item) {
		if (st.isEmpty()) {
			st.push(item);
			return;
		}
		int x = st.pop();
		addLast(st, item);
		st.push(x);
	}

	private static int qthPrimeNumber(int q) {
		int count = 0;
		int i = 2;
		while (count < q) {
			if (isPrime(i)) {
				count++;
				if (count == q)
					return i;
			}
			i++;
		}
		return i;
	}

	public static boolean isPrime(int n) {
		int div = 2;
		while (div * div <= n) {
			if (n % div == 0)
				return false;
			div++;
		}
		return true;
	}
}