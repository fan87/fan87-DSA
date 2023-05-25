package q1_10

class Q3 {
    class Solution {
        fun lengthOfLongestSubstring(s: String): Int {
            val seenLocations = HashMap<Char, Int>()
            var substringStartIndex = 0
            var currentLength = 0
            var finalLength = 0
            for ((index, char) in s.withIndex()) {
                if (seenLocations[char] != null && seenLocations[char]!! >= substringStartIndex) {
                    finalLength = maxOf(currentLength, finalLength)
                    currentLength -= (seenLocations[char]!! - substringStartIndex) + 1
                    substringStartIndex = index - currentLength
                }
                seenLocations[char] = index
                currentLength++
            }
            return maxOf(currentLength, finalLength)
        }
    }
}

fun main() {
    println(Q3.Solution().lengthOfLongestSubstring("bbbbb") == 1)
    println(Q3.Solution().lengthOfLongestSubstring("abcabcbb") == 3)
    println(Q3.Solution().lengthOfLongestSubstring("dvdf") == 3)
    println(Q3.Solution().lengthOfLongestSubstring("pwwkew") == 3)
    println(Q3.Solution().lengthOfLongestSubstring("anviaj") == 5)
}