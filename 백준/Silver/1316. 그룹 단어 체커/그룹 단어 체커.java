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
        n = Integer.parseInt(st.nextToken());
        String[] words = new String[n];

        for(int i = 0; i < n; i++){
            words[i] = br.readLine();
        }

        int count = 0;
        char before;
        boolean[] checked;
        for(String s : words){
            checked = new boolean[150];
            before = 'A';

            for(int i =0; i < s.length(); i++){
                char temp = s.charAt(i);
                if(before != temp && !checked[temp]){
                    before = temp;
                    checked[temp] = true;
                } else if (before != temp && checked[temp]){
                    count--;
                    break;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}