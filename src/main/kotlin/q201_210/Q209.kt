package q201_210

import __Serializer__
import testing.LeetTest

class Q209 {

    class Solution {

        // TODO: I found the answer by looking into the category, maybe dont do it?
        fun minSubArrayLen(target: Int, nums: IntArray): Int {
            var min = Int.MAX_VALUE
            var left = 0
            var current = 0
            for ((index, i) in nums.withIndex()) {
                current += i
                if (index - left + 1 >= min) {
                    if (left > nums.size) {
                        break
                    }
                    current -= nums[left++]
                }
                while (current >= target) {
                    min = index - left + 1
                    current -= nums[left++]
                }
            }
            return if (min == Int.MAX_VALUE) 0 else min
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q209.Solution::minSubArrayLen, __Serializer__::serialize, "2", "7", "[2,3,1,2,4,3]")
    LeetTest.assertReturn(Q209.Solution::minSubArrayLen, __Serializer__::serialize, "1", "4", "[1,4,4]")
    LeetTest.assertReturn(Q209.Solution::minSubArrayLen, __Serializer__::serialize, "0", "11", "[1,1,1,1,1,1,1,1]")
    LeetTest.assertReturn(Q209.Solution::minSubArrayLen, __Serializer__::serialize, "3", "11", "[1,2,3,4,5]")
}