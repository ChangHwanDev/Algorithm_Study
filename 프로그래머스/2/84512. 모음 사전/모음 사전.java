class Solution {
    static int idx = 0;
    static int answer = -1;
    static String findWord;
    public int solution(String word) {
        findWord = word;
        dfs("", 0);
        return answer;
    }

    static String character[] = new String[]{"A", "E", "I", "O", "U"};
    public static void dfs(String s, int lv){
        if (answer > 0) return;
        if (s.equals(findWord)) {
            answer = idx;
        }
        idx++;
        if (lv == 5) return;

        for (int i = 0; i < character.length; i++) {
            dfs(s + character[i], lv + 1);
        }
    }
}