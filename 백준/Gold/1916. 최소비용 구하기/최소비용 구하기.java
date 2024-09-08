import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int p;
        int weight;

        public Node(int p, int weight) {
            this.p = p;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static ArrayList<Node>[] town;
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        town = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++){
            town[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            town[from].add(new Node(p,weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);
    }

    static void bfs(int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(!visited[cur.p]){
                visited[cur.p] = true;
                for(int i = 0; i < town[cur.p].size(); i++) {
                    Node next = town[cur.p].get(i);
                    if (dist[next.p] > dist[cur.p] + next.weight) {
                        dist[next.p] = dist[cur.p] + next.weight;
                        q.offer(new Node(next.p, dist[next.p]));
                    }
                }
            }
        }
        System.out.println(dist[end]);
    }
}