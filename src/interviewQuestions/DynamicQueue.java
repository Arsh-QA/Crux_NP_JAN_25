package interviewQuestions;

import java.util.Iterator;

import lec23.Queue;

public class DynamicQueue extends Queue {

	@Override
	public void Enqueue(int item) throws Exception {
		if (isFull()) {
			int[] newArray = new int[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				int idx = (front + i) % arr.length;
				newArray[i] = arr[idx];
			}
			arr = newArray;
			front = 0;
		}
		super.Enqueue(item);
	}
}