package lec25;

import lec23.Stack;

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {
		if (isFull()) {
			int[] newArr = new int[2 * arr.length];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		super.push(item);
	}
}