package baekjoon;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		String answer = "";
		String s = "3people unFollowed me";
		s.toLowerCase();
		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			answer += st.nextToken();
			if (!Character.isDigit(answer.charAt(0)))
				System.out.println(answer.charAt(0));
		}
		System.out.println(answer);
	}
}