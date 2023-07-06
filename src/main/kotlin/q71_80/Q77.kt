package q71_80

import __Serializer__
import q121_130.Q127
import testing.LeetTest
import java.net.URLClassLoader
import java.util.Stack

class Q77 {

    class Solution {
        fun combine(n: Int, k: Int): List<List<Int>> {
            val out = ArrayList<List<Int>>()
            val stack = Stack<Int>()
            fun loop(from: Int) {
                for (first in from..n) {
                    stack.push(first)
                    if (stack.size <= k) {
                        loop(first + 1)
                    } else {
                        out.add(stack.toList())
                    }
                    stack.pop()
                }
            }
            loop(1)

            return out
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q77.Solution::combine, __Serializer__::serialize, "[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]", "4", "2")
    LeetTest.assertReturn(Q77.Solution::combine, __Serializer__::serialize, "[[1]]", "1", "1")

}