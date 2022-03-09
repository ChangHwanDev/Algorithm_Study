package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int i, j, vnum, count;

		String candidate[] = new String[n + 1];
		int total[] = new int[n + 1];
		int[][] vote = new int[1000][n];

		for (i = 0; i < n + 1; i++) {
			candidate[i] = sc.nextLine();
		}

		for (i = 0; i <= n; i++)
			total[i] = 0;

		// while(sc.hasnextInt()되는지)
		Loop1: for (i = 0; i < 1000; i++)
			for (j = 0; j < n; j++) {
				vote[i][j] = sc.nextInt();
				if (vote[i][j] == 0)
					break Loop1;
			}

		vnum = i + 1;

		for (i = 0; i < vnum; i++)
			total[vote[i][0]]++;

		count = getWinner(total);

		if (count > 0) {
			System.out.println(candidate[count]);
		} else
			System.out.println("동점자가 나왔습니다.");
			getWinner(total,vote);
		}

	static int getWinner(int total[]) {
		int n = total.length - 1, max = 0, count = 0;
		float half = (float) n / 2;
		for (int i = 1; i <= n; i++)
			if (total[i] > max) {
				max = total[i];
				count = i;
			}
		if (max > half)
			return count;
		else
			return -1;
	}

	static void getWinner(int total[], int vote[][]) {
		int n = total.length - 1, vnum = vote.length, min = total[1];
		int j;
		for (int i = 1; i <= n; i++) {
			if (min > total[i])
				min = total[i];
		}
		for (int i = 0; i < vnum; i++) {
			if (total[vote[i][0]] == min) {
				for(j=1;j<n;j++)
				vote[i][0] = vote[i][j];
				total[vote[i][0]]++;
			}
		}
	}
}
