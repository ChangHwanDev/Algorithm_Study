import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K, count = 0;
    static StringBuilder result = new StringBuilder();
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dfs(0, "", 0);
        if (found) {
            System.out.println(result.toString());
            return;
        }

        System.out.println("-1");

    }

    public static void dfs(int sum, String expr, int depth) {
        if (found) return;

        if (sum == N)  {
            count++;
            if (count == K) {
                result.append(expr);
                found = true;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum + i > N) continue;
            String nextExpr = depth == 0 ? String.valueOf(i) : expr + "+" + i;
            dfs(sum + i, nextExpr, depth + 1);
        }
    }
}