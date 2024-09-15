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
        HashSet<Integer> set = new HashSet<>();

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = command.equals("all") || command.equals("empty") ? 0 : Integer.parseInt(st.nextToken());

            switch (command) {
                case "add" :
                    set.add(num);
                    break;
                case "check" :
                    if (set.contains(num)) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
                case "remove" :
                    set.remove(num);
                    break;
                case "toggle" :
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "empty" :
                    set = new HashSet<>();
                    break;
                case "all" :
                    for(int j = 1; j  <= 20; j++){
                        set.add(j);
                    }
                    break;
                default :
                    break;
            }
        }
        System.out.println(sb);
    }
}