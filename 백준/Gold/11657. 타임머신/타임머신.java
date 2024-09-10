import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static long[] dist;
    static ArrayList<Node> graph;
    static class Node {
        int v;
        int w;
        int cost;

        public Node(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new long[n+1];
        graph = new ArrayList<Node>();
        Arrays.fill(dist, Integer.MAX_VALUE);


        for(int i = 0; i< m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Node(v, w, cost));
        }

        bellmanFord();
    }

    public static void bellmanFord() {
        StringBuilder sb = new StringBuilder();
        dist[1] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                Node edge = graph.get(j);

                if(dist[edge.v] != Integer.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost){
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            Node edge = graph.get(i);
            if(dist[edge.v] != Integer.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost){
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            if(dist[i] != Integer.MAX_VALUE) {
                sb.append(dist[i]).append("\n");
            } else {
                sb.append(-1).append("\n");
            }

        }

        System.out.println(sb);
    }
}