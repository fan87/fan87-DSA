package q121_130

class Q130 {

    // TODO: Re-do it again as I originally thought of the question in the wrong way
    class Solution {

        // O & X = From original input
        // P = Pending
        // C = Confirmed

        fun solve(board: Array<CharArray>) {
            val height = board.size
            val width = board[0].size

            fun visitBorderConnection(board: Array<CharArray>, x: Int, y: Int) {
                if (y >= height || y < 0) return
                if (x >= width || x < 0) return
                if (board[y][x] != 'O') return
                board[y][x] = 'C'
                println()
                println(board.joinToString("\n") { it.joinToString(", ") })
                println()
                visitBorderConnection(board, x, y - 1)
                visitBorderConnection(board, x, y + 1)
                visitBorderConnection(board, x - 1, y)
                visitBorderConnection(board, x + 1, y)
            }

            for (y in 0 until height) {
                visitBorderConnection(board, 0, y)
                visitBorderConnection(board, width - 1, y)
            }
            for (x in 1 until width - 1) {
                visitBorderConnection(board, x, 0)
                visitBorderConnection(board, x, height - 1)
            }
            for (y in 0 until height) {
                for (x in 0 until width) {
                    if (board[y][x] == 'C') board[y][x] = 'O' else board[y][x] = 'X'
                }
            }
        }

    }

}