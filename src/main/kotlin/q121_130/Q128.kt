package q121_130

import __Serializer__
import testing.LeetTest

class Q128 {

    // TODO: Solve longest consecutive again
    class Solution {
        fun longestConsecutive(nums: IntArray): Int {
            val set = HashSet<Int>()
            for (num in nums) {
                set.add(num)
            }

            var longestStreak = 0
            for (num in set) {
                if (num in set) {
                    var currentNum = num
                    var currentStreak = 1

                    while (currentNum + 1 in set) {
                        currentNum += 1
                        currentStreak += 1
                    }

                    longestStreak = longestStreak.coerceAtLeast(currentStreak)
                }
            }


            return longestStreak
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q128.Solution::longestConsecutive, __Serializer__::serialize, "4", "[100,4,200,1,3,2]")
    LeetTest.assertReturn(Q128.Solution::longestConsecutive, __Serializer__::serialize, "9", "[0,3,7,2,5,8,4,6,0,1]")
}