package q41_50

class Q46 {

    // TODO: Make it faster by using "Set" for visited values
    class Solution {
        fun permute(nums: IntArray): List<List<Int>> {
            if (nums.size == 1) return listOf(listOf(nums[0]))
            val out = ArrayList<List<Int>>()
            for (num in nums) {
                for (ints in permute(nums.filter { it != num }.toIntArray())) {
                    val converted = ints.toTypedArray()
                    out.add(listOf(num, *converted))
                }
            }

            return out
        }

    }


}

fun main() {
    println(Q46.Solution().permute(intArrayOf(1, 2, 3)))
}