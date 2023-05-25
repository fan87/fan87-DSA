package q1_10

class Q5 {

    class Solution {
        fun longestPalindrome(s: String): String {
            if (s.isEmpty()) return ""

            var currentFound: Pair<Int, Int> = Pair(0, 0)
            var currentLength = 0
            for (index in s.indices) {
                // TODO: Take consideration of potential maximum length

                val firstResult = expandFromCenter(index, index, s)
                val firstLength = firstResult.second - firstResult.first
                if (firstLength > currentLength) {
                    currentFound = firstResult
                    currentLength = firstLength
                }


                val secondResult = expandFromCenter(index, index + 1, s)
                val secondLength = secondResult.second - secondResult.first
                if (secondLength > currentLength) {
                    currentFound = secondResult
                    currentLength = secondLength
                }
            }
            return s.substring(currentFound.first, currentFound.second)
        }

        // Returns inclusive start and exclusive end
        fun expandFromCenter(centerA: Int, centerB: Int, inputString: String): Pair<Int, Int> {
            var aIndex = centerA
            var bIndex = centerB
            while (aIndex >= 0 && bIndex <= inputString.length - 1) {
                if (inputString[aIndex] != inputString[bIndex]) {
                    return Pair(aIndex + 1, bIndex)
                }
                aIndex--
                bIndex++
            }
            return Pair(aIndex + 1, bIndex)
        }
    }

}

fun main() {
    println(Q5.Solution().longestPalindrome("abacbccbcaba"))
    println(Q5.Solution().longestPalindrome("babad"))
}