class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> pToS = new HashMap<>();
        Map<String, Character> sToP = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String word = words[i];

            if (pToS.containsKey(pChar)) {
                if (!pToS.get(pChar).equals(word)) {
                    return false;
                }
            } else {
                pToS.put(pChar, word);
            }

            if (sToP.containsKey(word)) {
                if (sToP.get(word) != pChar) {
                    return false;
                }
            } else {
                sToP.put(word, pChar);
            }
        }

        return true;
    }
}