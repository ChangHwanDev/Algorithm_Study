import java.io.*;
import java.util.*;

public class Main {
    static int[] l_dp;
    static int[] r_dp;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        l_dp = new int[N];
        r_dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (answer < l_dp[i] + r_dp[i]) {
                answer = l_dp[i] + r_dp[i];
            };
        }

        System.out.println(answer - 1);
    }

    static void LIS() {
        l_dp[0] = 1;
        for (int i = 1; i < N; i++) {
            l_dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    l_dp[i] = Math.max(l_dp[i], l_dp[j] + 1);
                }
            }
        }
    }

    static void LDS() {
        for (int i = N - 1; i >= 0; i--) {
            r_dp[i] = 1;
            for (int j = N - 1; j >= i; j--) {
                if (arr[i] > arr[j]) {
                    r_dp[i] = Math.max(r_dp[i], r_dp[j] + 1);
                }
            }
        }
    }
}