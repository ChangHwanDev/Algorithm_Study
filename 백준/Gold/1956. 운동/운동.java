import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V,E;
    static int[][] dist;
    static int INF = 4000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                dist[i][j] =INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        floydWarshall();


        int answer = INF * 2;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (dist[i][j] == INF || dist[j][i] == INF) continue;
                if (i == j) {
                    answer = Math.min(answer, dist[i][j]);
                } else {
                    answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
            }
        }

        System.out.println(answer == INF * 2 ? -1 : answer);
    }

    public static void floydWarshall() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
    }
}