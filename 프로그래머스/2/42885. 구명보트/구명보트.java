import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
            Arrays.sort(people);

            int answer = 0;
            int low = 0;
            int high = people.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;

                for (int i = low; i <= mid; i++) {
                    if (people[high] + people[low] <= limit){
                        low++;
                        high--;
                        answer++;
                    } else {
                        high--;
                        answer++;
                    }
                }
            }
            return answer;
    }
}