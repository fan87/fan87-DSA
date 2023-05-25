package Q31_40

class Q34 {

    class Solution {
        fun searchRange(nums: IntArray, target: Int): IntArray {
            var left = 0
            var right = nums.size - 1

            var outStart = Int.MAX_VALUE
            var outEnd = -1

            // Find max
            while (left < right) {
                val mid = (right - left) / 2 + left
                if (target == nums[mid]) {
                    outEnd = maxOf(mid, outEnd)
                    left = mid + 1
                }
                if (target > nums[mid]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }

            if (outEnd == -1) {
                return intArrayOf(-1, -1)
            }

            left = 0
            right = outEnd
            // Find min
            while (left <= right) {
                val mid = (right - left) / 2 + left
                if (target == nums[mid]) {
                    outStart = minOf(mid, outStart)
                    right = mid - 1
                }
                if (target > nums[mid]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }

            return intArrayOf(outStart, outEnd)
        }
    }

}