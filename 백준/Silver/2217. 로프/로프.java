import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);
        int count = 1;
        for(int i = n-1; i>=0; i--){
            dp[i] = arr.get(i) * count++;
        }

        int max = 0;
        for (int i : dp) {
            if(i > max){
                max = i;
            }
        }
        System.out.println(max);
    }
}