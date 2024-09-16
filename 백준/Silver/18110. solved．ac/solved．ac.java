import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(score);

        int trimCount = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = trimCount; i < n - trimCount; i++) {
            sum += score[i];
        }

        int validCount = n - 2 * trimCount;
        System.out.println(Math.round((float) sum / validCount));
    }
}