import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        dist = new int[n + 1][n + 1];

        for(int i = 1; i< n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++) {
                int cost = Integer.parseInt(st.nextToken());
                dist[i][j] = cost;
            }
        }

        floydWarshall();

        for(int i = 1; i< n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
    }
}