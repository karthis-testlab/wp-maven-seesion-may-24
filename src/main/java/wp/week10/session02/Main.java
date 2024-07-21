package wp.week10.session02;

public class Main {

	public static void main(String[] args) {
		
		Cat persianCat = new Cat();
		
		persianCat.name = "Pussy";
		persianCat.display();
		
		persianCat.eat();
		persianCat.sleep();
		
		Animal animal = new Animal();
		animal.eat();

	}

}
