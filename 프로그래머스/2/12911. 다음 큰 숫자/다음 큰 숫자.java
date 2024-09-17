class Solution {
    public int solution(int n) {
        String binaryString = Integer.toBinaryString(n);

        int count = 0;
        for (char c : binaryString.toCharArray()) {
            if(c == '1') count++;
        }

        int tmp = n;
        while (true) {
            tmp++;
            String temp = Integer.toBinaryString(tmp);
            int tempCount = 0;
            for (char c : temp.toCharArray()) {
                if(c == '1') tempCount++;
            }
            if(tempCount == count) break;
        }
        return tmp;
    }
}