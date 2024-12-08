import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int maxValue = 0;
            long profit = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (prices[i] > maxValue) {
                    maxValue = prices[i];
                } else {
                    profit += maxValue - prices[i];
                }
            }

            sb.append(profit).append('\n');
        }

        System.out.println(sb.toString());
    }
}