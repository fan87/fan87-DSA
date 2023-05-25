package q41_50

class Q41 {

    class Solution {

        fun firstMissingPositive(nums: IntArray): Int {
            if (nums.filter { it > 0 }.size == 0) return 1
            val max = nums.max()!!
            val min = nums.filter { it > 0 }.min()!!
            if (min != 1) {
                return 1
            }

            for (withIndex in nums.withIndex()) {
                nums[withIndex.index] = if (withIndex.value <= 0) nums.size + 1 else withIndex.value
            }
            fun swap(a: Int, b: Int) {
                nums[a] = nums[b].also { nums[b] = nums[a] }
            }
            fun trace(index: Int) {
                val value = nums[index]
                if (value - 1 == index) return
                if (value > nums.size) {
                    nums[index] = nums.size + 1
                } else {
                    swap(value - 1, index)
                }
            }


            repeat (2) {
                for (index in nums.indices) {
                    trace(index)
                }
            }

            var previous = 0
            for (num in nums) {
                if (num != previous + 1) {
                    return previous + 1
                }
                previous = num
            }


            return max + 1
        }
    }

}

fun main() {
    val nums = intArrayOf(1, 1000)
    println(Q41.Solution().firstMissingPositive(nums))
    println(nums.joinToString(", "))
}