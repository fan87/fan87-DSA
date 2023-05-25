package q391_400

class Q392 {

    class Solution {
        fun isSubsequence(pattern: String, inputString: String): Boolean {
            if (pattern.isEmpty()) return true
            var patternIndex = 0
            for (c in inputString) {
                if (c == pattern[patternIndex]) {
                    patternIndex++
                    if (patternIndex == pattern.length) return true
                }
            }
            return patternIndex == pattern.length
        }
    }

}