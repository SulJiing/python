package day03;

public class MyMethod01 {
	
	static int add(int a,int b) {
		return a+b;
	}
	static int minus(int a,int b) {
		return a-b;
	}
	static int multifly(int a,int b) {
		return a*b;
	}
	static int divide(int a,int b) {
		return a/b;
	}
	public static void main(String[] args) {
		int sum = add(4,2);
		int min = minus(4,2);
		int mul = multifly(4,2);
		int div = (int)divide(4,2);
		
		System.out.println("sum: "+sum);
		System.out.println("min: "+min);
		System.out.println("mul: "+mul);
		System.out.println("div: "+div);
	}
}
