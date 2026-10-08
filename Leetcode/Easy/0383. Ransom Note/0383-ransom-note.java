class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int num = map.getOrDefault(c, 0);
            map.put(c, ++num);
        }

        boolean answer = true;
        for (char c : ransomNote.toCharArray()) {
            int num = map.getOrDefault(c, 0);
            if (num <= 0) return false;

            map.put(c, --num);
        }

        return answer;
    }
}