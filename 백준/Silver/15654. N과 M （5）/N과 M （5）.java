import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int[] arr2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        arr2 = new int[m];
        boolean[] checked = new boolean[n];

        dfs(0, checked);
        System.out.println(sb);
    }

    static void dfs(int level, boolean[] checked) {
        if (level == m){
            for (int i : arr2) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr2[level] = arr[i];
            if(!checked[i]) {
                checked[i] = true;
                dfs(level + 1, checked);
                checked[i] = false;
            }
        }
    }
}