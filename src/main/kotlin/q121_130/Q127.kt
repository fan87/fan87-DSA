package q121_130

import __Serializer__
import q431_440.Q433
import testing.LeetTest

class Q127 {

    class Solution {
        fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
            fun canMutate(from: String, to: String): Boolean {
                var charMod = false
                for ((index, c) in from.withIndex()) {
                    if (to[index] != c) {
                        if (charMod) return false
                        charMod = true
                    }
                }
                return true
            }

            val visited = HashSet<String>()
            val queue = ArrayList<Pair<String, Int>>()

            queue.add(beginWord to 1)

            while (queue.isNotEmpty()) {
                val (word, steps) = queue.removeAt(0)
                for (s in wordList) {
                    if (s in visited) continue
                    if (canMutate(word, s)) {
                        if (s == endWord) {
                            return steps + 1
                        }
                        queue.add(s to steps + 1)
                        visited.add(s)
                    }
                }
            }
            return 0
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q127.Solution::ladderLength, __Serializer__::serialize, "5", "hit", "cog", "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]")
    LeetTest.assertReturn(Q127.Solution::ladderLength, __Serializer__::serialize, "0", "hit", "cog", "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]")

}