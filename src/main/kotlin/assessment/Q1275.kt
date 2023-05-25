package assessment

import kotlin.math.abs

class Q1275 {

    // TODO: Why did I cheat on an assessment
    class Solution {
        fun tictactoe(moves: Array<IntArray>): String {
            val rows = IntArray(3)
            val cols = IntArray(3)
            val diagHolder = IntArray(2)
            var currentPlayer = 1
            for (move in moves) {
                val x = move[0]
                val y = move[1]

                rows[x] += currentPlayer
                cols[y] += currentPlayer

                if (x == y) diagHolder[0] += currentPlayer;
                if (x + y == 2) diagHolder[1] += currentPlayer

                if (abs(rows[x]) == 3 || abs(cols[y]) == 3 || abs(diagHolder[0]) == 3 || abs(diagHolder[1]) == 3) {
                    return if (currentPlayer == 1) "A" else "B"
                }

                currentPlayer *= -1
            }

            return if (moves.size == 9) "Draw" else "Pending"
        }
    }

}