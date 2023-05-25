package q141_150

import __Serializer__
import testing.LeetTest
import java.util.Stack

class Q150 {

    class Solution {
        fun evalRPN(tokens: Array<String>): Int {
            val numbersStack = Stack<Int>()
            for (token in tokens) {
                if (token == "+") {
                    val second = numbersStack.pop()
                    val first = numbersStack.pop()
                    numbersStack.push(first + second)
                } else if (token == "-") {
                    val second = numbersStack.pop()
                    val first = numbersStack.pop()
                    numbersStack.push(first - second)
                } else if (token == "*") {
                    val second = numbersStack.pop()
                    val first = numbersStack.pop()
                    numbersStack.push(first * second)
                } else if (token == "/") {
                    val second = numbersStack.pop()
                    val first = numbersStack.pop()
                    numbersStack.push(first / second)
                } else {
                    numbersStack.add(token.toInt())
                }
            }
            return numbersStack.pop()
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q150.Solution::evalRPN, __Serializer__::serialize, "9", "[\"2\",\"1\",\"+\",\"3\",\"*\"]")
    LeetTest.assertReturn(Q150.Solution::evalRPN, __Serializer__::serialize, "6", "[\"4\",\"13\",\"5\",\"/\",\"+\"]")
    LeetTest.assertReturn(Q150.Solution::evalRPN, __Serializer__::serialize, "22", "[\"10\",\"6\",\"9\",\"3\",\"+\",\"-11\",\"*\",\"/\",\"*\",\"17\",\"+\",\"5\",\"+\"]")
}