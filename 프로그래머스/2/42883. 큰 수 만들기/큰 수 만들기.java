class Solution {
    public String solution(String number, int k) {
            char[] c = number.toCharArray();

            int start =0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c.length - k; i++) {
                char max = '0';
                for (int j = start; j <= i + k; j++){
                    if (c[j] > max ){
                        max = c[j];
                        start = j + 1;
                    }
                }

                sb.append(Character.toString(max));
            }
            return sb.toString();
    }
}