package lec25;

import lec23.Stack;

public class DynamicStackClient {

	public static void main(String[] args) throws Exception {
		DynamicStack ds = new DynamicStack();
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(150);
		ds.push(11);
		ds.push(111);
		ds.display();
	}
}