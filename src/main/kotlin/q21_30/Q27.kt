package q21_30

class Q27 {

    class Solution {
        fun removeElement(nums: IntArray, `val`: Int): Int {
            var latest = 0
            for (element in nums) {
                if (element == `val`) continue
                nums[latest++] = element
            }
            return latest
        }
    }

}