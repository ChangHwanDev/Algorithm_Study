package Datastructure;

import java.util.Scanner;

public class ArrayEqual {

	static boolean equals(int[] a, int[] b) {
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;

		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열 a의 요솟수");
		int na = sc.nextInt();
		
		int[] a = new int[na];
		
		for (int i = 0; i< na; i++) {
			System.out.println("a[" + i + "] : ");
			a[i] = sc.nextInt();
		}
		System.out.println("배열 b의 요솟수");
int nb = sc.nextInt();
		
		int[] b = new int[na];
		
		for (int i = 0; i< nb; i++) {
			System.out.println("b[" + i + "] : ");
			b[i] = sc.nextInt();
		}
		System.out.println("배열 a와 b는"+(equals(a,b) ? "same" : "different"));
	}
}
