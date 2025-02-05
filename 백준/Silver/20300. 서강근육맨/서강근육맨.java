import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(findMaxLoss(N, arr));
    }

    public static long findMaxLoss(int N, long[] arr) {
        Arrays.sort(arr);
        long maxLoss  = Integer.MIN_VALUE;

        if (N % 2 == 1) {
            maxLoss = arr[N - 1];
            N--;
        }

        for (int i = 0; i < N / 2; i++) {
            maxLoss = Math.max(maxLoss, arr[i] + arr[N - 1 - i]);
        }

        return maxLoss;
    }
}
