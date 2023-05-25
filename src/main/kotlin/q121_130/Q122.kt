package q121_130

class Q122 {

    class Solution {
        fun maxProfit(prices: IntArray): Int {
            var buyPrice = -1
            var maxSellPrice = -1
            var previousPrice = Int.MAX_VALUE
            var profit = 0

            for (value in prices) {
                if (value < previousPrice) {
                    if (buyPrice != -1) {
                        profit += previousPrice - buyPrice
                    }
                    buyPrice = value
                    maxSellPrice = value
                }
                previousPrice = value
                maxSellPrice = maxSellPrice.coerceAtLeast(value)
            }
            if (maxSellPrice > buyPrice) {
                profit += maxSellPrice - buyPrice
            }
            return profit
        }
    }
}

fun main() {
    println(Q122.Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(Q122.Solution().maxProfit(intArrayOf(7, 1, 5, 2, 3, 4, 6, 2, 1)))
    println(Q122.Solution().maxProfit(intArrayOf(1,2,3,4,5)))
}