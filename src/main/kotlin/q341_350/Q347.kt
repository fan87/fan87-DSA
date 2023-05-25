package q341_350

class Q347 {

    class Solution {

        // TODO: Quick select when
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val count = HashMap<Int, Int>()
            for (num in nums) {
                count[num] = count.getOrDefault(num, 0) + 1
            }
            val sorted = count.entries.sortedBy { it.value }.map { it.key }
            return sorted.subList(sorted.size - k, sorted.size).toIntArray()
        }
    }

}