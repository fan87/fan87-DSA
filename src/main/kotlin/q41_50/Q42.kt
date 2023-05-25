package q41_50

import java.util.Stack

class Q42 {
    fun trap1(height: IntArray): Int {
        val heightStack = Stack<Int>()
        var output = 0
        var leftWallPosition = -1
        val maxHeight = height.max()!!
        for (y in 0 until maxHeight) {
            for (x in height.indices) {
                if (height[x] > y) { // Has block in current height
                    if (leftWallPosition >= 0) {
                        output += x - leftWallPosition - 1
                        leftWallPosition += 1
                    }
                    leftWallPosition = x
                }
            }
            leftWallPosition = -1
            heightStack.clear()
        }
        return output
    }
    fun bruteforce(height: IntArray): Int {
        val heightInfo = IntArray(height.max()!!) {-1}
        var output = 0
        for ((index, value) in height.withIndex()) {
            if (value == 0) {
                continue
            }
            for (i in 0 until value) {
                if (heightInfo[i] != -1) {
                    output += index - heightInfo[i]  - 1
                }
                heightInfo[i] = index
            }
        }
        return output
    }
    fun skidded(height: IntArray): Int {
        val stack = Stack<Int>()
        var out = 0
        for (current in height.indices) {
            println("Current $current  Stack $stack")
            while (stack.isNotEmpty() && height[current] > height[stack.peek()]) {
                val peek = stack.peek()
                stack.pop()
                if (stack.isEmpty()) break
                val distance = current - stack.peek() - 1
                val boundHeight = minOf(height[current], height[stack.peek()]) - height[peek]
                out += distance * boundHeight
                println("Found boundary with size ${boundHeight * distance} (Height: $boundHeight) from ${stack.peek()} to $current")
            }
            stack.push(current)
        }
        return out
    }
    // TODO: Practice
    class Solution {

        fun trap(height: IntArray): Int {
            var maxLeft = 0
            var maxRight = 0
            var maxRightIndex = 0
            var answer = 0
            for ((index, value) in height.withIndex()) {
                if (maxRightIndex <= index) {
                    maxRightIndex = Int.MAX_VALUE
                    maxRight = 0
                    for (indexedValue in height.indices) {
                        if (indexedValue <= index) continue
                        if (height[indexedValue] > maxRight) {
                            maxRight = height[indexedValue]
                            maxRightIndex = indexedValue
                        }
                    }


                    println("Updated max right to $maxRight")
                }
                answer += (minOf(maxLeft, maxRight) - value).coerceAtLeast(0)
                println("${(minOf(maxLeft, maxRight) - value).coerceAtLeast(0)} at slot $index  ($maxLeft/${maxRight})  $value")
                maxLeft = maxOf(maxLeft, value)
            }
            return answer
        }
    }

}

fun main() {
}