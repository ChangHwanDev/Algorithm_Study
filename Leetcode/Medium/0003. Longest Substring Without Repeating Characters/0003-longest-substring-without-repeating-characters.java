class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        
        List<Character> chracters = new LinkedList<>();
        if (s.length() > 0) {
            chracters.add(s.charAt(0));
            maxLength = 1;
        }
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!chracters.contains(c)) {
                chracters.add(c);
                maxLength = Math.max(maxLength, chracters.size());
            } else {
                while (chracters.contains(c)) {
                    chracters.removeFirst();
                }
                chracters.add(c);
            }
        }

        return maxLength;
    }
}