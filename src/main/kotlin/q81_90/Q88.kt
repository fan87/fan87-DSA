package q81_90

import java.util.Random

// Skipped to 88 since it's interview question
class Q88 {

    class Solution {
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
            var currentIndex = 0
            val out = IntArray(m + n)
            var aPointer = 0
            var bPointer = 0

            while (aPointer < m && bPointer < n) {
                val firstValue = nums1[aPointer]
                while (bPointer < n && nums2[bPointer] <= firstValue) {
                    out[currentIndex++] = nums2[bPointer]
                    bPointer++
                }
                out[currentIndex++] = firstValue
                aPointer++
            }
            if (bPointer < n) {
                System.arraycopy(nums2, bPointer, out, currentIndex, n - bPointer)
                println("B hasn't reached the end yet")
            }

            if (aPointer < m) {
                System.arraycopy(nums1, aPointer, out, currentIndex, m - aPointer)
                println("A hasn't reached the end yet")
            }
            System.arraycopy(out, 0, nums1, 0, m + n)
        }
    }

}

fun main() {
    run {
        val out = intArrayOf(1, 2, 3, 0, 0, 0)
        Q88.Solution().merge(
            out, 3,
            intArrayOf(2, 5, 6), 3,
        )
        println(out.joinToString(", "))
    }
    run {
        val out = intArrayOf(2, 5, 6, 0, 0, 0)
        Q88.Solution().merge(
            out, 3,
            intArrayOf(1, 2, 3), 3,
        )
        println(out.joinToString(", "))
    }
}