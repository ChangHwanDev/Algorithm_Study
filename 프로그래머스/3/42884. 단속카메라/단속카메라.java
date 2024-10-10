import java.util.*;
class Solution {
    public int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
            int end = routes[0][0] -1;
            for (int[] route : routes) {
                int start = route[0];
                if (start > end) {
                    answer++;
                    end = route[1];
                }
            }
        return answer;
    }
}