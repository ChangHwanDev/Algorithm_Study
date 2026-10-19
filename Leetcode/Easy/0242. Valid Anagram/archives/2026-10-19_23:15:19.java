class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            int sCount = map.getOrDefault(s1, 0);
            map.put(s1, ++sCount);

            int tCount = map.getOrDefault(t1, 0);
            map.put(t1, --tCount);
        }

        for (Integer num :  map.values()) {
            if (num == null || num != 0) return false;
        }

        return true;
    }
}