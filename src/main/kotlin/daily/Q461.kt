package daily

class Q461 {

    class Solution {

        fun hammingDistance(x: Int, y: Int): Int {
            val output = x.xor(y)
            return output.toString(2).count { it == '1' }
        }

    }

}