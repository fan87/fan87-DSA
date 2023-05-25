package q61_70

class Q69 {

    class Solution {
        fun mySqrt(x: Int): Int {
            var left = 1
            var right = x

            while (left <= right) {
                val mid = (right - left) / 2 + left
                val target = x / mid
                if (target == mid) {
                    return mid
                } else if (target > mid) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }

            }
            return left
        }
    }

}

fun main() {
    println(Q69.Solution().mySqrt(4))
    println(Q69.Solution().mySqrt(8))
}