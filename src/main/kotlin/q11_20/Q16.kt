package q11_20

import kotlin.math.abs

class Q16 {

    class Solution {
        fun threeSumClosest(nums: IntArray, target: Int): Int {
            nums.sort()

            var diff = Int.MAX_VALUE
            var closest = Int.MIN_VALUE
            for ((index, value) in nums.withIndex()) {
                var pointerA = index + 1
                var pointerB = nums.size - 1

                while (pointerB > pointerA) {
                    val result = nums[pointerA] + nums[pointerB] + value
                    val currentDiff = target - result
                    if (result == target) {
                        return result
                    } else if (result < target) {
                        if (abs(currentDiff) < abs(diff)) {
                            closest = result
                            diff = currentDiff
                        }
                        pointerA++
                    } else {
                        if (abs(currentDiff) < abs(diff)) {
                            closest = result
                            diff = currentDiff
                        }
                        pointerB--
                    }
                }
            }

            return closest
        }
    }

}

fun main() {
    println(Q16.Solution().threeSumClosest(intArrayOf(1, 1, 1, 0), -100))
}