package q21_30

class Q29 {

    class Solution {
        fun divide(dividend: Int, divisor: Int): Int {
            return (dividend.toLong() / divisor.toLong()).coerceAtLeast(Int.MIN_VALUE.toLong()).coerceAtMost(Int.MAX_VALUE.toLong()).toInt()
        }
    }
}