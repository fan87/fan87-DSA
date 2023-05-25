package q131_140

import __Serializer__
import testing.LeetTest

class Q135 {

    // Input [1,2,2,3,3,4,2,1]
    // First phase, only considers left -> right order: 1 + 2 + 1 + 2 + 1 + 2 + 1 + 1
    // 1 + 2 + 1 + 2 + 1 + 3 + 2 + 1

    // 15 minutes on solve
    // 2 minutes on improve (Remove "previous" pass)


    // TODO: [Very Difficult] One pass w/ O(1) extra memory
    class Solution {
        fun candy(ratings: IntArray): Int {
            val out = IntArray(ratings.size)
            var currentValue = 1
            for ((index, value) in ratings.withIndex()) {
                if (index > 0 && value > ratings[index - 1]) {
                    currentValue++
                } else {
                    currentValue = 1
                }
                out[index] = currentValue
            }

            currentValue = 0
            var sum = 0
            for ((index, value) in ratings.withIndex().reversed()) {
                if (index < ratings.size - 1 && value > ratings[index + 1]) {
                    currentValue++
                } else {
                    currentValue = 1
                }
                sum += maxOf(currentValue, out[index])
            }


            return sum
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q135.Solution::candy, __Serializer__::serialize, "5", "[1,0,2]")
    LeetTest.assertReturn(Q135.Solution::candy, __Serializer__::serialize, "4", "[1,2,2]")
    LeetTest.assertReturn(Q135.Solution::candy, __Serializer__::serialize, "13", "[1,2,2,3,3,4,2,1]")
    LeetTest.assertReturn(Q135.Solution::candy, __Serializer__::serialize, "7", "[1,3,2,2,1]")
}