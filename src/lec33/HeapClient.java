package lec33;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapClient {
	public static void main(String[] args) {
		Heap hp = new Heap();
		hp.add(10);
		hp.add(20);
		hp.add(30);
		hp.add(5);
		hp.add(7);
		hp.add(2);
		hp.display();

		PriorityQueue<Integer> pq = new PriorityQueue<>();// min heap

		pq.add(10);
		pq.add(20);
		pq.add(30);
		pq.add(5);
		pq.add(7);
		pq.add(2);
		System.out.println(pq);

		PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());// max heap

		pqMax.add(10);
		pqMax.add(20);
		pqMax.add(30);
		pqMax.add(5);
		pqMax.add(7);
		pqMax.add(2);
		System.out.println(pqMax);

		System.out.println(pqMax.peek());
		System.out.println(pqMax.poll());
	}
}