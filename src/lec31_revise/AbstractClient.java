package lec31_revise;

public class AbstractClient {
	public static void main(String[] args) {
//		AbstractDemo ab = new AbstractDemo();
//		PaymentMethod ab = new PaymentMethod();
//		ab.payment();
		AbstractDemo ab = new AbstractDemo() {

			@Override
			public void payment() {
				// TODO Auto-generated method stub

			}

			@Override
			public int noOfItem() {
				// TODO Auto-generated method stub
				return 0;
			}

		};

		AbstractDemo ab1 = new AbstractDemo() {

			@Override
			public void payment() {
				// TODO Auto-generated method stub

			}

			@Override
			public int noOfItem() {
				// TODO Auto-generated method stub
				return 0;
			}

		};
	}
}