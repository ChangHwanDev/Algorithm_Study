import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int low = 0;
        int high = max;
        long result = 0;

        while(low <= high) {
            int mid = (low + high) / 2;
            long treeLength = 0;

            for (int i = 0; i < n; i++) {
                if(arr[i] > mid)
                    treeLength += arr[i] - mid;
            }

            if(treeLength >= m) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(result);
    }
}
