import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int angle = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            int[][] copy = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    copy[j][k] = arr[j][k];
                }
            }

            solve(arr, copy, angle);
        }
    }

    private static void solve(int[][] arr, int[][] copy, int angle) {
        if(angle < 0)
            angle += 360;
        angle /= 45;

        while(angle-- > 0) {
            for (int i = 0; i < arr.length; i++) {
                copy[i][n/2] = arr[i][i];
                copy[i][i] = arr[n/2][i];
                copy[n/2][i] = arr[n-i-1][i];
                copy[n-i-1][i] = arr[n-i-1][n/2];
            }

            for(int i = 0; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    arr[i][j] = copy[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] row : arr){
            for(int num : row)
                sb.append(num).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}