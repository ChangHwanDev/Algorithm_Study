import java.util.*;

class Solution {
    static char[][] graph = new char[3][3];
    public int solution(String[] board) {
            int oCount = 0;
            int xCount = 0;

            for (int i = 0; i < 3; i++) {
                char[] chars = board[i].toCharArray();
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = chars[j];
                    if (graph[i][j] == 'O') oCount++;
                    if (graph[i][j] == 'X') xCount++;
                }
            }

            if (xCount > oCount) return 0;
            if (oCount > xCount + 1) return 0;
        
            boolean oWin = isWinner('O');
            boolean xWin = isWinner('X');

            if (oWin && xWin) return 0;
            if (oWin && oCount != xCount + 1) return 0;
            if (xWin && oCount != xCount) return 0;

            return  1;
    }
    
    public boolean isWinner(char c) {
            for (int i = 0; i < 3; i++) {
                if (graph[i][0] == c && graph[i][1] == c && graph[i][2] == c) return true;
                if (graph[0][i] == c && graph[1][i] == c && graph[2][i] == c) return true;
            }
            if (graph[0][0] == c && graph[1][1] == c && graph[2][2] == c) return true;
            if (graph[0][2] == c && graph[1][1] == c && graph[2][0] == c) return true;
            return false;
        }
}