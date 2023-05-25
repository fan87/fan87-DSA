package q201_210

class Q202 {

    class Solution {
        fun getHappyThingy(n: Int): Int {
            var mutableN = n
            var totalSum = 0
            while (mutableN > 0) {
                val digit = mutableN % 10
                totalSum += digit * digit
                mutableN /= 10
            }
            return totalSum
        }

        fun isHappy(n: Int): Boolean {
            val seen = HashSet<Int>()
            var mutableN = n
            while (mutableN != 1) {
                if (mutableN in seen) {
                    return false
                }
                seen.add(mutableN)
                mutableN = getHappyThingy(mutableN)
            }
            return true
        }
    }

}