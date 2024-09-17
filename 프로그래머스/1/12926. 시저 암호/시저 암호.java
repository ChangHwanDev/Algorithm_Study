class Solution {
    public String solution(String s, int n) {
            char[] chars = s.toCharArray();
            char[] answer = new char[s.length()];

            for (int i = 0; i < chars.length; i++) {
                if(chars[i] != ' '){
                    if (Character.isLowerCase(chars[i])) {
                        answer[i] = (char) ((chars[i] + n > 'z') ? (chars[i] + n - 26) : (chars[i] + n));
                    } else if (Character.isUpperCase(chars[i])) { 
                        answer[i] = (char) ((chars[i] + n > 'Z') ? (chars[i] + n - 26) : (chars[i] + n));
                    }
                } else {
                    answer[i] = ' ';
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : answer) {
                sb.append(c);
            }
            return sb.toString();
    }
}