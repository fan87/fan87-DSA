package q221_230

import __Serializer__
import testing.LeetTest

class Q228 {

    class Solution {
        fun summaryRanges(nums: IntArray): List<String> {
            val out = ArrayList<String>()
            if (nums.isEmpty()) return arrayListOf()

            var previous: Int? = nums[0]
            var from: Int? = previous
            for (index in  1 until nums.size) {
                val num = nums[index]
                if (previous == null || previous + 1 != num) {
                    if (previous == from) {
                        out.add("$previous")
                    } else {
                        out.add("$from->$previous")
                    }
                    from = num
                }
                previous = num
            }
            if (previous == from) {
                out.add("$previous")
            } else {
                out.add("$from->$previous")
            }
            return out
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q228.Solution::summaryRanges, __Serializer__::serialize, "[\"0->2\",\"4->5\",\"7\"]", "[0,1,2,4,5,7]")
    LeetTest.assertReturn(Q228.Solution::summaryRanges, __Serializer__::serialize, "[\"0\",\"2->4\",\"6\",\"8->9\"]", "[0,2,3,4,6,8,9]")
}