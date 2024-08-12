import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            map = new int[n][n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = dijkstra(new Node(0, 0, map[0][0]), map);
            sb.append("Problem ").append(idx++).append(": ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int x, y, c;

        public Node(int x, int y, int c){
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Node n){
            return this.c - n.c;
        }
    }
    static int dijkstra(Node node, int[][] map){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = node.c;
        pq.offer(node);

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;

            if(x == n - 1 && y == n - 1){
                return cur.c;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    int newCost = cur.c + map[nx][ny];

                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
}