import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
            int answer = 0;
            int[] fruitCount = new int[10000001];
            for (int i = 0; i < tangerine.length; i++) {
                fruitCount[tangerine[i]]++;
            }
            Arrays.sort(fruitCount);
            for (int i = fruitCount.length - 1; i >= 0; i--) {
                answer++;
                if (fruitCount[i] >= k) {
                    break;
                }
                k -= fruitCount[i];
            }
            return answer;
    }
}