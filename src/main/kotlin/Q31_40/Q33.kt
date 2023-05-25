package Q31_40

class Q33 {
    class Solution {
        fun search(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.size - 1

            while (left <= right) {
                val mid = left + (right-left)/2
                if (nums[mid] == target) {
                    return mid
                }
                if (nums[mid] >= nums[left]) {
                    if (target < nums[mid] && target >= nums[left]) {
                        right = mid - 1
                    } else {
                        left = mid + 1
                    }
                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
            }

            return -1
        }
    }
}

fun main() {
    println(Q33.Solution().search(intArrayOf(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 1, 2, 3), 12))
}