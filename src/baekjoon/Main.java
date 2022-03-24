package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		check = new boolean[n][m];
		check[0][0] = true;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(map[n - 1][m - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			int[] xy = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = xy[0] + dx[i];
				int nextY = xy[1] + dy[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || check[nextX][nextY] ||map[nextX][nextY] == 0)
					continue;

				q.add(new int[] { nextX, nextY });
				check[nextX][nextY] = true;

				map[nextX][nextY] = map[xy[0]][xy[1]] + 1;
			}
		}
	}
}