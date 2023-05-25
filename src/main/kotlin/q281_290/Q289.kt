package q281_290

import __Serializer__
import testing.LeetTest

class Q289 {


    class Solution {

        // 01 = Was 0, is 1
        // 11 = Was 1, is 1
        // 10 = Was 1, is 0
        // 00 = Was 0, is 0


        companion object {
            val NEIGHBORS = arrayOf(
                Pair(-1, -1),
                Pair(0, -1),
                Pair(1, -1),
                Pair(-1, 0),
                Pair(1, 0),
                Pair(-1, 1),
                Pair(0, 1),
                Pair(1, 1)
            )

            val WAS_MASK = 0b001
            val CURRENT_MASK = 0b010
        }

        fun setAlive(mask: Int, value: Int, alive: Boolean): Int {
            if (alive) {
                return value.or(mask)
            } else {
                return value.xor(mask).and(value)
            }
        }

        fun isAlive(mask: Int, value: Int): Boolean {
            return value.and(mask) == mask
        }

        fun gameOfLife(board: Array<IntArray>) {
            val height = board.size
            if (height == 0) return
            val width = board[0].size
            if (width == 0) return



            for (y in 0 until board.size) {
                for (x in 0 until board[y].size) {
                    var liveNeighborsCount = 0
                    for (neighborPosDiff in NEIGHBORS) {
                        val neighborX = neighborPosDiff.first + x
                        val neighborY = neighborPosDiff.second + y
                        if (neighborX >= width || neighborX < 0 || neighborY >= height || neighborY < 0) {
                            continue
                        }
                        if (board[neighborY][neighborX].and(WAS_MASK) != 0) {
                            liveNeighborsCount++
                        }
                    }
                    if (isAlive(WAS_MASK, board[y][x])) {
                        if (liveNeighborsCount < 2) { // 1
                            println(" - $x/$y is now dead due to under population")
                            board[y][x] = setAlive(CURRENT_MASK, board[y][x], false)
                        } else if (liveNeighborsCount <= 3) { // 2 or 3
                            println(" - $x/$y is keep-lived as it has 2 or 3 neighbors")
                            board[y][x] = setAlive(CURRENT_MASK, board[y][x], true)
                        } else { // More than 3
                            println(" - $x/$y is now dead due to over population")
                            board[y][x] = setAlive(CURRENT_MASK, board[y][x], false)
                        }
                    } else {
                        if (liveNeighborsCount == 3) {
                            println(" - $x/$y is now alive due to having 3 neighbors")
                            board[y][x] = setAlive(CURRENT_MASK, board[y][x], true)
                        } else {
                            println(" - $x/$y is already dead, keeping it's dead state")
                            board[y][x] = setAlive(CURRENT_MASK, board[y][x], false)
                        }
                    }
                }
            }


            for (y in 0 until board.size) {
                for (x in 0 until board[y].size) {
                    if (isAlive(CURRENT_MASK, board[y][x])) {
                        board[y][x] = 1
                    } else {
                        board[y][x] = 0
                    }
                }
            }
        }
    }

}

fun main() {
    var int = 1
    int = Q289.Solution().setAlive(Q289.Solution.CURRENT_MASK, int, true)
    println(int)
    println(Q289.Solution().isAlive(Q289.Solution.CURRENT_MASK, int))

    int = 0
    int = Q289.Solution().setAlive(Q289.Solution.CURRENT_MASK, int, true)
    println(int)
    println(Q289.Solution().isAlive(Q289.Solution.CURRENT_MASK, int))

    int = 0
    int = Q289.Solution().setAlive(Q289.Solution.CURRENT_MASK, int, false)
    println(int)
    println(Q289.Solution().isAlive(Q289.Solution.CURRENT_MASK, int))
}