package baekjoon;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Count C = new Count();
		Scanner in = new Scanner(System.in);
		System.out.print("후보의 수와, 한줄에 한명씩 후보자 이름을 입력해주세요. (후보 수<=20, 후보 명 글자<=80):");
		int n = in.nextInt(), i, j, vn, win, VN = 1000;
		String[] can = new String[n + 1]; // can[n]:candidate 후보자이름
		for (i = 0; i < n + 1; i++) {
			can[i] = in.nextLine();
			System.out.println(i+""+can[i]);
			while (can[i].length() > 80) {
				System.out.println("후보 명은 80글자 이하. 다시입력해주세요");
				can[i] = in.nextLine();
			}
		} // 후보자등록. 후보번호:1~n (0은 카운트안함)
		int[] turnout = new int[n + 1]; // 집계 turnout[후보번호]:후보의 득표수
		do {
			for (i = 0; i <= n; i++)
				turnout[i] = 0;
			System.out.print("\n후보 " + n + "명, ");
			for (i = 1; i < n + 1; i++)
				System.out.print((i) + ")" + can[i] + " ");
			System.out.println("\n투표해주세요. 모든 유권자가 투표한 후에는 0을 입력해주세요.(유권자<=1000명) ");
			int[][] vote = new int[VN][n];
			Vote: /* 투표실시 */ // 유권자번호: 0~vn-1 (vn명)
			for (i = 0; i < VN; i++)
				for (j = 0; j < n; j++) {
					vote[i][j] = in.nextInt();
					if (vote[i][j] == 0)
						break Vote;
				}
			vn = i + 1;
			for (i = 0; i < vn; i++)
				turnout[vote[i][0]]++; /* 집계 */

			do {
				C.P(turnout); // 집계 과정을 보지 않으려면 이 C.P 출력함수를 삭제하세요.
				win = C.whowin(turnout);
				if (win > 0) {
					System.out.println("\nWinner: " + win + ")" + can[win]);
					break;
				} // 50%이상 득표자 1명 당선
				else if (win == -1) {
					System.out.println("탈락후보 외에 모두 동일득표");
					break;
				} else
					C.drop_recount(turnout, vote);
			} while (win == 0); // win>0:50%이상득표자1명 후보번호, win=0:최다득표자 다수, win=-1:탈락자외 전부동일득표
			System.out.print("\n 다시 투표하시려면 숫자 1을 입력해주세요.(그 외 숫자를 입력하시면 프로그램 종료.)");
		} while (in.nextInt() == 1);
	}
}

class Count {
	int i, j;

	int whowin(int[] t) { // 리턴값:50%이상득표자 1명의 후보번호. 0→최다득표자 다수일 경우, -1→탈락자 외 모두 동일득표
		int n = t.length - 1, max = 0, max_n = 0, win = 0;
		float h50 = (float) n / 2;
		for (i = 1; i <= n; i++)
			if (t[i] > max) {
				max = t[i];
				win = i;
			} // 최다득표수 max 구하기
		if (max > h50)
			return win;
		else if (max == h50) { // t[n+1]={0,50%,50%,0,0,0,...}일 경우→리턴값 -1(탈락자외 모두 동일득표)
			for (i = 1; i <= n; i++) {
				if (t[i] != 0 && t[i] != max)
					break;
				if (t[i] != 0 && t[i] == h50)
					max_n++;
			}
			if (max_n > 1)
				win = -1;
			return -1;
		} else {
			for (i = 1; i <= n; i++)
				if (t[i] != 0 && t[i] != max)
					break;
			if (i == n + 1)
				return -1;
			else
				return 0;
		}
	}

	void drop_recount(int[] t, int[][] vote) { // 탈락자 가려내고 다시 집계하는 함수
		int min = 0, n = t.length - 1, vn = vote.length, ii;
		for (i = 1; i <= n; i++)
			if (t[i] != 0) {
				min = t[i];
				break;
			}
		for (++i; i <= n; i++)
			if (t[i] != 0 && t[i] < min)
				min = t[i]; // 0이 아닌 최저득표수를 구함

		for (i = 1; i <= n; i++)
			if (t[i] == min)
				t[i] = 0; // 최저득표한 후보 득표수를 0으로 처리

		for (i = 0; i < vn; i++) {
			if (t[vote[i][0]] == 0) { // 최저득표자(탈락자)에게 첫번째로 투표한 유권자는,
				for (j = 1; j < n; j++) {
					if (t[vote[i][j]] != 0) {
						vote[i][0] = vote[i][j];
						t[vote[i][0]]++;
						break;
					}
				} // 남아있는 후보들 중 그 유권자가 가장 큰 선호도를 보이는 후보를 알아내서,
			} // 그 유권자의 첫번째 투표후보를 그 후보로 처리하고, 그 후보의 득표율을 1 증가시킨다.
		}
	}

	void P(int[] t) { // Count 과정 출력함수
		int n = t.length - 1;
		System.out.print("\n Count: ");
		for (i = 1; i <= n; i++) {
			System.out.print(i + ")" + ((t[i] == 0) ? "_" : t[i]) + " ");
		}
	}
}