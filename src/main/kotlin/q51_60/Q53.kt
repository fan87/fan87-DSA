package q51_60

import kotlin.math.max

class Q53 {

    class Solution {
        fun maxSubArray(nums: IntArray): Int {
            var currentValue = 0
            var answer = nums[0]

            for (num in nums) {
                if (currentValue < 0) {
                    currentValue = num
                } else {
                    currentValue += num
                }
                if (currentValue > answer) {
                    answer = currentValue
                }
            }
            return answer
        }
    }

}

fun main() {
    println(Q53.Solution().maxSubArray(intArrayOf(1, 1, 10, -10, 10, -13)))
    println(Q53.Solution().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(Q53.Solution().maxSubArray(intArrayOf(5,4,-1,7,8)))
}