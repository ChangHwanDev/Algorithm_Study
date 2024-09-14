import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        boolean insideTag = false;
        for (int j = 0; j < s.length(); j++) {
            char current = s.charAt(j);

            if (current == '<') {
                clearStack(stack, sb);
                sb.append(current);
                insideTag = true;
            } else if (current == '>') {
                sb.append(current);
                insideTag = false;
            } else if (insideTag) {
                sb.append(current);
            } else if (current == ' ') {
                clearStack(stack, sb);
                sb.append(current);
            } else {
                stack.push(current);
            }
        }

        clearStack(stack, sb);
        System.out.println(sb.toString());
    }

    public static void clearStack(Stack<Character> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}