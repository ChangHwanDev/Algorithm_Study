import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] smallJump = new int[n - 1];
        int[] bigJump = new int[n - 1];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            smallJump[i] = Integer.parseInt(st.nextToken());
            bigJump[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][0] + smallJump[i]);
                dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + smallJump[i]);
            }
            if (i + 2 < n) {
                dp[i + 2][0] = Math.min(dp[i + 2][0], dp[i][0] + bigJump[i]);
                dp[i + 2][1] = Math.min(dp[i + 2][1], dp[i][1] + bigJump[i]);
            }
            if (i + 3 < n) {
                dp[i + 3][1] = Math.min(dp[i + 3][1], dp[i][0] + k);
            }
        }

        System.out.println(Math.min(dp[n - 1][0], dp[n - 1][1]));
    }
}