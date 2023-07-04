package q901_910

import __Serializer__
import testing.LeetTest

class Q909 {

    class Solution {
        fun snakesAndLadders(board: Array<IntArray>): Int {
            val boardSize = board.size
            fun numToPos(num: Int): Pair<Int, Int> {
                val fromGround = ((num - 1) / boardSize)
                val y = boardSize - fromGround - 1
                val fromLeft = ((num - 1) % boardSize)
                val x = if (fromGround % 2 == 0) fromLeft else boardSize - fromLeft - 1
                return Pair(x, y)
            }

            val visited = HashSet<Int>()
            var queue = ArrayList<Int>()
            var nextQueue = ArrayList<Int>()
            var steps = 0
            queue.add(1)

            while (queue.isNotEmpty() || nextQueue.isNotEmpty()) {
                if (queue.isEmpty()) {
                    val tmp = nextQueue
                    nextQueue = queue
                    queue = tmp
                    steps++
                }
                val currentNumber = queue.removeAt(0)

                for (i in 1..6) {
                    val newNumber = currentNumber + i
                    val pos = numToPos(newNumber)
                    val dest = board[pos.second][pos.first]
                    if (dest != -1) {
                        if (dest in visited) continue
                        if (dest >= boardSize*boardSize) {
                            return steps + 1
                        }
                        nextQueue.add(dest)
                        visited.add(dest)
                    } else {
                        if (newNumber in visited) continue
                        if (newNumber >= boardSize*boardSize) {
                            return steps + 1
                        }
                        nextQueue.add(newNumber)
                        visited.add(newNumber)
                    }
                }
            }

            error("No answer found")
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q909.Solution::snakesAndLadders, __Serializer__::serialize, "4", "[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]")
    LeetTest.assertReturn(Q909.Solution::snakesAndLadders, __Serializer__::serialize, "1", "[[-1,-1],[-1,3]]")
}