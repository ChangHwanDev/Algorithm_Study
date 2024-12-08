import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0; // 홀수 SK,  짝수 CY

        while (n > 0) {
            if (n >= 3) {
                n -= 3;
                count++;
            } else {
                n -= 1;
                count++;
            }
        }

        System.out.println(count % 2 == 0 ? "CY" : "SK");
    }
}
