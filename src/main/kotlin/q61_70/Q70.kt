package q61_70
import kotlin.math.pow

class Q70 {

    class Solution {
        companion object {
            const val goldenRatio = 1.618033988749895
        }

        fun climbStairs(n: Int): Int {
            val n = n + 1
            val fibonacciN = ((goldenRatio.pow(n.toDouble()) - (-goldenRatio).pow(-n.toDouble())) / 2.23606797749979).toInt()
            return fibonacciN
        }
    }

}