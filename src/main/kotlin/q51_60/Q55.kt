package q51_60

class Q55 {

    class Solution {
        // 143113082700018418728
        fun canJump(nums: IntArray): Boolean {
            val possible = BooleanArray(nums.size)
            var currentIndex = nums.size - 1
            possible[currentIndex] = true
            currentIndex -= 1
            while (currentIndex >= 0) {
                if (currentIndex + nums[currentIndex] >= nums.size - 1) {
                    possible[currentIndex] = true
                } else {
                    for (i in 0 until nums[currentIndex]) {
                        if (possible[i + currentIndex + 1]) {
                            possible[currentIndex] = true
                            break
                        }
                    }
                }

                currentIndex -= 1
            }
            return possible[0]
        }
    }

}

fun main() {
    println(Q55.Solution().canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(Q55.Solution().canJump(intArrayOf(3, 2, 1, 0, 4)))
    println(Q55.Solution().canJump(intArrayOf(3, 2, 1, 10, 4)))
}