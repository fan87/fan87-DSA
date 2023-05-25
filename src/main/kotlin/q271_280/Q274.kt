package q271_280

import __Deserializer__
import __Serializer__
import testing.LeetTest

class Q274 {

    // TODO: Sorta learned h-index from another example, try re-solving it
    class Solution {
        // Translate: `h` elements in number array that is at least `h`
        // `h` having maximum value of the size of number array
        fun hIndex(citations: IntArray): Int {
            val availableCitationsCount = IntArray(citations.size + 1)
            for (citation in citations) {
                availableCitationsCount[citation.coerceAtMost(citations.size)] += 1
            }

            var sumForCurrentMax = 0
            for (i in availableCitationsCount.indices.reversed()) {
                sumForCurrentMax += availableCitationsCount[i]
                if (sumForCurrentMax >= i) {
                    return i
                }
            }
            return sumForCurrentMax
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q274.Solution::hIndex, __Serializer__::serialize, "3", "[3,0,6,1,5]")
    LeetTest.assertReturn(Q274.Solution::hIndex, __Serializer__::serialize, "1", "[1,3,1]")
    LeetTest.assertReturn(Q274.Solution::hIndex, __Serializer__::serialize, "1", "[1,1]")
    LeetTest.assertReturn(Q274.Solution::hIndex, __Serializer__::serialize, "1", "[1]")
}
