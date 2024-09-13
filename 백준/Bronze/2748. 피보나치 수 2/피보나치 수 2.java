import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Long[] fibonacci;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        fibonacci = new Long[n+1];
        fibonacci[0] = 0L;
        fibonacci[1] = 1L;

        System.out.println(fibonacci(n));
    }

    static Long fibonacci(int num){
        if (fibonacci[num] != null) return fibonacci[num];
        else return fibonacci[num] = fibonacci(num-1) + fibonacci(num-2);
    }
}