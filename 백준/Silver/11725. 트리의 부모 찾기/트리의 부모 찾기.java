import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] tree;
    static int[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        tree = new List[n + 1];
        nodes = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            sb.append(nodes[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int current) {
        visited[current] = true;

        for (int next : tree[current]) {
            if(!visited[next]) {
                nodes[next] = current;
                dfs(next);
            }
        }
    }
}