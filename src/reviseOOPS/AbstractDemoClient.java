package reviseOOPS;

public class AbstractDemoClient {

	public static void main(String[] args) {
//		AbstractDemo ab = new AbstractDemo(); // Not possible to create object of abstract class because of unimplemented methods
		PaymentMethod ab = new PaymentMethod();
		ab.payment(); // Parent class unimplemented method
		ab.viewItem(); // Parent class implemented method
		ab.fun(); // Child class unimplemented method

		AbstractDemo ab1 = new AbstractDemo() {

			@Override
			public void payment() {
				// TODO Auto-generated method stub

			}

			@Override
			public int noOfItems() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
}