package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[26];
		String s = sc.next();
		for (int i = 0; i < 26; i++) {
			if (65 < s.charAt(i) && s.charAt(i) < 90) {
				arr[i+65]++;
			}
		}
	}
}
