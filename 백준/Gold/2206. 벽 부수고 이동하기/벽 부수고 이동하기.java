import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y;
        boolean usedPass;

        public Point(int x, int y, boolean usedPass) {
            this.x = x;
            this.y = y;
            this.usedPass = usedPass;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][][] dist = new int[N][M][2];
        dist[0][0][0] = 1;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, false));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Point p = q.poll();
            int usedIndex = p.usedPass ? 1 : 0;

            if (p.x == N - 1 && p.y == M - 1) {
                System.out.println(dist[N - 1][M -1][usedIndex]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] == 0 && dist[nx][ny][usedIndex] == 0) {
                    dist[nx][ny][usedIndex] = dist[p.x][p.y][usedIndex] + 1;
                    q.offer(new Point(nx, ny, p.usedPass));
                } else if (map[nx][ny] == 1 && !p.usedPass && dist[nx][ny][1] == 0) {
                    dist[nx][ny][1] = dist[p.x][p.y][usedIndex] + 1;
                    q.offer(new Point(nx, ny, true));
                }
            }
        }

        System.out.println("-1");
    }
}