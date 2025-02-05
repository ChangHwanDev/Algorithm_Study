import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        int result = bfs(start,end);
        System.out.println(result);
    }

    public static int bfs(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int person = cur[0];
            int distance = cur[1];

            if (person == end) {
                return distance;
            }

            for (Integer next : graph[person]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, distance + 1});
                }
            }
        }

        return -1;
    }
}