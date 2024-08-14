import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[max + 1];

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bfs(new Node(n,0));
        System.out.println(min);
    }
    static class Node implements Comparable<Node> {
        int from;
        int count;

        public Node(int from, int count) {
            this.from = from;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }
    static void bfs(Node node){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int from = cur.from;
            visited[from] = true;
            if(from == m) min = Math.min(min, cur.count);

            if(from * 2 <= max && !visited[from * 2]) {
                queue.offer(new Node(from * 2, cur.count));
            }
            if(from + 1 <= max && !visited[from + 1]) {
                queue.offer(new Node(from + 1, cur.count + 1));
            }
            if(from -1 >= 0 && !visited[from - 1]) {
                queue.offer(new Node(from- 1, cur.count + 1));
            }
        }
    }
}