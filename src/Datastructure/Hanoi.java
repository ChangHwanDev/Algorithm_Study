package Datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Hanoi {
	static int count = 1;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static void move2(int no, int x, int y) {
		if (no > 1)
			move2(no - 1, x, 6 - x - y);
		sb.append(x + " " + y).append('\n');

		if (no > 1)
			move2(no - 1, 6 - x - y, y);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());
		sb.append((int)(Math.pow(2, n))-1).append('\n');
		move2(n, 1, 3);
		System.out.println(sb);
	}
}
