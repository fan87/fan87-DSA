package q161_170

class Q167 {

    class Solution {
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            var right = numbers.size - 1
            var left = 0
            while (left < right) {
                val added = numbers[left] + numbers[right]
                if (added == target) {
                    return intArrayOf(left + 1, right + 1)
                }
                if (added > target) {
                    right--
                } else {
                    left++
                }
            }
            error("No solution")
        }
    }

}