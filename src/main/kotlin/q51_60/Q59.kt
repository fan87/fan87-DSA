package q51_60

class Q59 {



    class Solution {
        fun generateMatrix(n: Int): Array<IntArray> {
            var currentIndex = 1
            val matrix = Array(n) { IntArray(n) }
            var visited = 0
            val matrixSize = n * n

            var direction = 0
            var reduced = 1
            var toReduce = 3
            var xPos = 0
            var yPos = 0
            visited++
            matrix[yPos][xPos] = currentIndex++

            while (visited != matrixSize) {
                when (direction) {
                    0 -> {
                        for (i in 0 until n - reduced) {
                            xPos++
                            visited++
                            matrix[yPos][xPos] = currentIndex++
                        }
                    }
                    1 -> {
                        for (i in 0 until n - reduced) {
                            yPos++
                            visited++
                            matrix[yPos][xPos] = currentIndex++
                        }
                    }
                    2 -> {
                        for (i in 0 until n - reduced) {
                            xPos--
                            visited++
                            matrix[yPos][xPos] = currentIndex++
                        }
                    }
                    3 -> {
                        for (i in 0 until n - reduced) {
                            yPos--
                            visited++
                            matrix[yPos][xPos] = currentIndex++
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

            return matrix
        }
    }

}

fun main() {
    println(
        Q59.Solution().generateMatrix(3).map { it.joinToString(", ") }.joinToString("\n")
    )
}