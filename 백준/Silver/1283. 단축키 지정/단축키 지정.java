import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Character> usedKeys = new HashSet<>();

        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean shortcutAssigned = false;

            for(int j=0; j < words.length; j++){
                char firstChar = words[j].charAt(0);
                if(!usedKeys.contains(firstChar)){
                    usedKeys.add(Character.toUpperCase(firstChar));
                    usedKeys.add(Character.toLowerCase(firstChar));
                    StringBuilder tmpSb = new StringBuilder(words[j]);
                    tmpSb.insert(0, '[');
                    tmpSb.insert(2, ']');
                    words[j] = tmpSb.toString();
                    shortcutAssigned = true;
                }
                if(shortcutAssigned) {
                    for(int k=0; k < words.length; k++){
                        if (k != 0) sb.append(" ");
                        sb.append(words[k]);
                    }
                    break;
                }
            }

            if(!shortcutAssigned){
                for(int j =0; j < line.length(); j++){
                    char c = Character.toLowerCase(line.charAt(j));
                    if(c != ' '  && !usedKeys.contains(c)){
                        usedKeys.add(Character.toUpperCase(c));
                        usedKeys.add(Character.toLowerCase(c));
                        sb.append(line.substring(0, j)).append("[").append(line.charAt(j)).append("]").append(line.substring(j + 1));
                        shortcutAssigned = true;
                        break;
                    }
                }
            }

            if (!shortcutAssigned) {
                sb.append(line);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
