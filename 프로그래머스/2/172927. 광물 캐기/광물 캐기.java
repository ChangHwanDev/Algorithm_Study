import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
                      int answer = 0;
            int pickCount = picks[0] + picks[1] + picks[2];
            int min = Math.min(minerals.length / 5 + 1, pickCount);
            int[][] mineralPoints = new int[min + 1][3];

            int count = 0;
            int[][] points = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
            for (int i = 0; i < minerals.length; i++) {
                if (count >= min) break;
                String mineral = minerals[i];
                int value = mineral.equals("diamond") ? 0 : mineral.equals("iron") ? 1 : 2;
                mineralPoints[count][0] += points[0][value];
                mineralPoints[count][1] += points[1][value];
                mineralPoints[count][2] += points[2][value];

                if ((i + 1) % 5 == 0){
                    count++;
                }
            }

            Arrays.sort(mineralPoints, (a, b) -> b[2] - a[2]);
            for (int i = 0; i < mineralPoints.length; i++){
                if(picks[0] > 0){
                    picks[0]--;
                    answer += mineralPoints[i][0];
                } else if (picks[1] > 0){
                    picks[1]--;
                    answer += mineralPoints[i][1];
                } else if (picks[2] > 0){
                    picks[2]--;
                    answer += mineralPoints[i][2];
                }
            }
        return answer;
    }
}