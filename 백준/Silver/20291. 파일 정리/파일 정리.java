import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> answer =new TreeMap<>();

        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String extension = br.readLine().split("\\.")[1];
            answer.put(extension, answer.getOrDefault(extension, 0) + 1);
        }

        for (String s : answer.keySet()) {
            sb.append(s).append(" ").append(answer.get(s)).append("\n");
        }

        System.out.println(sb);
    }
}