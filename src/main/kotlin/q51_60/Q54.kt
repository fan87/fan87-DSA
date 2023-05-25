package q51_60

class Q54 {

    class Solution {
        fun spiralOrder(matrix: Array<IntArray>): List<Int> {
            val width = matrix[0].size
            val height = matrix.size
            val matrixSize = width * height
            val out = ArrayList<Int>()

            // Direction
            // 0 = right
            // 1 = down
            // 2 = left
            // 3.= up
            var direction = 0
            var reduced = 1
            var toReduce = 3
            var xPos = 0
            var yPos = 0
            out.add(matrix[0][0])

            while (out.size != matrixSize) {
                when (direction) {
                    0 -> {
                        for (i in 0 until width - reduced) {
                            xPos++
                            out.add(matrix[yPos][xPos])
                        }
                    }
                    1 -> {
                        for (i in 0 until height - reduced) {
                            yPos++
                            out.add(matrix[yPos][xPos])
                        }
                    }
                    2 -> {
                        for (i in 0 until width - reduced) {
                            xPos--
                            out.add(matrix[yPos][xPos])
                        }
                    }
                    3 -> {
                        for (i in 0 until height - reduced) {
                            yPos--
                            out.add(matrix[yPos][xPos])
                        }
                    }
                }
                direction = (direction + 1) % 4

                toReduce--
                if (toReduce == 0) {
                    toReduce = 2
                    reduced += 1
                }
            }

            return out
        }
    }

}

fun main() {
    println(Q54.Solution().spiralOrder(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
    ))
    println(Q54.Solution().spiralOrder(
        arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
        )
    ))
}