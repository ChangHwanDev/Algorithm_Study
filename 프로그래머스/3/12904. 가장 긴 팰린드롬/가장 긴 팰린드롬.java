class Solution
{
    public int solution(String s)
    {
            int answer = 1;
            for (int i = 0; i < s.length(); i++) {
                int low = i, high = i;
                while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                    answer = Math.max(answer, high - low + 1);
                    low--;
                    high++;
                }
            }

            for (int i = 0; i < s.length() - 1; i++) {
                int low = i, high = i + 1;
                while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                    answer = Math.max(answer, high - low + 1);
                    low--;
                    high++;
                }
            }
        return answer;
    }
}