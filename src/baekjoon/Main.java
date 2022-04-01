package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[][] map = new int[N][N];
		int a = 1;
		int b = 1;
		while (N-- > 0) {
			System.out.println("좌표입력");
			if (sc.nextLine().equals("R")) {
				b += 1;
				continue;
			}
			if (sc.nextLine().equals("L")) {
				if (b > 1)
					b -= 1;
				continue;
			}
			if (sc.nextLine().equals("U")) {
				if (a == 1) {
					continue;
				} else {
					a -= 1;
					continue;
				}
			}
			if (sc.nextLine().equals("D")) {
				a += 1;
				continue;
			}
		}
		System.out.println(a + "" + b);
	}
}