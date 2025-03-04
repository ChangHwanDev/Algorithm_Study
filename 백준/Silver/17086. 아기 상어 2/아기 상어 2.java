import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        System.out.println(bfs(q));
    }

    public static int bfs(Queue<int[]> q) {
        int max = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[curX][curY] + 1;
                    max = Math.max(max, dist[nx][ny]);
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return max;
    }
}