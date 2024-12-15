import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Character[] vowels = {'a', 'e', 'i', 'o', 'u'};


        while (true) {
            String word = br.readLine();
            if (word.equals("end")) break;

            int vowelCount = 0;
            int consonantCount = 0;
            boolean hasVowel = false;
            boolean isAcceptable = true;
            char previousChar = 'A';

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Arrays.stream(vowels).anyMatch(v -> v == c)) {
                    hasVowel = true;
                    vowelCount++;
                    consonantCount = 0;
                } else {
                    consonantCount++;
                    vowelCount = 0;
                }

                if (c == previousChar && previousChar !=  'e' && previousChar != 'o') {
                    isAcceptable = false;
                    break;
                }

                if (consonantCount == 3 || vowelCount == 3) {
                    isAcceptable = false;
                    break;
                }

                previousChar = c;
            }

            if (!hasVowel) isAcceptable = false;

            sb.append("<").append(word).append("> is ");
            if (isAcceptable) {
                sb.append("acceptable.\n");
            } else {
                sb.append("not acceptable.\n");
            }
        }

        System.out.println(sb);
    }
}