import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                int temp = 0;
                for (int k = j; k < 10; k++) {
                    temp += dp[i - 1][k];
                }
                dp[i][j] = temp % MOD;
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N - 1][i];
        }

        System.out.println(answer % MOD);
    }
}
