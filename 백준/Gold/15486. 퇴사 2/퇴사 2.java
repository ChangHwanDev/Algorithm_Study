import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,max;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        max = 0;

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            dp[i] = Math.max(dp[i-1], dp[i]);

            int next = i + time -1;
            if(next <= n) {
                dp[next] = Math.max(dp[next], dp[i - 1] + price);
                max = Math.max(max, dp[next]);
            }
        }

        System.out.println(max);
    }
}