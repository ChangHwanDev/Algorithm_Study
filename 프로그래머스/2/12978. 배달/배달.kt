import java.util.*

class Solution {
    class Node (val v: Int, val w: Int) : Comparable<Node> {

        override fun compareTo(other: Node): Int {
            return this.w - other.w
        }
    }
        
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0
        val graph: Array<MutableList<Node>> = Array(N + 1) { mutableListOf<Node>() }
       
        for (i in road.indices) {
            val from = road[i][0]
            val to = road[i][1]
            val weight = road[i][2]

            graph[from].add(Node(to, weight))
            graph[to].add(Node(from, weight))
        }

        val pq = PriorityQueue<Node>()
        pq.offer(Node(1, 0));
        val visited = BooleanArray(N + 1)
        val dist = IntArray(N + 1) { Int.MAX_VALUE }
        dist[1] = 0

        while (!pq.isEmpty()) {
            val node = pq.poll()

            if (!visited[node.v]) {
                visited[node.v] = true

                for (next in graph[node.v]) {
                    if (dist[next.v] > dist[node.v] + next.w){
                        dist[next.v] = dist[node.v] + next.w
                        pq.offer(Node(next.v, dist[next.v]))
                    }
                }
            }
        }

        for (value in dist) {
            if (value <= k) {
                answer++
            }
        }
        return answer
    }
}