package lec23;

public class Stack {

	protected int[] arr;
	private int idx = -1;

	public Stack() {
		this(5);
	}

	public Stack(int n) {
		arr = new int[n];
	}

	// O(1)
	public boolean isEmpty() {
		return idx == -1;
	}

	// O(1)
	public boolean isFull() {
		return idx == arr.length - 1;
	}

	// O(1)
	public void push(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Stack is full");
		}
		idx++;
		arr[idx] = item;
	}

	// O(1)
	public int size() {
		return idx + 1;
	}

	// O(1)
	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		}
		return arr[idx];
	}

	// O(1)
	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		}
		int v = arr[idx];
		idx--;
		return v;
	}

	// O(n)
	public void display() {
		for (int i = 0; i <= idx; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}