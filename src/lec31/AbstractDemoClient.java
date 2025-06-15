package lec31;

public class AbstractDemoClient {

	public static void main(String[] args) {
		AbstractDemoChild ab1 = new AbstractDemoChild();
		ab1.fun1();
		System.out.println(ab1.fun2());
		System.out.println(ab1.fun3());
		System.out.println(ab1.viewBal());
		AbstractDemo ab = new AbstractDemo() {// from java 8
			@Override
			public void fun1() {
				// TODO Auto-generated method stub

			}

			@Override
			public int fun2() {
				// TODO Auto-generated method stub
				return 0;
			}
		};

	}
}