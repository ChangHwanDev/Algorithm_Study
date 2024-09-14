import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                if(!queue.isEmpty()){
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else {
                queue.add(num);
            }
        }
        System.out.print(sb);
    }
}