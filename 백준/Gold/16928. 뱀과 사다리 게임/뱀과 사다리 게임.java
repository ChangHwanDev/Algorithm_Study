import java.io.*;
import java.util.*;

public class Main {

    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int pos = cur[0];
            int moves = cur[1];

            if (pos == 100) return moves;

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;

                if (next > 100) continue;

                next = board[next];

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, moves + 1});
                }
            }
        }
        
        return -1;
    }
}