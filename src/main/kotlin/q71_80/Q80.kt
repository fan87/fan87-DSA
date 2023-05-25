package q71_80

class Q80 {

    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            var element = Int.MIN_VALUE
            var appearanceTimes = 0
            var currentWriteIndex = 0

            for (num in nums) {
                if (num == element) {
                    if (appearanceTimes < 2) {
                        appearanceTimes += 1
                        nums[currentWriteIndex++] = num
                    }
                } else {
                    element = num
                    appearanceTimes = 1
                    nums[currentWriteIndex++] = num
                }
            }
            return currentWriteIndex
        }
    }

}