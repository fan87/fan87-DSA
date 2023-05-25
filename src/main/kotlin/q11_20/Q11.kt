package q11_20

class Q11 {
    class Solution {
        fun maxArea(height: IntArray): Int {
            var currentVolume = 0
            var leftIndex = 0
            var rightIndex = height.size - 1

            while (leftIndex < rightIndex) {
                val volume = (rightIndex - leftIndex) * minOf(height[rightIndex], height[leftIndex])
                if (height[leftIndex] < height[rightIndex]) {
                    leftIndex++
                } else {
                    rightIndex--
                }
                currentVolume = maxOf(volume, currentVolume)
            }
            return currentVolume
        }
    }
}