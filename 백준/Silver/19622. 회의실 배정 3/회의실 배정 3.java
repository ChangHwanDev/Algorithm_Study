import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] meetings = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                meetings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[] dp = new long[N];
        dp[0] = meetings[0][2];

        if (N > 1) {
            dp[1] = Math.max(dp[0], meetings[1][2]);

            for (int i = 2; i < N; i++) {
                dp[i] = Math.max(dp[i - 2] + meetings[i][2], dp[i - 1]);
            }
        }

        System.out.println(dp[N - 1]);
    }
}