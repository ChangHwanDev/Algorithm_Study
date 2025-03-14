import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int n) {
        int[] col = new int[n];
        backtracking(col, 0, n);
        
        return answer;
    }
    
    public void backtracking(int[] col, int row, int n) {
        if (row == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            col[row] = i;
            
            if (isValid(col, row)) {
                backtracking(col, row + 1, n);
            }
        }
    }
    
    public boolean isValid(int[] col, int row) {
        for (int i = 0; i < row; i++) {
            if (col[row] == col[i]) return false;
            if (Math.abs(col[i] - col[row]) == row -i) return false;
        }
        
        return true;
    }
    
}