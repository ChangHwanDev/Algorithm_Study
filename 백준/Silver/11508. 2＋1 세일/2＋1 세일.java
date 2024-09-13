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
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr, Collections.reverseOrder());

        int answer = 0;
        int count = 1;
        for (Integer i : arr) {
            if(count == 3){
                count = 1;
                continue;
            } else {
                answer += i;
                count++;
            }
        }

        System.out.println(answer);
    }
}