import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // roads
        int m = Integer.parseInt(st.nextToken()); // road length

        List<List<Node>> roads = new ArrayList<>();

        for (int i = 0; i <= 10001; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (to <= m)
                roads.get(from).add(new Node(to, cost));
        }

        int result = distrait(roads, m);
        System.out.println(result);
    }

    public static int distrait(List<List<Node>> roads, int goal) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[goal + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cost = cur.cost;
            int index = cur.index;

            if (cost > dist[index]) continue;

            if (index + 1 <= goal && dist[index + 1] > cost + 1) {
                dist[index + 1] = cost + 1;
                pq.offer(new Node(index + 1, cost + 1));
            }

            for (Node next : roads.get(index)) {
                if (cost + next.cost < dist[next.index]) {
                    dist[next.index] = cost + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[goal];
    }
}