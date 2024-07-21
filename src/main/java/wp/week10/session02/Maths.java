package wp.week10.session02;

public class Maths {
	
	public int add() {
		return 1 + 10;
	}
	
	public int add(int a) {
		return a + 10;
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public String add(String a, String b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		Maths maths = new Maths();
		System.out.println(maths.add("Karthikeyan", "Rajendran"));
	}

}