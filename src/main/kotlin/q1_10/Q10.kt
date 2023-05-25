package q1_10

class Q10 {

    class Solution {
        data class Snapshot(var patternIndex: Int, var stringIndex: Int)

        fun charMatches(input: Char, pattern: Char): Boolean {
            return pattern == '.' || pattern == input
        }
        // Regular Expression Engine that only implements `.` and `*`
        // Since we only need to implement "." and "*", we don't need to fully implement the Regular Expression parser correctly
        // as every component only consists of 1 char
        // * is greedy btw
        fun isMatch(string: String, pattern: String): Boolean {
            var patternIndex = 0
            var stringIndex = -1
            val rollbackHistory = ArrayList<Snapshot>()
            val rollbacks = ArrayList<Snapshot>()
            fun takeSnapshot() {
                rollbacks.add(Snapshot(patternIndex, stringIndex))
            }
            fun fail(): Boolean {
                if (rollbacks.isEmpty()) {
                    return true
                }
                val snapshot = rollbacks.removeAt(rollbacks.size - 1)
                if (snapshot in rollbackHistory) {
                    return fail()
                }
                rollbackHistory.add(snapshot)
                patternIndex = snapshot.patternIndex
                stringIndex = snapshot.stringIndex
                return false
            }
            fun expectReadInput(): Any? {
                stringIndex++
                if (patternIndex >= pattern.length && stringIndex >= string.length) {
                    return null
                }
                if (stringIndex >= string.length) {
                    return fail()
                }

                if (patternIndex >= pattern.length) {
                    return fail()
                }
                return string[stringIndex]
            }

            while (true) {
                if (pattern.length > patternIndex + 1 && pattern[patternIndex + 1] == '*') {
                    patternIndex += 2
                    takeSnapshot()
                    patternIndex -= 2
                }
                if (pattern.length > patternIndex && pattern[patternIndex] == '*') {
                    patternIndex -= 1
                    takeSnapshot()
                }

                val input = expectReadInput()
                if (input is Boolean) {
                    if (input) return false else continue
                }
                if (input == null) {
                    return true
                }

                val currentPattern = pattern[patternIndex]

                if (input is Char) {
                    if (!charMatches(input, currentPattern)) {
                        if (fail()) return false else continue
                    }
                }

                patternIndex++
            }
        }
    }

}

fun main() {
    if (!Q10.Solution().isMatch("ab", ".*c")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("aab", "c*a*b")) println("Success") else println("Failed")
    if (!Q10.Solution().isMatch("aa", "a")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("aa", "a*")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("aab", "a.*")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("aab", "a.*b")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("aab", "a.b")) println("Success") else println("Failed")
    if (!Q10.Solution().isMatch("ab", "b*")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("ab", ".*")) println("Success") else println("Failed")
    if (!Q10.Solution().isMatch("aabbab", "aa*b")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("aabbab", "aab.*b")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("aabbab", "aab.*bab")) println("Success") else println("Failed")
    if (Q10.Solution().isMatch("aabbab", "aab.*ab")) println("Success") else println("Failed")
    if (!Q10.Solution().isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*c")) println("Success") else println("Failed")



}