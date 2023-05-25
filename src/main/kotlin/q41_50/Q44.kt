package q41_50

class Q44 {

    // TODO: Grow up
    class Solution {

        fun isMatch(string: String, pattern: String): Boolean {
            var stringIndex = 0
            var patternIndex = 0

            var patternRollback = -1
            var stringRollback = 0

            while (stringIndex < string.length) {
                if (patternIndex < pattern.length && (string[stringIndex] == pattern[patternIndex] || pattern[patternIndex] == '?')) {
                    stringIndex += 1
                    patternIndex += 1
                } else if (patternIndex < pattern.length && pattern[patternIndex] == '*') {
                    patternRollback = patternIndex
                    stringRollback = stringIndex

                    patternIndex += 1
                } else if (patternRollback != -1) {
                    patternIndex = patternRollback + 1
                    stringIndex = stringRollback + 1

                    stringRollback += 1
                } else {
                    return false
                }
            }
            while (patternIndex < pattern.length && pattern[patternIndex] == '*') {
                patternIndex += 1
            }
            return patternIndex == pattern.length
        }


    }



}

fun main() {
    val startTime = System.currentTimeMillis()
    println(Q44.Solution().isMatch("pre_mid_end_mid_endb_end", "pre*mid*end_*"))
    repeat (100) {
        // 123456567897890  1234*56*123456
        Q44.Solution().isMatch("abbbaaababbaaabaaabbbabbbbaaabbaaababaabbbbbbaababbabababbababaaabbbbbabababaababaaaaaaabbbaabaabbbaabbabaababbabaababbbabbaaabbbaaaababbaaabbaabaabbbbbaaababaabaabaaabbabaabbbabbbaabbababaabbbbbbbbaaa", "*ba***bba*b**abbaa***a*****b*a*bb*b***a*bbb***a***bba*****a****a*a*b**aaaba*aab*a*aa***a*a*b**b**a*b*")
    }
    println("Took ${System.currentTimeMillis() - startTime} ms")
}