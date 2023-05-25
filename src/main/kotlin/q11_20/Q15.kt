package q11_20

class Q15 {

    class Solution {
        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()

            val out = HashSet<List<Int>>()
            for ((index, value) in nums.withIndex()) {
                var pointerA = index + 1
                var pointerB = nums.size - 1

                while (pointerB > pointerA) {
                    val result = nums[pointerA] + nums[pointerB] + value
                    if (result == 0) {
                        out.add(listOf(value, nums[pointerA], nums[pointerB]))
                        pointerA++
                        pointerB--
                    } else if (result < 0) {
                        pointerA++
                    } else {
                        pointerB--
                    }
                }
            }

            return out.toList()
        }
    }

}