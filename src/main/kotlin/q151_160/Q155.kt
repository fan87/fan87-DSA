package q151_160

import java.util.*

class Q155 {

    // TODO: MinStack, Use a 2 way linked list?
    class MinStack() {
        val daStack = Stack<Int>()
        fun push(`val`: Int) {
            daStack.push(`val`)
        }

        fun pop() {
            daStack.pop()
        }

        fun top(): Int {
            return daStack.peek()
        }

        fun getMin(): Int {
            return daStack.min()
        }

    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * var obj = MinStack()
     * obj.push(`val`)
     * obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.getMin()
     */

}