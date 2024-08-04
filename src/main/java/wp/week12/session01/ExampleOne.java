package wp.week12.session01;

import wp.week12.session02.AccessModifierExample;
import wp.week12.session02.Main;

public class ExampleOne extends AccessModifierExample{

	void display() {
		System.out.println(c);
	}
	
	public static final String name = "Karthikeyan";
	public static int age = 31;
	
	public static void main(String[] args) {
		Main main = new Main(10);
		main.display();
		Main main2 = new Main(200);
		main2.display();
		age += 1;
		System.out.println(age);
		System.out.println(name);
	}

}
