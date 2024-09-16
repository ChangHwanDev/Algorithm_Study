import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static String[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new String[n][m];
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = String.valueOf(s.charAt(j));
                if(matrix[i][j].equals("I")) {
                    start = i;
                    end = j;
                }
            }
        }

        System.out.println(bfs(start, end));
    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static String bfs(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, end});
        boolean[][] visited = new boolean[n][m];
        visited[start][end] = true;
        int count = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && !matrix[nx][ny].equals("X")) {
                    if(matrix[nx][ny].equals("P")) {
                        count++;
                    }
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return count > 0 ? String.valueOf(count) : "TT";
    }
}
