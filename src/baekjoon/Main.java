package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int city = Integer.parseInt(in.nextLine());
		long[] leng = new long[city - 1];
		long[] price = new long[city];
		long sum = 0;

		for (int i = 0; i < leng.length; i++) {
			leng[i] = in.nextLong();
		}

		for (int i = 0; i < price.length; i++) {
			price[i] = in.nextLong();
		}
		long min = price[0];

		for (int i = 0; i < price.length - 1; i++) {
			if (min > price[i])
				min = price[i];
			sum += (min * leng[i]);
		}
		System.out.println(sum);
	}
}