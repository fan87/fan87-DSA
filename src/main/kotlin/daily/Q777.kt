package daily

import __Serializer__
import testing.LeetTest

class Q777 {

    class Solution {
        fun canTransform(start: String, end: String): Boolean {
            if (start.replace("X", "") != end.replace("X", "")) return false

            var leftQuota = 0
            var rightQuota = 0
            for ((index, c) in start.withIndex()) {
                if (c == 'L') {
                    leftQuota--
                    if (leftQuota < 0) {
                        return false
                    }
                }
                if (end[index] == 'L') {
                    leftQuota++
                }
                if (c == 'R') {
                    rightQuota++
                }
                if (end[index] == 'R') {
                    rightQuota--
                    if (rightQuota < 0) {
                        return false
                    }
                }
            }

            return true

        }
    }

}

fun main() {
    LeetTest.assertReturn(Q777.Solution::canTransform, __Serializer__::serialize, "false", "RL", "LR")
    LeetTest.assertReturn(Q777.Solution::canTransform, __Serializer__::serialize, "false", "X", "L")
    LeetTest.assertReturn(Q777.Solution::canTransform, __Serializer__::serialize, "true", "RXXLRXRXL", "XRLXXRRLX")
    LeetTest.assertReturn(Q777.Solution::canTransform, __Serializer__::serialize, "false", "LXXLXRLXXL", "XLLXRXLXLX")
    // LLRLL  LLRLL
    LeetTest.assertReturn(Q777.Solution::canTransform, __Serializer__::serialize, "false", "XXRXL", "LXRXX")
    // LXXLXRLXXL
    // XLLXRXLXLX

    // LXXLXRLXXL
    // LXLXRXLXLX
}