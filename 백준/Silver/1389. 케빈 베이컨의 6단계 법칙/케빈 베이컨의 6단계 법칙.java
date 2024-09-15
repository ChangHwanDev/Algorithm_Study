import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = 0;
        for(int i = 1; i <= n; i ++){
            int count = bfs(i);
            if(count < min){
                min = count;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited = new boolean[n+1];
        visited[start] = true;
        int[] dist = new int[n+1];
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
        int sum = 0;
        for (int i : dist) {
            sum += i;
        }
        return sum;
    }
}