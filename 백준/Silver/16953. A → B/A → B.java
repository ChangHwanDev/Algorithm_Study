import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[m + 1];
        dfs(n, 1);
        long answer = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(answer);
    }

    static void dfs(long v, long level) {
        if (v > m) return;
        if (v == m) {
            if (min > level) {min = level;}
            return;
        }
        if(v * 10 + 1 <= m) dfs(v * 10 + 1, level + 1);
        if(v * 2 <= m) dfs(v * 2, level + 1);
    }
}