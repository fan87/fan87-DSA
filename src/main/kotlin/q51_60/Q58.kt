package q51_60

class Q58 {

    class Solution {
        fun lengthOfLastWord(s: String): Int {
            var lengthOfWord = 0
            var endOfWord = false
            for (c in s) {
                if (c == ' ') {
                    endOfWord = true
                } else {
                    if (endOfWord) {
                        lengthOfWord = 0
                        endOfWord = false
                    }
                    lengthOfWord++
                }
            }
            return lengthOfWord
        }
    }

}