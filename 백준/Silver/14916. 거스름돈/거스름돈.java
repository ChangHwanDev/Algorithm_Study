import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        while(true){
            if (n % 5 == 0) {
                count += n / 5;
                System.out.println(count);
                break;
            } else{
                n -= 2;
                count++;
            }
            if (n < 0){
                System.out.println(-1);
                break;
            }
        }
    }
}