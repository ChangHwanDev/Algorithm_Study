import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> charStack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                charStack.push(ch);
            } else if (ch == ')') {
                if (charStack.isEmpty()) {
                    return false;
                }
                charStack.pop();
            }
        }
        return charStack.isEmpty();
    }
}