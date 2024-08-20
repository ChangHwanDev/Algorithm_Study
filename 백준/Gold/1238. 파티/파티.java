import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, destination;
    static final int min = Integer.MIN_VALUE;
    static final int INF = 1000000;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, v));
        }
        int result = min;
        for(int i = 1; i <= n; i++){
            int duration = dijkstra(i, destination) + dijkstra(destination, i);
            if(duration > result) result = duration;
        }

        System.out.println(result);
    }
    static class Node implements Comparable<Node> {
        int index;
        int v;

        public Node(int index, int v) {
            this.index = index;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.v - o.v;
        }
    }
    static int dijkstra(int start, int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int now = cur.index;
            if(check[now]) continue;

            check[now] = true;

            for(Node next : graph[now]){
                if(dist[next.index] > dist[now] + next.v){
                    dist[next.index] = dist[now] + next.v;
                    queue.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[end];
    }
}
