class Solution { 
    static int data[] = new int [100001];
    public int solution(int n) {
        return fibonacci(n);
    }
    
    private static int fibonacci(int n) {
        if(n < 2) return n;
        if(data[n] != 0) return data[n] % 1234567; 
        return  data[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }
}