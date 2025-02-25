import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 9901;

    static int[] dx = {0, 0, 2, 2, -2, -2};
    static int[] dy = {-2, 2, -1, 1, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        System.out.println(bfs(r1, c1, r2, c2));
    }

    static int bfs(int r1, int c1, int r2, int c2) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        dist[r1][c1] = 0;
        q.offer(new int[]{r1, c1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0], y = cur[1];
            if (x == r2 && y == c2) {
                return dist[x][y];
            }

            for (int i = 0; i < 6; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}