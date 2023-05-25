package q21_30

class Q30 {
    class Solution {
        fun validateString(str: String, words: Array<String>) {

        }

        fun findSubstring(s: String, words: Array<String>): List<Int> {
            var wordsCount = IntArray(words.size) { 1 }
            val wordLength = words[0].length
            if (s.length % wordLength != 0) throw IllegalArgumentException("Slicing Windows cannot be applied")
            val words = HashMap<Int, String>()
//            var position = -1
//            var textBuffer = ""
//            val out = ArrayList<Int>()
//            outer@while (true) {
//                for (i in 0 until wordLength) {
//                    if (position == s.length - 1) break@outer
//                    position += 1
//                    textBuffer += s[position]
//                }
//                val index = words.indexOf(textBuffer)
//                println(textBuffer)
//                textBuffer = ""
//                if (index != -1) {
//                    wordsCount[index] -= 1
//                    if (wordsCount[index] < 0) {
//                        wordsCount = IntArray(words.size) { 1 }
//                    }
//                    if (wordsCount.all { it == 0 }) {
//                        wordsCount = IntArray(words.size) { 1 }
//                        out.add(position - words.size * wordLength + 1)
//                        position -= (words.size - 1) * wordLength
//                    }
//                } else {
//                    wordsCount = IntArray(words.size) { 1 }
//                }
//            }
//            return out
            TODO()
        }
    }
}