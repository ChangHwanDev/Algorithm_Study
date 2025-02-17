import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static Map<Character, Point> consonant = new HashMap<>();
    static Map<Character, Point> vowels = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        initializeKeyboardLayouts();

        Character initialConsonant = st.nextToken().charAt(0);
        Character initialVowel = st.nextToken().charAt(0);

        Point currentConsonantPosition = new Point(consonant.get(initialConsonant));
        Point currentVowelPosition  = new Point(vowels.get(initialVowel));

        String answer = br.readLine();
        int totalTypingTime = calculateTypingTime(answer, currentConsonantPosition, currentVowelPosition);

        System.out.println(totalTypingTime);
    }

    private static int calculateTypingTime(String text, Point currentConsonantPosition, Point currentVowelPosition) {
        int time = 0;
        for (char character : text.toCharArray()) {
            if (consonant.containsKey(character)) {
                time += processCharacter(character, currentConsonantPosition, consonant);
            } else if (vowels.containsKey(character)) {
                time += processCharacter(character, currentVowelPosition, vowels);
            }
        }
        return time;
    }

    private static int processCharacter(char character, Point currentPosition, Map<Character, Point> layout) {
        Point targetPosition = layout.get(character);
        int timeElapsed = calculateDistance(currentPosition, targetPosition) + 1;
        currentPosition.setLocation(targetPosition);
        return timeElapsed;
    }

    private static int calculateDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private static void initializeKeyboardLayouts() {
        consonant.put('q', new Point(1, 1));
        consonant.put('w', new Point(1, 2));
        consonant.put('e', new Point(1, 3));
        consonant.put('r', new Point(1, 4));
        consonant.put('t', new Point(1, 5));
        consonant.put('a', new Point(2, 1));
        consonant.put('s', new Point(2, 2));
        consonant.put('d', new Point(2, 3));
        consonant.put('f', new Point(2, 4));
        consonant.put('g', new Point(2, 5));
        consonant.put('z', new Point(3, 1));
        consonant.put('x', new Point(3, 2));
        consonant.put('c', new Point(3, 3));
        consonant.put('v', new Point(3, 4));

        vowels.put('y', new Point(1, 6));
        vowels.put('u', new Point(1, 7));
        vowels.put('i', new Point(1, 8));
        vowels.put('o', new Point(1, 9));
        vowels.put('p', new Point(1, 10));
        vowels.put('h', new Point(2, 6));
        vowels.put('j', new Point(2, 7));
        vowels.put('k', new Point(2, 8));
        vowels.put('l', new Point(2, 9));
        vowels.put('b', new Point(3, 5));
        vowels.put('n', new Point(3, 6));
        vowels.put('m', new Point(3, 7));
    }
}