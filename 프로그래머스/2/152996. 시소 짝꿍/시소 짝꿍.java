class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] weightCounts = new int[1001];
        for (int w : weights) {
            weightCounts[w]++;
        }
        
        for (int i = 100; i <= 1000; i++) {
            if (weightCounts[i] == 0) continue;
         
            // 같은 몸무게
            if (weightCounts[i] > 1) {
                answer += (long) weightCounts[i] * (weightCounts[i] - 1) / 2;
            }
            
            // 2:3
            if (i * 2 % 3 == 0) {
                int partner = i * 2 / 3;
                if (partner <= 1000) {
                    answer += (long) weightCounts[i] * weightCounts[partner];
                }
            }
            
            // 2:4
            if (i * 2 % 4 == 0) {
                int partner = i * 2 / 4;
                if (partner <= 1000) {
                    answer += (long) weightCounts[i] * weightCounts[partner];
                }
            }
            
            // 3:4
            if (i * 3 % 4 == 0) {
                int partner = i * 3 / 4;
                if (partner <= 1000) {
                    answer += (long) weightCounts[i] * weightCounts[partner];
                }
            }
            
            
        }
        return answer;
    }
}