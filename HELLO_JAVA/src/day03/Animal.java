package day03;

public class Animal {
	String name = "";
	
	public void named(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		Animal ani = new Animal();
		System.out.println("ani.name: "+ani.name);
		ani.named("멍멍이");
		System.out.println("ani.name: "+ani.name);
	}
}
