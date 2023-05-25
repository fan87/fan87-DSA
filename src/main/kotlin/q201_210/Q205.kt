package q201_210

import __Serializer__
import testing.LeetTest

class Q205 {

    class Solution {
        fun isIsomorphic(s: String, t: String): Boolean {
            val charReplacement = HashMap<Char, Char>()
            val reversedCharReplacement = HashMap<Char, Char>()
            for ((index, char) in s.withIndex()) {
                if (char in charReplacement) {
                    if (charReplacement[char] != t[index]) { // Expected replacement char is not equal to actual replacement char
                        return false
                    }
                } else {
                    if (t[index] in reversedCharReplacement) { // Replacement char is already used by another char
                        return false
                    }
                    charReplacement[char] = t[index]
                    reversedCharReplacement[t[index]] = char
                }
            }
            return true
        }
    }

}

fun main() {
//    LeetTest.assertReturn(Q205.Solution::isIsomorphic, __Serializer__::serialize, "true", "egg", "add")
//    LeetTest.assertReturn(Q205.Solution::isIsomorphic, __Serializer__::serialize, "false", "foo", "bar")
//    LeetTest.assertReturn(Q205.Solution::isIsomorphic, __Serializer__::serialize, "true", "paper", "title")
    LeetTest.assertReturn(Q205.Solution::isIsomorphic, __Serializer__::serialize, "false", "badc", "baba")
}