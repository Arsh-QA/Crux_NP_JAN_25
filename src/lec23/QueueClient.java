package lec23;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		Queue q = new Queue();
		q.Enqueue(10);
		q.Enqueue(20);
		q.Enqueue(30);
		q.Enqueue(40);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.Enqueue(50);
		q.Enqueue(60);
		q.display();
	}
}