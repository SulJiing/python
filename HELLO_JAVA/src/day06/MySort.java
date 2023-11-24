package day06;

public class MySort {
	public static void main(String[] args) {
		int[] arr = {
				6,5,4,3,2,1
		};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int a = arr[i];
				int b = arr[j];
					if(a<b) {
						arr[i]=b;
						arr[j]=a;
				}
			}
		}
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		System.out.println(arr[5]);
	}
}