import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // memo
        int m = Integer.parseInt(st.nextToken()); // blog

        HashSet<String> keywords = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keywords.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(",");

            for (String str : s) {
                keywords.remove(str);
            }
            sb.append(keywords.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
}