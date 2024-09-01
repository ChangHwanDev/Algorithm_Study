import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;

    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coins = new int[n];
        dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
            for(int j = coins[i]; j <= m; j++){
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        System.out.println(dp[m]);
    }
}