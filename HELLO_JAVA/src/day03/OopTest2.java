package day03;

public class OopTest2 {
	public static void main(String[] args) {
		Animal ani = new Animal();
		System.out.println("ani.name: "+ani.name);
		ani.named("멍멍이");
		System.out.println("ani.name: "+ani.name);
	}
}