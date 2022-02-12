package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		for(int i = 1; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		System.out.println(arr);
	}
}