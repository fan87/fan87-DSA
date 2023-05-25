package q121_130

class Q121 {

    class Solution {
        fun maxProfit(prices: IntArray): Int {
            var profit = 0
            var priceOnBuy = Int.MAX_VALUE
            var priceOnSell = -1
            for (price in prices) {
                if (price < priceOnBuy) {
                    if (priceOnSell != -1) {
                        profit = profit.coerceAtLeast(priceOnSell - priceOnBuy)
                        priceOnSell = -1
                    }
                    priceOnBuy = price
                } else if (price > priceOnSell) {
                    priceOnSell = price
                }
            }
            return profit.coerceAtLeast(priceOnSell - priceOnBuy)
        }
    }
}

fun main() {
    println(Q121.Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}