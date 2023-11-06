package day05;

public class MySplit {
	public static void main(String[] args) {
		String str = "3,4";
		
		String[] arr = str.split(",");
		
		int i = Integer.parseInt(arr[0]);
		int j = Integer.parseInt(arr[1]);
		
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
		System.out.println(i);
		System.out.println(j);
		
	}
}
