package q221_230

import __Serializer__
import testing.LeetTest
import java.util.*

class Q224 {

    class Solution {


        fun calculate(s: String): Int {
            var acc = 0
            var i = 0

            val signStack = LinkedList<Int>()

            var bracketSign = 1
            var prevSign = 1

            while (i < s.length) {
                when (s[i]) {
                    ' ' -> {}
                    '(' -> {
                        signStack.push(prevSign)
                        if (prevSign < 0)
                            bracketSign *= -1
                        prevSign = 1
                    }
                    ')' -> if (signStack.pop() < 0) bracketSign *= -1
                    '+' ->  prevSign = 1
                    '-' -> prevSign = -1
                    else -> {
                        var n = 0
                        while (i < s.length && '0' <= s[i] && s[i] <= '9') {
                            n = n * 10 + (s[i] - '0')
                            i++
                        }
                        i--
                        acc += n * bracketSign * prevSign
                    }
                }
                i++
            }

            return acc
        }
    }

}



fun main() {
    LeetTest.assertReturn(Q224.Solution::calculate, __Serializer__::serialize, "2", "1 + 1")
    LeetTest.assertReturn(Q224.Solution::calculate, __Serializer__::serialize, "2", "1 - (-1)")
    LeetTest.assertReturn(Q224.Solution::calculate, __Serializer__::serialize, "23", "(1+(4+5+2)-3) + (6+8)")
    LeetTest.assertReturn(Q224.Solution::calculate, __Serializer__::serialize, "-13", "-(5 + 8)")
}