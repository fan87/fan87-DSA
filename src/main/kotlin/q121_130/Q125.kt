package q121_130

class Q125 {

    class Solution {

        fun isPalindrome(s: String): Boolean {
            val x = s.toLowerCase().filter { it.isLetterOrDigit() }
            val length = x.length
            if (length % 2 == 0) { // Even
                return expandFromCenter(length/2 - 1, length/2, x)
            } else { // Odd
                return expandFromCenter(length/2, length/2, x)
            }
        }

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