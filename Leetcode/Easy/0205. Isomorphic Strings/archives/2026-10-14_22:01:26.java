class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (sToT.containsKey(c1)) {
                if (sToT.get(c1) != c2) {
                    return false;
                }
            } else {
                sToT.put(c1, c2);
            }

            if (tToS.containsKey(c2)) {
                if (tToS.get(c2) != c1) {
                    return false;
                }
            } else {
                tToS.put(c2, c1);
            }
        }

        return true;
    }
}