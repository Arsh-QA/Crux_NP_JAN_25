package lec23;

import java.util.Queue;

public class StackClient {
	public static void main(String[] args) throws Exception {
		Stack st = new Stack();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.display();
//		st.push(60);
		System.out.println(st.peek());
		st.pop();
		st.display();
		System.out.println(st.size());
		st.pop();
		st.display();
		System.out.println(st.size());
		st.pop();
		st.display();
		System.out.println(st.size());
		st.pop();
		st.display();
		System.out.println(st.size());
		st.pop();
		st.display();
		System.out.println(st.size());
		st.pop();
//		st.peek();
	}
}
