package q131_140

import __Serializer__
import testing.LeetTest
import kotlin.random.Random

class Q134 {

    class Solution {
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            val diffs = gas.mapIndexed { index, i -> i - cost[index] }
            var sum = 0
            var currentValue = 0
            var out = 0
            for ((index, diff) in diffs.withIndex()) {
                sum += diff
                currentValue += diff
                if (currentValue < 0) {
                    currentValue = 0
                    out = index + 1
                }
            }
            return if (sum >= 0) out else -1
        }


        fun verify(gas: IntArray, cost: IntArray, beginIndex: Int): Boolean {
            var currentIndex = beginIndex
            var currentGas = 0
            while (true) {
                currentGas += gas[currentIndex]
                currentGas -= cost[currentIndex]
                if (currentGas < 0) {
                    return false
                }
                currentIndex = (currentIndex + 1) % gas.size
                if (currentIndex == beginIndex) return true
            }
        }

        fun workingVerify(gas: IntArray, cost: IntArray): Int {
            for (beginIndex in gas.indices) {
                if (verify(gas, cost, beginIndex)) return beginIndex
            }
            return -1
        }
    }

}

const val GENERATED_TESTS = 0

fun main() {
    LeetTest.assertReturn(Q134.Solution::canCompleteCircuit, __Serializer__::serialize, "3", "[1,2,3,4,5]", "[3,4,5,1,2]")
    LeetTest.assertReturn(Q134.Solution::canCompleteCircuit, __Serializer__::serialize, "-1", "[2,3,4]", "[3,4,3]")
    LeetTest.assertReturn(Q134.Solution::canCompleteCircuit, __Serializer__::serialize, "4", "[5,1,2,3,4]", "[4,4,1,5,1]")
    LeetTest.assertReturn(Q134.Solution::canCompleteCircuit, __Serializer__::serialize, "3", "[5,8,2,8]", "[6,5,6,6]")
    LeetTest.hideSuccess = true

    for (i in 0 until GENERATED_TESTS) {
        val amount = Random.nextInt(5, 10)
        val gas = IntArray(amount) { Random.nextInt(90, 105) }
        val cost = IntArray(amount) { Random.nextInt(100) }
        val expected = __Serializer__.serialize(Q134.Solution().workingVerify(gas, cost))
        LeetTest.assertReturn(Q134.Solution::canCompleteCircuit, __Serializer__::serialize, expected, __Serializer__.serialize(gas), __Serializer__.serialize(cost))
    }
    for (i in 0 until GENERATED_TESTS) {
        val amount = Random.nextInt(5, 10)
        val gas = IntArray(amount) { Random.nextInt(50, 105) }
        val cost = gas.clone()
        val expected = __Serializer__.serialize(Q134.Solution().workingVerify(gas, cost))
        LeetTest.assertReturn(Q134.Solution::canCompleteCircuit, __Serializer__::serialize, expected, __Serializer__.serialize(gas), __Serializer__.serialize(cost))
    }
}