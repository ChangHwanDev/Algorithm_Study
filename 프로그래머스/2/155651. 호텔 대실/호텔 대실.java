import java.util.*;

class Solution {
        public int solution(String[][] book_time)  {
                      Arrays.sort(book_time, (o1, o2) -> {
                if(o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            });

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(0);
            for (int i = 0; i < book_time.length; i++) {
                int start = toMinutes(book_time[i][0]);
                int end = toMinutes(book_time[i][1]) + 10;

                if (!pq.isEmpty() && start >= pq.peek()) {
                    pq.poll();
                }
                pq.offer(end);
            }
            return pq.size();
        }
    public static int toMinutes(String time) {
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);
            return hour * 60 + min;
        }
}