package q61_70

import __Serializer__
import testing.LeetTest

class Q68 {

    class Solution {

        // It's not hard lol, it's easier than most of the array questions
        fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
            val out = ArrayList<String>()
            var wordPointer = -1
            val wordsForLine = ArrayList<String>()
            var lineWidth = 0
            while (wordPointer < words.size - 1) {
                wordPointer++
                val word = words[wordPointer]
                if (lineWidth + word.length > maxWidth) {
                    var lineBuffer = ""
                    val extraSpaceNeeded = maxWidth - lineWidth
                    if (wordsForLine.size > 1) {
                        val spacePerWord = extraSpaceNeeded / (wordsForLine.size - 1)
                        val needSpaceForFirstN = extraSpaceNeeded % (wordsForLine.size - 1) + 1
                        for ((index, s) in wordsForLine.withIndex()) {
                            lineBuffer += s
                            if (index == wordsForLine.lastIndex) break
                            lineBuffer += " ".repeat(spacePerWord + 1)
                            if (index < needSpaceForFirstN) {
                                lineBuffer += " "
                            }
                        }
                    } else {
                        lineBuffer += wordsForLine[0] + " ".repeat(maxWidth - wordsForLine[0].length)
                    }
                    out.add(lineBuffer)


                    lineWidth = 0
                    wordsForLine.clear()
                }

                lineWidth += word.length + 1
                wordsForLine.add(word)
            }

            if (wordsForLine.isNotEmpty()) {
                var lineBuffer = wordsForLine.joinToString(" ")
                lineBuffer += " ".repeat(maxWidth - lineBuffer.length)
                out.add(lineBuffer)
            }
            return out
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q68.Solution::fullJustify, __Serializer__::serialize, "[\"This    is    an\",\"example  of text\",\"justification.  \"]", "[\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"]", "16")
}