import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_009;
    static final int MAX = 1000;
    static long[][] dp = new long[MAX + 1][MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        fillDpArray();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(dp[n][m]);
        }
    }

    static void fillDpArray() {
        dp[0][0] = 1;

        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                dp[i][j] = dp[i - 1][j - 1] % MOD;
                if (i >= 2) dp[i][j] = (dp[i][j] + dp[i - 2][j - 1]) % MOD;
                if (i >= 3) dp[i][j] = (dp[i][j] +dp[i - 3][j - 1]) % MOD;
            }
        }
    }
}