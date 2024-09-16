import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long answer = 0;
        long pow = 1;
        for (int i = 0; i < n; i++) {
            answer += (s.charAt(i) - 96) * pow;
            pow = pow * 31 % 1234567891;
        }
        System.out.println(answer % 1234567891);
    }
}
