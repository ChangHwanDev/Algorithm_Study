class Solution {
    static boolean[] visited;
    static int answer;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0);
        return answer;
    }
    
    public static void dfs(int score, int[][] dungeons, int level) {
        answer = Math.max(answer, level);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= score) {
                visited[i] = true;
                dfs(score - dungeons[i][1], dungeons, level + 1);
                visited[i] = false;
            }
        }
    }
}