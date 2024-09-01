import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n+100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for(int j=customer; j<n+100; j++) {
                if (dp[j-customer] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], cost+dp[j-customer]);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=n; i<n+100; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}