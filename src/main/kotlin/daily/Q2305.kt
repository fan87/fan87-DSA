package daily

import __Serializer__
import testing.LeetTest
import kotlin.math.min

class Q2305 {

    class Solution {
        fun distributeCookies(cookies: IntArray, k: Int): Int {

            var unfairness = Int.MAX_VALUE

            // Layer = the bag of cookie
            fun dfs(distributedCookiesCount: IntArray, layer: Int) {
                if (layer == cookies.size) {
                    unfairness = min(distributedCookiesCount.max(), unfairness)
                    return
                }
                for (i in 0 until k) {
                    distributedCookiesCount[i] += cookies[layer]
                    dfs(distributedCookiesCount, layer + 1)
                    distributedCookiesCount[i] -= cookies[layer]
                }
            }

            dfs(IntArray(k), 0)

            return unfairness
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q2305.Solution::distributeCookies, __Serializer__::serialize, "31", "[8,15,10,20,8]", "2")
    LeetTest.assertReturn(Q2305.Solution::distributeCookies, __Serializer__::serialize, "7", "[6,1,3,2,2,4,1,2]", "3")
}