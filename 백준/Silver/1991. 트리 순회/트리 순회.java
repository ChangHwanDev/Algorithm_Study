import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Character, Node> tree;

    static class Node {
        char lt;
        char rt;

        public Node(char lt, char rt) {
            this.lt = lt;
            this.rt = rt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new HashMap<Character, Node>();

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);
            tree.put(root, new Node(lt, rt));
        }

        preOrder('A');
        sb.append("\n");
        inOrder('A');
        sb.append("\n");
        postOrder('A');

        System.out.println(sb);
    }


    static void preOrder(char current) {
        if(current == '.') return;
        sb.append(current);
        preOrder(tree.get(current).lt);
        preOrder(tree.get(current).rt);
    }

    static void inOrder(char current) {
        if(current == '.') return;
        inOrder(tree.get(current).lt);
        sb.append(current);
        inOrder(tree.get(current).rt);
    }

    static void postOrder(char current) {
        if(current == '.') return;
        postOrder(tree.get(current).lt);
        postOrder(tree.get(current).rt);
        sb.append(current);
    }
}