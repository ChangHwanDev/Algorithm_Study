import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());

        int incLen = 1;
        int decLen = 1;
        int max = 1;

        for (int i = 1; i < N; i++) {
            int curr = Integer.parseInt(st.nextToken());

            if (curr > prev) {
                incLen++;
                decLen = 1;
            } else if (curr < prev) {
                decLen++;
                incLen = 1;
            } else {
                incLen++;
                decLen++;
            }

            max = Math.max(max, Math.max(incLen, decLen));
            prev = curr;
        }
        System.out.println(max);
    }
}