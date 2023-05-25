package q41_50

class Q48 {

    class Solution {

        fun Array<IntArray>.loopSize(): Int {
            return this.size - 1
        }
        fun Array<IntArray>.loopsCount(): Int {
            return this.size / 2
        }


        fun rotate(matrix: Array<IntArray>) {
            val matrixSize: Int = matrix.size
            for (baseX in 0 until (matrixSize + 1) / 2) {
                for (baseY in 0 until matrixSize / 2) {
                    val temp = matrix[matrixSize - 1 - baseY][baseX]
                    matrix[matrixSize - 1 - baseY][baseX] = matrix[matrixSize - 1 - baseX][matrixSize - baseY - 1]
                    matrix[matrixSize - 1 - baseX][matrixSize - baseY - 1] = matrix[baseY][matrixSize - 1 - baseX]
                    matrix[baseY][matrixSize - 1 - baseX] = matrix[baseX][baseY]
                    matrix[baseX][baseY] = temp
                }
            }
        }
    }

}


fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    Q48.Solution().rotate(matrix)
    println(matrix.map { it.joinToString(", ") })
}