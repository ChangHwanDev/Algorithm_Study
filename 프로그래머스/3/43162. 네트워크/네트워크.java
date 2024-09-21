import java.util.*;
class Solution {
    public static int find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int v1, int v2){
        int fa = find(v1);
        int fb = find(v2);
        if(fa != fb) unf[fa] = fb;
    }

    static int[] unf;

    public int solution(int n, int[][] computers) {
            unf = new int[n];
            for (int i = 0; i < n; i++) {
                unf[i] = i;
            }

            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[i].length; j++) {
                    if (i != j && computers[i][j] == 1) {
                        union(i, j);
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                if(find(i) == i) answer++;
            }
        return answer;
    }
}