package q61_70

import __Serializer__
import testing.LeetTest

class Q62 {

    class Solution {
        fun uniquePaths(height: Int, width: Int): Int {

            val row = IntArray(width) { 1 }
            var currentRowNumber = 1
            var prevNumber = 1
            while (height > currentRowNumber) {
                prevNumber = 1
                for (i in 1 until row.size) {
                    val evaluated = prevNumber + row[i]
                    row[i] = evaluated
                    prevNumber = evaluated
                }

                currentRowNumber++
            }
            return prevNumber
        }


    }

}

fun main() {
    LeetTest.assertReturn(Q62.Solution::uniquePaths, __Serializer__::serialize, "28", "3", "7")
    LeetTest.assertReturn(Q62.Solution::uniquePaths, __Serializer__::serialize, "3", "3", "2")
}