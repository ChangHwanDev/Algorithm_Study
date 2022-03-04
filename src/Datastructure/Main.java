package Datastructure;

import java.io.*;
import java.util.*;

class Main {
	static int n; // 후보자 수
	static int v; // 전체 표 수
	static ArrayList<Candidate> cds; // 남아있는 후보들

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		v = 0;
		cds = new ArrayList<Candidate>();
		String vp = "";
		for (int i = 0; i < n; i++) {
			vp = sc.nextLine();
			cds.add(new Candidate(vp, i + 1));
		}
		while ((vp = sc.nextLine()) != null && vp.length() != 0) {
			Vote vote = new Vote();
			StringTokenizer st = new StringTokenizer(vp, " ");
			int tmp;
			while (st.hasMoreTokens()) {
				tmp = Integer.parseInt(st.nextToken());
				vote.votes.offer(tmp);
			}
			add_vote(vote);
			v++;
		}

		// '한 후보가 절반이 넘는 표를 얻거나 모든 후보가 동점'이 아닐 경우
		while (!majority() && !tie_case()) {
			// 후보 탈락 처리, 표 더해주기
			Collections.sort(cds);

		}

		// 당선자
		Iterator<Candidate> itc = cds.iterator();
		while (itc.hasNext()) {
			Candidate c = itc.next();
			System.out.println(c.name);
		}
	}

	// 투표용지를 해당 후보에 추가시킴
	static void add_vote(Vote vote) {
		int cnum = vote.votes.poll();
		Iterator<Candidate> itc = cds.iterator();
		while (itc.hasNext()) {
			Candidate c = itc.next();
			if (c.cnum == cnum) {
				c.vote.add(vote);
				break;
			}
		}
	}

	// 과반수 검사
	static boolean majority() {
		Iterator<Candidate> itc = cds.iterator();
		while (itc.hasNext()) {
			Candidate c = itc.next();
			if (c.vote.size() > v / 2) {
				cds.clear();
				cds.add(c);
				return true;
			}
		}
		return false;
	}

	// 후보의 표가 동점인지 검사
	static boolean tie_case() {
		Iterator<Candidate> itc = cds.iterator();
		Candidate c = itc.next();
		int vnum = c.vote.size();
		while (itc.hasNext()) {
			c = itc.next();
			if (c.vote.size() != vnum)
				return false;
		}

		return true;
	}
}

class Candidate implements Comparable<Candidate> {
	String name; // 이름
	int cnum; // 후보번호
	ArrayList<Vote> vote; // 가지고 있는 투표용지 수

	public Candidate(String name, int cnum) {
		this.name = name;
		this.cnum = cnum;
		vote = new ArrayList<Vote>();
	}

	public int compareTo(Candidate c) {
		return this.vote.size() < c.vote.size() ? -1 : (this.vote.size() == c.vote.size() ? 0 : 1);
	}
}

//투표용지
class Vote {
	Queue<Integer> votes;

	public Vote() {
		votes = new LinkedList<Integer>();
	}
}