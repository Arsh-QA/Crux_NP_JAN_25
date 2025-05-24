package lec25;

import lec23.Queue;

public class DynamicQueue extends Queue {

	@Override
	public void Enqueue(int item) throws Exception {
		if (isFull()) {
			int[] newArr = new int[2 * arr.length];
			for (int i = 0; i < arr.length; i++) {
				int idx = (front + i) % arr.length;
				newArr[i] = arr[idx];
			}
			arr = newArr;
			front = 0;
		}
		super.Enqueue(item);
	}
}