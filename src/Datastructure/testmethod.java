package Datastructure;

import java.util.Scanner;

public class testmethod {

	static void copy(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			a[i] = b[i];
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] b = new int[sc.nextInt()];
		int[] a = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
	copy(a,b);
	for (int i = 0; i < b.length; i++) {
		System.out.print(a[i]);
	}
	}
}
