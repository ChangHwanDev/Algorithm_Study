import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] nodes;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        nodes = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 0; i <= V; i++){
            nodes[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, weight));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);

    }

    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n){
            return this.w - n.w;
        }
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            int len = nodes[cur.v].size();
            for(int i = 0; i < len; i++){
                Node next = (Node)nodes[cur.v].get(i);

                if(dist[next.v]>cur.w + next.w){
                    dist[next.v] = cur.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
