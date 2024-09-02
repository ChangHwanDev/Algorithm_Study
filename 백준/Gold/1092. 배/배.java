import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        List<Integer> crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i =0; i < n; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i =0; i < m; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(box.get(0) > crane.get(0)){
            System.out.println(-1);
            return;
        }

        long answer = 0;
        while(!box.isEmpty()){
            int boxIndex = 0;
            int craneIndex = 0;

            while(craneIndex < n) {
                if (boxIndex >= box.size()) {
                    break;
                } else if (box.get(boxIndex) <= crane.get(craneIndex)) {
                    box.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}