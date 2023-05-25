package q161_170

class Q169 {

    class Solution {
        // TODO: Me when being unable to solve an easy problem. Just, re-do it blindly I guess
        // This is stupid
        fun majorityElement(nums: IntArray): Int {
            var count = 0
            var currentCheckingElement = 0
            nums.forEach { num ->
                if (count == 0) {
                    currentCheckingElement = num
                }
                count += if (num == currentCheckingElement) 1 else -1
            }
            return currentCheckingElement
        }
    }

}

fun main() {
}