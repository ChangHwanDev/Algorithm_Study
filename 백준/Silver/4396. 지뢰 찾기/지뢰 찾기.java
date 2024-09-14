import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[][] bomb = new String[n][n];
        String[][] game = new String[n][n];
        String[][] answer = new String[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                bomb[i][j] = String.valueOf(line.charAt(j));
            }
        }
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                game[i][j] = String.valueOf(line.charAt(j));
                answer[i][j] = ".";
            }
        }

        boolean isOver = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bomb[i][j].equals("*" ) && game[i][j].equals("x")) {
                    isOver = true;
                } else if(game[i][j].equals("x")){
                    if(answer[i][j].equals(".")) answer[i][j] = "0";
                    // 위
                    if(i > 0 && bomb[i-1][j].equals("*")){
                        answer[i][j] = String.valueOf(Integer.parseInt(answer[i][j]) + 1);
                    }
                    // 오른쪽 위 대각선
                    if(i > 0 && j < n -1 && bomb[i - 1][j + 1].equals("*")){
                        answer[i][j] = String.valueOf(Integer.parseInt(answer[i][j]) + 1);
                    }
                    // 오른쪽
                    if(j < n -1 && bomb[i][j+1].equals("*")){
                        answer[i][j] = String.valueOf(Integer.parseInt(answer[i][j]) + 1);
                    }
                    // 오른쪽 아래 대각선
                    if(i < n -1 && j < n -1 && bomb[i + 1][j+1].equals("*")){
                        answer[i][j] = String.valueOf(Integer.parseInt(answer[i][j]) + 1);
                    }
                    // 아래
                    if(i < n -1 && bomb[i+1][j].equals("*")){
                        answer[i][j] = String.valueOf(Integer.parseInt(answer[i][j]) + 1);
                    }
                    // 왼쪽 아래 대각선
                    if(i < n -1 && j > 0 && bomb[i + 1][j-1].equals("*")){
                        answer[i][j] = String.valueOf(Integer.parseInt(answer[i][j]) + 1);
                    }
                    // 왼쪽
                    if(j > 0 && bomb[i][j-1].equals("*")){
                        answer[i][j] = String.valueOf(Integer.parseInt(answer[i][j]) + 1);
                    }
                    // 왼쪽 위 대각선
                    if(i > 0 && j > 0 && bomb[i - 1][j - 1].equals("*")){
                        answer[i][j] = String.valueOf(Integer.parseInt(answer[i][j]) + 1);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isOver && bomb[i][j].equals("*")){
                    answer[i][j] = "*";
                }
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}