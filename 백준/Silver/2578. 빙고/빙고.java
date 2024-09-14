
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Bingo {
        int x;
        int y;

        public Bingo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] checked;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] bingo = new int[5][5];
        HashMap<Integer, Bingo> map = new HashMap<>();
        checked = new boolean[5][5];

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                bingo[i][j] = num;
                map.put(num, new Bingo(i,j));
            }
        }

        int callCount = 0;
        count = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int x = Integer.parseInt(st.nextToken());
                Bingo bingoLocation = map.get(x);
                checked[bingoLocation.x][bingoLocation.y] = true;
                callCount++;

                rCheck();
                cCheck();
                lrCheck();
                rlCheck();

                if(count >= 3) {
                    System.out.println(callCount);
                    return;
                }

                count = 0;
            }
        }
    }

    //가로 체크
    public static void rCheck() {
        for(int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if(checked[i][j])
                    zeroCount++;
            }
            if(zeroCount == 5)
                count++;
        }
    }

    // 세로 체크
    public static void cCheck() {
        for(int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if(checked[j][i])
                    zeroCount++;
            }
            if(zeroCount == 5)
                count++;
        }
    }

    // 왼쪽에서 오른쪽으로 그어지는 대각선 체크
    public static void lrCheck() {
        int zeroCount = 0;
        for(int i = 0; i < 5; i++) {
            if(checked[i][i])
                zeroCount++;
        }
        if(zeroCount == 5)
            count++;
    }

    // 오른쪽에서 왼쪽으로 그어지는 대각선 체크
    public static void rlCheck() {
        int zeroCount = 0;
        for(int i = 0; i < 5; i++) {
            if(checked[i][4-i])
                zeroCount++;
        }
        if(zeroCount == 5)
            count++;
    }
}