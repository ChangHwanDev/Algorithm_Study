import java.util.*;
class Solution {

    public int solution(int[][] scores) {
            int answer = 1;
            int wanhoScore1 = scores[0][0];
            int wanhoScore2 = scores[0][1];
            int wanhoTotalScore = wanhoScore1 + wanhoScore2;

            List<int []> arr = new ArrayList<>();
            for (int[] score : scores) {
                arr.add(new int[]{score[0], score[1]});
            }

            arr.sort((a,b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                else return b[0] - a[0];
            });

            int maxSecondScore = 0;
            for (int[] employee : arr) {
                int currentTotalScore = employee[0] + employee[1];
                if (employee[0] > wanhoScore1 && employee[1] > wanhoScore2) {
                    return -1;
                }
                
               if (employee[1] >= maxSecondScore) {
                    maxSecondScore = employee[1];
                    if (currentTotalScore > wanhoTotalScore) {
                        answer++;
                    }
                }
            }
        return answer;
    }
}