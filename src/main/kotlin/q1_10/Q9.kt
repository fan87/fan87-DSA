package q1_10

class Q9 {
    class Solution {
        fun isPalindrome(x: Int): Boolean {
            if (x < 0) return false
            if (x < 10) return true // 1 Digit
            return isPalindrome(x.toString())
        }
        fun isPalindrome(x: String): Boolean {
            val length = x.length
            if (length % 2 == 0) { // Even
                return expandFromCenter(length/2 - 1, length/2, x)
            } else { // Odd
                return expandFromCenter(length/2, length/2, x)
            }
        }

        // Returns inclusive start and exclusive end
        fun expandFromCenter(centerA: Int, centerB: Int, inputString: String): Boolean {
            var aIndex = centerA
            var bIndex = centerB
            while (aIndex >= 0 && bIndex <= inputString.length - 1) {
                if (inputString[aIndex] != inputString[bIndex]) {
                    return false
                }
                aIndex--
                bIndex++
            }
            return true
        }
    }
}

fun main() {
    println(Q9.Solution().isPalindrome(191))
}