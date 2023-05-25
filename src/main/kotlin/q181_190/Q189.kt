package q181_190

class Q189 {

    class Solution {
        // Memory Complexity: O(nums.size - (k % nums.size)))
        // Time Complexity: O(nums.size + (k % nums.size))
        fun rotate_1(nums: IntArray, k: Int) {
            val last = IntArray(nums.size - (k % nums.size))
            System.arraycopy(nums, 0, last, 0, last.size)
            System.arraycopy(nums, last.size, nums, 0, k % nums.size)
            System.arraycopy(last, 0, nums, k % nums.size, last.size)
        }
        fun rotate(nums: IntArray, k: Int) {
            for (rotation in 0 until (k % nums.size)) {
                val lastOne = nums[nums.lastIndex]
                for (index in nums.lastIndex-1 downTo  0) {
                    nums[index + 1] = nums[index]
                }
                nums[0] = lastOne
            }
        }
    }

    // 1, 2, 3, 4, 5, 6, 7, 8, 9
    // 3
    // 7, 8, 9, 1, 2, 3, 4, 5, 6

}

fun main() {
    println(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9).also { Q189.Solution().rotate(it, 30) }.joinToString(", "))
    println(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9).also { Q189.Solution().rotate_1(it, 30) }.joinToString(", "))
}