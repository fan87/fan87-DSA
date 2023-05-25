package daily

class Q837 {

    class Solution {
        fun new21Game(n: Int, k: Int, maxPts: Int): Double {
            if (k == 0 || n >= k + maxPts) {
                return 1.0
            }

            val dp = DoubleArray(n + 1)
            dp[0] = 1.0
            var rs = 1.0
            var answer = 0.0

            for (i in 1..n) {
                dp[i] = rs / maxPts
                if (i < k) {
                    rs += dp[i]
                } else {
                    answer += dp[i]
                }
                if (i - maxPts >= 0) {
                    rs -= dp[i - maxPts]
                }
            }

            return answer
        }
    }

}