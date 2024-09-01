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
        Arrays.fill(dp, 10000000);
        dp[0] = 0;

        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
            for(int j = coins[i]; j <= m; j++){
                dp[j]=Math.min(dp[j], dp[j - coins[i]]+1);
            }
        }
        int result = dp[m];
        System.out.println(result >= 10000000 ? -1 : result);
    }
}