import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(pow(n, m));
    }

    static long pow(int a, int exponent){
        if(exponent == 1){
            return a % k;
        }

        long temp = pow(a, exponent / 2);
        if (exponent % 2 == 1) {
            return temp * temp % k * a % k;
        }

        return temp * temp % k;
    }
}