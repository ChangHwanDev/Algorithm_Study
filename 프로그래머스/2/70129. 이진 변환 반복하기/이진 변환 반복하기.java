import java.util.Arrays;
class Solution {
    public int[] solution(String s) {
            int changeCount = 0;
            int zeroCount = 0;

            while (!s.equals("1")) {
                int originalLength = s.length();
                s = s.replace("0", "");
                int newLength = s.length();
                zeroCount += (originalLength - newLength);

                s = Integer.toBinaryString(newLength);
                changeCount++;
            }

            return new int[] {changeCount, zeroCount};
    }
}