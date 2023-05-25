package q211_220

import kotlin.math.abs

class Q219 {

    class Solution {
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            val lastSeen = HashMap<Int, Int>()
            for ((index, num) in nums.withIndex()) {
                if (num in lastSeen && abs(index - lastSeen[num]!!) <= k) {
                    return false
                }
                lastSeen[num] = index
            }
            return true
        }
    }

}