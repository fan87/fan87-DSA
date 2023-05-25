package q341_350

class Q349 {

    class Solution {
        fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
            val num1Set = HashSet<Int>()
            num1Set.addAll(nums1.toList())

            val out = HashSet<Int>()
            for (i in nums2) {
                if (i in num1Set) out.add(i)
            }
            return out.toIntArray()
        }
    }

}