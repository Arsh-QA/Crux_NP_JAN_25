package interviewQuestions;

import lec23.Stack;

public class DynamicStack extends Stack {

	@Override
	public void push(int item) {
		if (isFull()) {
			int[] newArray = new int[2 * arr.length];
			for (int i = 0; i < arr.length; i++) {
				newArray[i] = arr[i];
			}

			arr = newArray;
		}
		idx++;
		arr[idx] = item;
	}
}