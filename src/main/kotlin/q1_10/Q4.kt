package q1_10

class Q4 {

    class Solution {

        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            var indexnums1 = 0
            var indexnums2 = 0
            val merged = IntArray(nums1.size + nums2.size)
            var index = 0

            val nums1size = nums1.count()
            val nums2size = nums2.count()

            while (indexnums1 < nums1size && indexnums2 < nums2size) {
                if (nums1[indexnums1] <= nums2[indexnums2])
                    merged[index++] = nums1[indexnums1++]
                else
                    merged[index++] = nums2[indexnums2++]
            }

            while (indexnums1 < nums1.size) merged[index++] = (nums1[indexnums1++])
            while (indexnums2 < nums2.size) merged[index++] = (nums2[indexnums2++])

            val mid = merged.size / 2

            return if (merged.size % 2 == 0) {
                (merged[mid] + merged[mid - 1]) / 2.0
            } else {
                merged[mid].toDouble()
            }
        }
    }

}

fun main() {
    println(Q4.Solution().findMedianSortedArrays(intArrayOf(2), intArrayOf(1, 3, 4)))
    println(Q4.Solution().findMedianSortedArrays(intArrayOf(0, 0), intArrayOf(0, 0)))
    println(Q4.Solution().findMedianSortedArrays(intArrayOf(3), intArrayOf(-2, -1)))
}