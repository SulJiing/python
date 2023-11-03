package day03;

public class OopTest {
	public static void main(String[] args) {
		Animal ani = new Animal();
		System.out.println("name : "+ani.name);
		ani.named("멍멍이");
		System.out.println("name : "+ani.name);
		
		Human hum = new Human();
		System.out.println("name : "+hum.name);
		System.out.println("asset : "+hum.asset);
		hum.named("전청조");
		hum.goldenSpoon();
		System.out.println("name : "+hum.name);
		System.out.println("asset : "+hum.asset);
	}
}
