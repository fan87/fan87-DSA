package q41_50

class Q47 {

    // TODO: Make it faster by using completely different strategy
    class Solution {
        fun permuteUnique(nums: IntArray, visitedIndex: MutableSet<Int> = HashSet()): List<List<Int>> {
            if (nums.size - 1 == visitedIndex.size) return listOf(listOf(nums.filterIndexed { index, i -> index !in visitedIndex }.first()))
            val out = ArrayList<List<Int>>()
            val evaluated = HashSet<Int>()
            for ((index, num) in nums.withIndex()) {
                if (num in evaluated) {
                    continue
                }
                if (index in visitedIndex) { // The number is already used
                    continue
                }
                evaluated.add(num)
                println("Index: $index, Visited: $visitedIndex")
                visitedIndex.add(index)
                for (ints in permuteUnique(nums, visitedIndex)) {
                    val converted = ints.toTypedArray()
                    out.add(listOf(num, *converted))
                }
                visitedIndex.remove(index)
            }

            return out
        }

    }


}

fun main() {
    println(Q47.Solution().permuteUnique(intArrayOf(1, 1, 2)))
}