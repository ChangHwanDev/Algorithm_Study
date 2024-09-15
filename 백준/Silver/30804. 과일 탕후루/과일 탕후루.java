import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        n = Integer.parseInt(st.nextToken());
        int[] fruits = new int[n];
        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        int maxLength = 0;
        int left = 0;
        int right = 0;

        while(right < n){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            if(map.size() > 2){
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        System.out.println(maxLength);
    }
}