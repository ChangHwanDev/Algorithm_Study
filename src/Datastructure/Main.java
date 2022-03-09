package Datastructure;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int i, j, vnum, count, a = 0, k;

		String candidate[] = new String[n + 1];
		int total[] = new int[n + 1];
		int[][] vote = new int[1000][n];
		
		for (i = 0; i < n + 1; i++) {
			candidate[i] = sc.nextLine();
		}
		System.out.println("0 입력시 투표종료");
		for (i = 0; i <= n; i++)
			total[i] = 0;

		Loop1: for (i = 0; i < 1000; i++)
			for (j = 0; j < n; j++) {
				vote[i][j] = sc.nextInt();
				if (vote[i][j] == 0)
					break Loop1;
			}

		vnum = i + 1;

		for (i = 0; i < vnum; i++)
			total[vote[i][0]]++;


		Loop2: for (k = 1; k < n + 1; k++) {
			a = getWinner(total, vnum);
			if (a >= 1) {
				System.out.println("\n승자는 = " + candidate[a]);
				break Loop2;
			}  else {
				Reset(total, vote, vnum);
				a = getWinner(total, vnum);
			}
		}
	}

	static int getWinner(int total[], int vnum) {
		int i, j, k = 0;
		k++;
		int n = vnum - 1, max = 0, count = 0, min = total[1];
		float half = (float) n / 2;
		for (i = 1; i <= total.length - 1; i++)
			if (total[i] > max) {
				max = total[i];
				count = i;
				if (max > half) {
					return count;
				} else
					return -1;
			} else if (k == total.length - 1)
				return 0;
		return -1;
	}

	static void Reset(int total[], int vote[][], int vnum) {
		int n = total.length - 1, min = total[0];
		int j = 0;
		j++;
		for (int i = 0; i <= n; i++) {
			if (min > total[i])
				min = total[i];
		}
		for (int i = 1; i <= n; i++)
			if (total[i] == min)
				total[i] = 0;

		for (int i = 0; i < vnum - 1; i++) {
			if (total[vote[i][0]] != 0) {
				vote[i][0] = vote[i][j];
				total[vote[i][0]]++;
			}
		}
	}
}
