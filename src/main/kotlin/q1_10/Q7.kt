package q1_10

import kotlin.math.absoluteValue

class Q7 {

    class Solution {
        fun reverse(x: Int): Int {
            val longValue = x.toLong().absoluteValue.toString().reversed().toLong()
            if (longValue > Int.MAX_VALUE) return 0
            if (x < 0) {
                return -1 * (longValue.toInt())
            }
            return longValue.toInt()
        }
    }
}

fun main() {
    println(Q7.Solution().reverse(-2147483648))
}