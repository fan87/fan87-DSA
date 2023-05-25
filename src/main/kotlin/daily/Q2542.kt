package daily

import java.util.PriorityQueue

class Q2542 {

    class Solution {
        fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
            val sorted = nums1.zip(nums2).sortedByDescending { it.second }

            val queue = PriorityQueue<Int>()
            var currentSum = 0L
            var answer = 0L
            for (pair in sorted) {
                queue.add(pair.first)
                currentSum += pair.first
                if (queue.size > k) {
                    currentSum -= queue.poll()
                }
                if (queue.size == k) {
                    answer = maxOf(answer, currentSum * pair.second)
                }
            }

            return answer
        }
    }

}