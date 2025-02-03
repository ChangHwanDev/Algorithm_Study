import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1001);
        dp[1] = 0;
        for (int i = 1; i < N; i++) {
            int step = arr[i];
            for (int j = 1; j <= step; j++) {
                if (i + j <= N) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        int answer = -1;
        if (dp[N] != 1001) {
            answer = dp[N];
        }

        System.out.println(answer);
    }
}