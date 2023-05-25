package Q31_40

// Bro, a sudoku solver, are you fucking serious?
class Q37 {
    class Solution {
        fun solveSudoku(board: Array<CharArray>) {
            solve(board, 0, 0)
        }

        private fun solve(board: Array<CharArray>, xIn: Int, yIn: Int): Boolean {
            var x = xIn
            var y = yIn
            while (x < 9 && board[x][y] != '.') {
                y++
                if (y == 9) {
                    x++
                    y = 0
                }
            }
            if (x == 9) return true

            for (num in 49..57) {
                if (isValid(board, x, y, num.toChar())) {
                    board[x][y] = num.toChar()
                    if (solve(board, x, y)) return true
                    board[x][y] = '.'
                }
            }
            return false
        }

        private fun isValid(board: Array<CharArray>, x: Int, y: Int, num: Char): Boolean {
            for (currentY in 0..8) {
                if (board[x][currentY] == num) return false
            }
            for (currentX in 0..8) {
                if (board[currentX][y] == num) return false
            }
            val gridX = x / 3 * 3
            val gridY = y / 3 * 3
            for (r in gridX..gridX+2) {
                for (c in gridY..gridY+2) {
                    if (board[r][c] == num) return false
                }
            }
            return true
        }
    }
//    class Solution {
//        class BoardInfo() {
//
//            constructor(another: BoardInfo): this() {
//                this.cells = another.cells.map { SudokuCell(it.cellX, it.cellY, it.original, HashSet(it.possibleValues)) }.toTypedArray()
//                this.remaining = another.remaining
//            }
//
//            var remaining = 0
//            lateinit var cells: Array<SudokuCell>
//            val grids = Array(9) {
//                val gridX = it / 3
//                val gridY = it % 3
//                SudokuGrid(gridX, gridY)
//            }
//
//
//            inner class SudokuCell(val cellX: Int, val cellY: Int, var original: Char, val possibleValues: MutableSet<Char>) {
//                init {
//                    if (original == '.') {
//                        remaining++
//                    }
//                }
//
//                val grid: SudokuGrid by lazy {
//                    getGrid(cellX / 3, cellY / 3)
//                }
//                val verticalLine: Array<SudokuCell> by lazy {
//                    Array(9) {
//                        getCell(cellX, it)
//                    }
//                }
//                val horizontalLine: Array<SudokuCell> by lazy {
//                    Array(9) {
//                        getCell(it, cellY)
//                    }
//                }
//
//                override fun equals(other: Any?): Boolean {
//                    return other is SudokuCell && other.hashCode() == hashCode()
//                }
//
//                override fun hashCode(): Int {
//                    return cellX * 9 + cellY
//                }
//            }
//            inner class SudokuGrid(val gridX: Int, val gridY: Int) {
//                val cells: Array<SudokuCell> by lazy {
//                    Array(9) {
//                        getCell(gridX*3 + it/3, gridY*3 + it%3)
//                    }
//                }
//            }
//
//            fun getGrid(x: Int, y: Int): SudokuGrid {
//                return grids[x*3 + y]
//            }
//            fun getCell(x: Int, y: Int): SudokuCell {
//                return cells[x * 9 + y]
//            }
//
//
//        }
//
//        fun solve(boardInfo: BoardInfo, bruteForce: Boolean = true): BoardInfo? {
//            // Calculate all the possible values in every single empty cell
//            if (bruteForce)
//                println("[INFO] Solving using the \"possible values for each cell\" strategy")
//            while (boardInfo.remaining > 0) {
//                var solved = 0
//                for (cell in boardInfo.cells) {
//                    if (cell.original == '.') {
//                        cell.possibleValues.addAll(Array(9) { (it + 1 + 48).toChar() })
//                        for (sudokuCell in cell.verticalLine) {
//                            cell.possibleValues.remove(sudokuCell.original)
//                        }
//                        for (sudokuCell in cell.horizontalLine) {
//                            cell.possibleValues.remove(sudokuCell.original)
//                        }
//                        for (sudokuCell in cell.grid.cells) {
//                            cell.possibleValues.remove(sudokuCell.original)
//                        }
//                        if (cell.possibleValues.size == 1) {
//                            cell.original = cell.possibleValues.first()
//                            solved += 1
//                            boardInfo.remaining -= 1
//                        }
//                    }
//                }
//                if (solved == 0) {
//                    if (!bruteForce) {
//                        return null
//                    }
//                    if (bruteForce)
//                        println("[INFO] - ${boardInfo.remaining} cell(s) could not be solved! Attempting to brute-force row, column, or grid with minimum unsolved cells")
//                    for (cellToMutate in boardInfo.cells.filter { it.possibleValues.isNotEmpty() && it.original == '.' }.sortedBy { it.possibleValues.size }) {
//                        for (possibleValue in cellToMutate.possibleValues) {
//                            if (bruteForce)
//                                println("[DEBUG] Attempting to mutate ${cellToMutate.cellX}/${cellToMutate.cellY} with $possibleValue")
//                            val newBoardInfo = BoardInfo(boardInfo)
//                            val cellToModify = newBoardInfo.getCell(cellToMutate.cellX, cellToMutate.cellY)
//                            newBoardInfo.remaining--
//                            cellToModify.original = possibleValue
//                            val solved = solve(newBoardInfo, false)
//                            if (solved != null) {
//                                if (bruteForce)
//                                    println("[INFO] Successfully solved the sudoku with brute-force method")
//                                return solved
//                            }
//                        }
//                    }
//
//                    if (bruteForce)
//                        println("[ERROR] - Attempt of brute-force has been made, but has failed.")
//                    return null
//
//                } else {
//                    if (bruteForce)
//                        println("[INFO] - Solved $solved cells in this iteration")
//                }
//            }
//            return boardInfo
//        }
//
//        fun solveSudoku(board: Array<CharArray>) {
//            val boardInfo = BoardInfo()
//            println("===== Sudoku Solver (by fan87, for Leetcode) =====")
//            // Read in the board
//            println("[INFO] Reading board...")
//            boardInfo.cells = Array(81) {
//                val x = it / 9
//                val y = it % 9
//                if (board[x][y] == '.') {
//                    boardInfo.SudokuCell(x, y, board[x][y], hashSetOf())
//                } else {
//                    boardInfo.SudokuCell(x, y, board[x][y], hashSetOf(board[x][y]))
//                }
//            }
//
//            val solved = solve(boardInfo)
//
//            for (x in 0 until 9) {
//                for (y in 0 until 9) {
//                    board[x][y] = solved!!.getCell(x, y).original
//                }
//            }
//        }
//    }

}

fun main() {
    val input = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    Q37.Solution().solveSudoku(
        input
    )
    println(input.map { it.joinToString("|") }.joinToString("\n"))


    val input2 = arrayOf(
        charArrayOf('.','.','9','7','4','8','.','.','.'),
        charArrayOf('7','.','.','.','.','.','.','.','.'),
        charArrayOf('.','2','.','1','.','9','.','.','.'),
        charArrayOf('.','.','7','.','.','.','2','4','.'),
        charArrayOf('.','6','4','.','1','.','5','9','.'),
        charArrayOf('.','9','8','.','.','.','3','.','.'),
        charArrayOf('.','.','.','8','.','3','.','2','.'),
        charArrayOf('.','.','.','.','.','.','.','.','6'),
        charArrayOf('.','.','.','2','7','5','9','.','.')
    )
    Q37.Solution().solveSudoku(
        input2
    )
    println(input2.map { it.joinToString("|") }.joinToString("\n"))
}