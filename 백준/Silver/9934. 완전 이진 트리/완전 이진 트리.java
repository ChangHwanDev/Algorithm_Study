import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static List<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        arr = new int[(int) Math.pow(2, n) - 1];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i< arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        search(0,arr.length - 1,0);

        for (int i=0; i< list.size(); i++){
            for(int j=0; j< list.get(i).size(); j++){
                sb.append(list.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void search(int start, int end, int depth) {
        if(depth == n) {
            return;
        }

        int mid = (start + end) / 2;

        list.get(depth).add(arr[mid]);

        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }
}