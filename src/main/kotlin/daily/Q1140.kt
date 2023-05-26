package daily

import __Serializer__
import testing.LeetTest

class Q1140 {

    // TODO: I shouldn't be struggling, but I did. Try again probably a few days later
    class Solution {
        private fun f(piles: IntArray, dp: Array<Array<IntArray>>, p: Int, i: Int, m: Int): Int {
            if (i == piles.size) {
                return 0
            }
            if (dp[p][i][m] != -1) {
                return dp[p][i][m]
            }
            var res = if (p == 1) 1000000 else -1
            var s = 0
            for (x in 1..Math.min(2 * m, piles.size - i)) {
                s += piles[i + x - 1]
                res = if (p == 0) {
                    Math.max(res, s + f(piles, dp, 1, i + x, Math.max(m, x)))
                } else {
                    Math.min(res, f(piles, dp, 0, i + x, Math.max(m, x)))
                }
            }
            return res.also { dp[p][i][m] = it }
        }

        fun stoneGameII(piles: IntArray): Int {
            val dp = Array(2) {
                Array(piles.size + 1) {
                    IntArray(
                        piles.size + 1
                    )
                }
            }
            for (p in 0..1) {
                for (i in 0..piles.size) {
                    for (m in 0..piles.size) {
                        dp[p][i][m] = -1
                    }
                }
            }
            return f(piles, dp, 0, 0, 1)
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q1140.Solution::stoneGameII, __Serializer__::serialize, "10", "[2,7,9,4,4]")
}