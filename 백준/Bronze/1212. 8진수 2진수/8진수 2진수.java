import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String s = st.nextToken();

        for(int i = 0; i < s.length(); i++) {
            String binaryString = Integer.toBinaryString(s.charAt(i) - '0');

            if(binaryString.length() == 1 && i != 0) {
                binaryString = "00" + binaryString;
            } else if(binaryString.length() == 2 && i != 0) {
                binaryString = "0" + binaryString;
            }
            sb.append(binaryString);
        }
        System.out.println(sb);
    }
}