import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static List<Node>[] arr;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[start].add(new Node(end, w));
            arr[end].add(new Node(start, w));
        }

        answer = 0;
        solve();

        System.out.println(answer);
    }

    public static void solve(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        int max = Integer.MIN_VALUE;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!visited[cur.v]) {
                visited[cur.v] = true;
                if(max < cur.w) max = cur.w;
                answer += cur.w;
                for(Node next : arr[cur.v]) {
                    if(!visited[next.v]) {
                        pq.offer(next);
                    }
                }
            }
        }
        answer -= max;
    }
}