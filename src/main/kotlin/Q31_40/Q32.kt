package Q31_40

import java.util.Stack

class Q32 {

    class Solution {
        fun longestValidParentheses(s: String): Int {
            val pairs = IntArray(s.length) { Int.MIN_VALUE }
            val stacks = Stack<Int>()
            for ((index, c) in s.withIndex()) {
                if (c == ')') {
                    if (stacks.isEmpty()) {
                        stacks.clear()
                    } else {
                        val pairStart = stacks.pop()
                        val pairEnd = index
                        if (pairStart > 0 && pairs[pairStart - 1] != Int.MIN_VALUE) {
                            pairs[pairEnd] = pairs[pairStart - 1]
                            pairs[pairStart - 1] = Int.MIN_VALUE
                        } else {
                            pairs[pairEnd] = pairStart
                        }
                    }
                }
                if (c == '(') {
                    stacks.push(index)
                }
            }

            if (pairs.isEmpty()) return 0
            return pairs.withIndex().filter { it.value != Int.MIN_VALUE }.map { it.index - it.value + 1 }.let { if (it.isEmpty()) return 0 else it }.max()!!
        }
    }

}

fun main() {
    println(Q32.Solution().longestValidParentheses("("))
    println(Q32.Solution().longestValidParentheses("()()"))
    println(Q32.Solution().longestValidParentheses("((())()))"))
}