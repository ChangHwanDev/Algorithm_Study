class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        DFS(0,0, numbers, target);
        return count;
    }
    
        public void DFS(int lv, int s, int[] arr, int target) {
        if(lv == arr.length){
            if(s == target)
                count++;
        } else {
                DFS(lv + 1, s + arr[lv], arr, target);
                DFS(lv + 1, s - arr[lv], arr, target);
        }
    }
}