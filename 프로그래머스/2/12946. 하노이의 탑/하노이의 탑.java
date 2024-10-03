class Solution {
    static int[][] answer;
    static int idx = 0;
    public int[][] solution(int n) {
            answer =new int[(int) Math.pow(2, n) - 1][2];
            hanoi(n, 1, 3, 2);
        return answer;
    }
   
    public static void hanoi(int n, int from, int to, int mid) {
        if (n == 1){
            answer[idx++] = new int[]{from, to};
        } else {
            hanoi(n-1, from, mid, to);
            answer[idx++] = new int[]{from, to};
           hanoi(n-1, mid, to, from);
        }
    }
}