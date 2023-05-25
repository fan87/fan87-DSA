package q21_30

class Q26 {

    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            var latestIndex = 1
            for (i in 1 until nums.size) {
                val value = nums[i]
                if (nums[i + 1] != value) {
                    nums[latestIndex++] = value
                }
            }
            return latestIndex
        }
    }

}