package Q31_40

class Q31 {

    // TODO: Make it faster as it loses to 95%
    class Solution {
        fun IntArray.reverse(fromIndex: Int, toIndex: Int) {
            val midPoint = (fromIndex + toIndex) / 2
            if (fromIndex == midPoint) return
            var reverseIndex = toIndex - 1
            for (index in fromIndex until midPoint) {
                val tmp = this[index]
                this[index] = this[reverseIndex]
                this[reverseIndex] = tmp
                reverseIndex--
            }
        }
        fun nextPermutation(nums: IntArray) {
            if (nums.size == 1) return
            if (nums.size == 2) {
                nums.reverse()
                return
            }

            var previous = -1
            var toSwap = -1
            for (i in nums.indices.reversed()) {
                val value = nums[i]
                if (value < previous) {
                    toSwap = i
                    break
                } else {
                    previous = value
                }
            }
            if (toSwap == -1) {
                nums.reverse()
                return
            }

            // Right now, nums[toSwap + 1] is sorted (descend)
            var newLargestDigitIndex = toSwap
            for (i in (toSwap + 1) until nums.size) {
                if (nums[i] <= nums[toSwap]) {
                    break
                }
                newLargestDigitIndex = i
            }
            println("Swapping with $toSwap and $newLargestDigitIndex")

            nums[newLargestDigitIndex] = nums[toSwap].also { nums[toSwap] = nums[newLargestDigitIndex] }
            nums.reverse(toSwap + 1, nums.size)
        }
    }


}

fun main() {
    println(intArrayOf(1, 3, 2).also { Q31.Solution().nextPermutation(it) }.joinToString(", "))
}