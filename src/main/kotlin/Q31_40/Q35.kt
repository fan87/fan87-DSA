package Q31_40

class Q35 {

    class Solution {
        fun searchInsert(nums: IntArray, target: Int): Int {

            var left = 0
            var right = nums.size - 1

            while (left <= right) {
                val mid = (right - left) / 2 + left
                if (target == nums[mid]) {
                    right = mid - 1
                }
                if (target > nums[mid]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }

            return left
        }
    }

}