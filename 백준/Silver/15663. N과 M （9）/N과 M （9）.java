import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static ArrayList<Integer> list;
    static int[] arr2;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
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
        boolean[] checked = new boolean[n];

        dfs(0, checked);
        set.forEach(System.out::println);
    }

    static void dfs(int level, boolean[] checked) {
        if (level == m){
            StringBuilder sb = new StringBuilder();
            for (int i : arr2) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if(checked[i])  continue;

            checked[i] = true;
            arr2[level] = list.get(i);
            dfs(level + 1, checked);
            checked[i] = false;
        }
    }
}