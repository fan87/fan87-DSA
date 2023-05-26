package q61_70

import __Serializer__
import testing.LeetTest

class Q63 {

    class Solution {
        fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
            val height = obstacleGrid.size
            val width = obstacleGrid[0].size

            if (obstacleGrid[0][0] == 1) return 0
            if (obstacleGrid[height - 1][width - 1] == 1) return 0
            var currentRowNumber = height - 1
            var prevNumber = 1
            while (currentRowNumber >= 0) {
                prevNumber = 1
                val currentRow = obstacleGrid[currentRowNumber]
                for (i in width - 1 downTo 0) {
                    val evaluated: Int = if (currentRow[i] == 1) 0
                    else if (currentRowNumber == height - 1) prevNumber
                    else if (i == width - 1) obstacleGrid[currentRowNumber + 1][i]
                    else prevNumber + obstacleGrid[currentRowNumber + 1][i]

                    currentRow[i] = evaluated
                    prevNumber = evaluated
                }
                currentRowNumber--
            }
            return prevNumber
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q63.Solution::uniquePathsWithObstacles, __Serializer__::serialize, "2", "[[0,0,0],[0,1,0],[0,0,0]]")
    LeetTest.assertReturn(Q63.Solution::uniquePathsWithObstacles, __Serializer__::serialize, "0", "[[0,0],[1,1],[0,0]]")
    LeetTest.assertReturn(Q63.Solution::uniquePathsWithObstacles, __Serializer__::serialize, "1", "[[0,1],[0,0]]")
}