package q281_290

import __Serializer__
import testing.LeetTest

class Q290 {

    class Solution {
        fun wordPattern(pattern: String, s: String): Boolean {
            val wordReplacement = HashMap<String, Char>()
            val reversedWordReplacement = HashMap<Char, String>()
            if (pattern.length != s.split(" ").size) return false
            for ((index, word) in s.split(" ").withIndex()) {
                if (word in wordReplacement) {
                    if (wordReplacement[word] != pattern[index]) { // Expected replacement char is not equal to actual replacement word
                        return false
                    }
                } else {
                    if (pattern[index] in reversedWordReplacement) { // Replacement char is already used by another word
                        return false
                    }
                    wordReplacement[word] = pattern[index]
                    reversedWordReplacement[pattern[index]] = word
                }
            }
            return true
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q290.Solution::wordPattern, __Serializer__::serialize, "true", "abba", "dog cat cat dog")
}