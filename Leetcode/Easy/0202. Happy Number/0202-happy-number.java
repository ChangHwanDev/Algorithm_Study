class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (n != 1) {
            if (set.contains(n)) return false;
            set.add(n);

            int nextNum = 0;
            while (n >= 10) {
                int temp = n % 10;
                nextNum += temp * temp;
                n =  n / 10;
            }
            
            nextNum += n * n;
            n = nextNum;
            System.out.println(n);
        }

        return true;
    }
}