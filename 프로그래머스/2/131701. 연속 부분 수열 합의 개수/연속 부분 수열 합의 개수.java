import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sumSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            
            for (int j = 0; j < n; j++) {
                currentSum += elements[(i + j) % n];
                sumSet.add(currentSum);
            }
        }
        
        return sumSet.size();
    }
}