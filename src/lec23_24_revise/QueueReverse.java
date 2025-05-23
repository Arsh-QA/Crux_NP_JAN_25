package lec23_24_revise;

import lec23.Queue;

public class QueueReverse {

	public static void main(String[] args) throws Exception {
		Queue q = new Queue();
		q.Enqueue(10);
		q.Enqueue(20);
		q.Enqueue(30);
		q.Enqueue(40);
		q.Enqueue(50);
		q.display();
		reverse(q);
		q.display();
	}

	private static void reverse(Queue q) throws Exception {
		if (q.isEmpty())
			return;
		int x = q.dequeue();
		reverse(q);
		q.Enqueue(x);
	}
}