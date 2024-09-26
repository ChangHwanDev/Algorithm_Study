import java.util.*;
class Solution {
        static int[] dist;
        static boolean[] visited;
        static List<Integer>[] graph;

    public int solution(int n, int[][] edge) {
            dist = new int[n + 1];
            visited = new boolean[n + 1];
            graph = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < edge.length; i++) {
                int start = edge[i][0];
                int end = edge[i][1];
                graph[start].add(end);
                graph[end].add(start);
            }

            bfs();
            int answer = 0;
            int max = Integer.MIN_VALUE;
            for (int i = dist.length - 1; i > 0; i--) {
                if (dist[i] != Integer.MAX_VALUE && dist[i] > max) {
                    max = dist[i];
                }
            }

            for (int i = 0; i < n + 1; i++) {
                if (max == dist[i]) answer++;
            }
            return answer;
    }
    public static void bfs(){
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1] = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();
                if(!visited[cur]){
                    visited[cur] = true;

                    for (int next : graph[cur]) {
                        if(dist[next] > dist[cur] + 1){
                            dist[next] = dist[cur] + 1;
                            q.add(next);
                        }
                    }
                }
            }
        }
}