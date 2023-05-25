package q71_80

import __Serializer__
import testing.LeetTest
import kotlin.math.min

class Q76 {

    class Solution {
        companion object {
            val zeros = ShortArray(26*2)
            val targetWordsCounter = ShortArray(26*2)
            val indices = HashMap<Int, Int>()
        }
        inline fun getIndexOfChar(c: Char): Int {
            if (c.isLowerCase())
                return c.toInt() - 97
            else if (c.isUpperCase())
                return c.toInt() - 65 + 26
            else
                return -1
        }
        fun minWindow(s: String, t: String): String {
            var shortenedS = ""
            indices.clear()
            for ((index, c) in s.withIndex()) {
                if (c in t) {
                    indices[shortenedS.length] = index
                    shortenedS += c
                }
            }
            System.arraycopy(zeros, 0, targetWordsCounter, 0, 26*2)

            for (c in t) {
                targetWordsCounter[getIndexOfChar(c)]++
            }
            var left = 0

            var minimal: String? = null
            for ((right, c) in shortenedS.withIndex()) {
                targetWordsCounter[getIndexOfChar(c)]--

                while (targetWordsCounter.all { it <= 0 }) {
                    targetWordsCounter[getIndexOfChar(shortenedS[left])]++
                    val sub = s.substring(indices[left]!!, indices[right]!! + 1)
                    if (indices[right]!! + 1 - indices[left]!! < (minimal?.length ?: Int.MAX_VALUE)) {
                        minimal = sub
                    }
                    left++
                }
            }

            return minimal?:""
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q76.Solution::minWindow, { it }, "cwae", "cabwefgewcwaefgcf", "cae")
//    LeetTest.assertReturn(Q76.Solution::minWindow, { it }, "BANC", "ADOBECODEBANC", "ABC")
//    LeetTest.assertReturn(Q76.Solution::minWindow, { it }, "a", "a", "a")
//    LeetTest.assertReturn(Q76.Solution::minWindow, { it }, "", "a", "aa")
//    LeetTest.assertReturn(Q76.Solution::minWindow, { it }, "aa", "aa", "aa")
//    LeetTest.assertReturn(Q76.Solution::minWindow, { it }, "b", "ab", "b")

}