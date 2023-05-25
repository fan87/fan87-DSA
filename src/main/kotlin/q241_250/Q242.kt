package q241_250

class Q242 {

    class Solution {
        fun isAnagram(s: String, t: String): Boolean {
            if (s.length != t.length) return false
            val wordCount = IntArray(26)
            for (c in s) {
                wordCount[c.toInt() - 97]++
            }
            for (c in t) {
                wordCount[c.toInt() - 97]--
                if (wordCount[c.toInt() - 97] < 0) return false
            }
            for (i in wordCount) {
                if (i == 0) return false
            }
            return true
        }
    }

}