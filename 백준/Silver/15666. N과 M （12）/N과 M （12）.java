import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static ArrayList<Integer> list;
    static int[] arr2;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static HashSet<String> checkSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        Collections.sort(list);
        arr2 = new int[m];

        dfs(0,0);
        set.forEach(System.out::println);
    }

    static void dfs(int at, int level) {
        if (level == m){
            StringBuilder sb = new StringBuilder();
            for (int i : arr2) {
                sb.append(i).append(" ");
            }
            String s = sb.toString();
            set.add(s);
            return;
        }

        for (int i = at; i < list.size(); i++) {
            arr2[level] = list.get(i);
            dfs(i, level + 1);
        }
    }
}