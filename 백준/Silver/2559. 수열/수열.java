import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i < K; i++) {
            dp[K - 1] += arr[i];
        }

        int answer = dp[K - 1];
        for (int i = K; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i] - arr[i - K];
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}