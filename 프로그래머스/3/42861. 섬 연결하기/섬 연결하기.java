import java.util.*;
class Solution {
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
    public int solution(int n, int[][] costs) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            List<Node>[] graph = new List[n + 1];
            boolean[] visited = new boolean[n + 1];
            int answer = 0;

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] cost : costs) {
                int start = cost[0];
                int end = cost[1];
                int weight = cost[2];
                graph[start].add(new Node(end, weight));
                graph[end].add(new Node(start, weight));
            }

            pq.offer(new Node(1, 0));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (!visited[cur.v]) {
                    visited[cur.v] = true;

                    answer += cur.w;

                    for (Node next : graph[cur.v]) {
                        if (!visited[next.v]) {
                            pq.offer(new Node(next.v, next.w));
                        }
                    }
                }
            }
        return answer;
    }
}