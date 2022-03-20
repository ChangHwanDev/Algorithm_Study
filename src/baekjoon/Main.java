package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		int n = 3;
		int m = 12;
		int[] answer = new int[2];
		if (n > m) {
			if (n % m == 0) {
				answer[0] = m;
				answer[1] = n;
			} else {
				answer[0] = 1;
				answer[1] = n * m;
			}
		} else if (n < m) {
			if (m % n == 0) {
				answer[0] = n;
				answer[1] = m;
			} else {
				answer[0] = 1;
				answer[1] = n * m;
			}
		}
		for (int i = 0; i < 2; i++) {
			System.out.println(answer[i]);
		}

	}
}