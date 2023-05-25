package daily

class Q704 {

    class Solution {
        fun search(nums: IntArray, target: Int): Int {
            var low: Int = 0
            var high: Int = nums.size - 1

            while (low <= high) {
                val mid = low + high ushr 1
                val midVal: Int = nums[mid]
                if (midVal < target)
                    low = mid + 1
                else if (midVal > target)
                    high = mid - 1
                else
                    return mid // key found
            }
            return -1 // key not found.

        }
    }

}