package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[n][m];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int count = 0;
		int look = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		while (true) {
			if (look != 3) {
				look = 3;
				if (x != 1) {
					x -= 1;
					count++;
				}
				if (x == 1) {
					x += 1;
					count++;
				}
			}
			if (y == 1 && x == 4)
				break;
		}

		System.out.println(count);
	}
}