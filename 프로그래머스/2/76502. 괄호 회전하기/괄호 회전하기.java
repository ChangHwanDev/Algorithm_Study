import java.util.Stack;

class Solution {
    public int solution(String s) {
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                Stack<Character> stack = new Stack<>();
                String str = s.substring(i) + s.substring(0, i);
                for (int j = 0; j < str.length(); j++) {
                    char c1 = str.charAt(j);

                    if (stack.isEmpty()) {
                        stack.push(c1);
                    } else if (c1 == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (c1 == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c1 == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c1);
                    }
                }

                if (stack.isEmpty()) answer++;
            }

            return answer;
    }
}
