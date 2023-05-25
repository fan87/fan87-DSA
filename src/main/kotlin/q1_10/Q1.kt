package q1_10

class Q1 {
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
                            //  Remain, Index
            val toAdd = HashMap<Int, Int>(nums.size)
            nums.withIndex().forEach {
                if (it.value in toAdd) {
                    return intArrayOf(it.index, toAdd[it.value]!!)
                }
                toAdd[target - it.value] = it.index
            }
            throw IllegalArgumentException("Invalid input")
        }
    }
}