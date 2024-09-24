import java.util.*
class Solution {
    companion object {
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)
        lateinit var board: MutableList<MutableList<Char>>
        lateinit var visited: Array<BooleanArray>
    }
    fun solution(maps: Array<String>): IntArray {
        board = MutableList(maps.size) { ArrayList() }
        visited =  Array(maps.size) { BooleanArray(maps[0].length) }
        val answer : ArrayList<Int> = ArrayList()

        for (i in maps.indices) {
            val temp: CharArray = maps[i].toCharArray()
            for (j in temp.indices) {
                board[i].add(temp[j])
            }
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] != 'X' && !visited[i][j]) {
                    visited[i][j] = true
                    answer.add(bfs(i, j))
                }
            }
        }
        if (answer.isEmpty()) answer.add(-1)
        answer.sort()
        return answer.toIntArray()
    }

    fun bfs(x: Int, y: Int): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(Pair(x, y))
        visited[x][y] = true
        var totalSum = board[x][y].toString().toInt()

        while (queue.isNotEmpty()) {
            val (curX, curY) = queue.poll()

            for (i in 0..3) {
                val nx = curX + dx[i]
                val ny = curY + dy[i]

                if (nx >= 0 && nx < board.size && ny >= 0 && ny < board[0].size &&
                    board[nx][ny] != 'X' && !visited[nx][ny]) {

                    visited[nx][ny] = true
                    totalSum += board[nx][ny].toString().toInt()
                    queue.offer(Pair(nx, ny))
                }
            }
        }

        return totalSum
    }
}