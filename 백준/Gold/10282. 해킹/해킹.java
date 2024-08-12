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

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;  i < T; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int count = 0;
            int dis = 0;
            nodes = new ArrayList[n + 1];
            dist = new int[n + 1];
            for(int j = 0; j <= n; j++){
                nodes[j] = new ArrayList<>();
                dist[j] = Integer.MAX_VALUE;
            }

            for(int k = 0; k < d; k++){
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                nodes[from].add(new Node(to, weight));
            }
            dijkstra(c);
            for(int l = 0; l <= n; l++){
                if(dist[l] != Integer.MAX_VALUE){
                    count++;
                    dis = Math.max(dis, dist[l]);
                }
            }
            sb.append(count + " " + dis + "\n");
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
