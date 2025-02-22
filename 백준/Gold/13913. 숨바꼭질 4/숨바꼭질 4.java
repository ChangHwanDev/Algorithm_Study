import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] visited = new int[100001];
    private static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N, K);
        System.out.println(visited[K] - 1);

        Stack<Integer> stack = new Stack<>();
        int idx = K;
        while (idx != N) {
            stack.push(idx);
            idx = parent[idx];
        }
        stack.push(idx);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                visited[now + 1] = visited[now] + 1;
                parent[now + 1] = now;
                q.offer(now + 1);
            }
            if (now - 1 >= 0 && visited[now - 1] == 0) {
                visited[now - 1] = visited[now] + 1;
                parent[now - 1] = now;
                q.offer(now - 1);
            }
            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                visited[now * 2] = visited[now] + 1;
                parent[now * 2] = now;
                q.offer(now * 2);
            }

            if (visited[end] != 0) return;
        }
    }
}