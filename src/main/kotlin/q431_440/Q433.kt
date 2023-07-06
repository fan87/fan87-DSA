package q431_440

import __Serializer__
import q201_210.Q210
import testing.LeetTest

class Q433 {

    class Solution {
        fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
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

            queue.add(startGene to 0)

            while (queue.isNotEmpty()) {
                val (word, steps) = queue.removeAt(0)
                for (s in bank) {
                    if (s in visited) continue
                    if (canMutate(word, s)) {
                        if (s == endGene) {
                            return steps + 1
                        }
                        queue.add(s to steps + 1)
                        visited.add(s)
                    }
                }
            }
            return -1
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q433.Solution::minMutation, __Serializer__::serialize, "1", "AACCGGTT", "AACCGGTA", "[\"AACCGGTA\"]")
    LeetTest.assertReturn(Q433.Solution::minMutation, __Serializer__::serialize, "-1", "AACCGGTT", "AACCGGTA", "[]")
    LeetTest.assertReturn(Q433.Solution::minMutation, __Serializer__::serialize, "2", "AACCGGTT", "AAACGGTA", "[\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]")

}