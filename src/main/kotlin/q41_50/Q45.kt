package q41_50

class Q45 {

    // TODO: Can you do it with binary search?
    class Solution {
        fun jump(nums: IntArray): Int {
            return calculateJump(0, nums)
        }

        fun calculateJump(index: Int, nums: IntArray): Int {
            val maxSteps = nums[index]
            if (index == nums.size - 1) return 0
            if (index + maxSteps >= nums.size - 1) {
                return 1
            }
            var maxWeight = 0
            var maxIndex = index
            for (step in 1..maxSteps) {
                val weight = nums[index + step] + step
                if (weight > maxWeight) {
                    maxIndex = index + step
                    maxWeight = weight
                }
            }
            return 1 + calculateJump(maxIndex, nums)
        }
    }

}

fun main() {
    println(Q45.Solution().jump(intArrayOf(2, 3, 1, 1, 4)))
    println(Q45.Solution().jump(intArrayOf(2, 3, 0, 1, 4)))
    println(Q45.Solution().jump(intArrayOf(5, 6, 1, 1, 5, 1, 1, 1, 6)))
}