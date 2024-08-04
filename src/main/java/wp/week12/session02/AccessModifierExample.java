package wp.week12.session02;

public class AccessModifierExample {
	
	int a = 10;
	private int b = 15;
	protected int c = 35;
	
	void print() {
		System.out.println(b);
		System.out.println(a);
		printB();
		System.out.println(c);
	}
	
	private void printB() {
		System.out.println(b);
	}


}
