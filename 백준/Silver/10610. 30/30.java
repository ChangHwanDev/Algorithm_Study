import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        char[] digits = N.toCharArray();
        boolean hasZero = false;
        int sum = 0;
        for (char digit : digits) {
            int tmp = digit - '0';
            sum += tmp;
            if (tmp == 0) hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) System.out.println("-1");
        else {
            Arrays.sort(digits);
            StringBuilder sb = new StringBuilder(new String(digits));
            System.out.println(sb.reverse().toString());
        }
    }
}