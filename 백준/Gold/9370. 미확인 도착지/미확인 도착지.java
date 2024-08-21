import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, n, m, t, s, g, h;
    static final int INF = 10000000;
    static List<Node>[] graph;
    private static int dist[];
    private static List<Integer> candidate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            Arrays.fill(dist, INF);

            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());


            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if ((x == g && y == h) || (x == h && y == g)) {
                    graph[x].add(new Node(y, v * 2 - 1));
                    graph[y].add(new Node(x, v * 2 - 1));
                }
                graph[x].add(new Node(y, v * 2));
                graph[y].add(new Node(x, v * 2));
            }

            candidate = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                candidate.add(Integer.parseInt(br.readLine()));
            }

            dijkstra(s);
            Collections.sort(candidate);
            for (int num : candidate) {
                if (dist[num] % 2 == 1) sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
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
    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        dist[start] = 0;
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int now = cur.index;

            if(visited[cur.index]) continue;
            visited[cur.index] = true;
            
            for(Node next : graph[now]){
                if(!visited[next.index] && dist[next.index] > dist[now] + next.v){
                    dist[next.index] = dist[now] + next.v;
                    queue.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}
