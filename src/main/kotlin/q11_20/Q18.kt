package q11_20

class Q18 {

    class Solution {
        fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
            nums.sort()

            val out = HashSet<List<Int>>()
            for ((index2, value2) in nums.withIndex()) {
                for ((index, value) in nums.withIndex().filter { it.index > index2 }) {
                    var pointerA = index + 1
                    var pointerB = nums.size - 1

                    while (pointerB > pointerA) {
                        val result = nums[pointerA].toLong() + nums[pointerB].toLong() + value.toLong() + value2.toLong()
                        if (result > Int.MAX_VALUE || result < Int.MIN_VALUE) {
                            pointerB--
                            continue
                        }
                        if (result == target.toLong()) {
                            out.add(listOf(value, value2, nums[pointerA], nums[pointerB]))
                            pointerA++
                            pointerB--
                        } else if (result < target.toLong()) {
                            pointerA++
                        } else {
                            pointerB--
                        }
                    }
                }
            }

            return out.toList()
        }
    }

}