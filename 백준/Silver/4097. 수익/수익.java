import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int max = Integer.MIN_VALUE;
            int currentMax = 0;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                currentMax = Math.max(currentMax + num, num);
                max = Math.max(max, currentMax);
            }

            System.out.println(max);
        }
    }
}