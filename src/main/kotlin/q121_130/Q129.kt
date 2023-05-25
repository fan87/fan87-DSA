package q121_130

import TreeNode
import java.util.Stack
import kotlin.math.pow

class Q129 {

    class Solution {
        fun sumNumbers(root: TreeNode?): Int {
            val path = Stack<Int>()
            var sum = 0

            fun visit(node: TreeNode?) {
                if (node == null) return
                path.push(node.`val`)
                if (node.left == null && node.right == null) {
                    var totalValue = 0
                    for ((index, i) in path.reversed().withIndex()) {
                        totalValue += i * 10.0.pow(index + 1.0).toInt()
                    }
                    sum += totalValue
                } else {
                    visit(node.left)
                    visit(node.right)
                }
                path.pop()
            }
            visit(root)
            return sum
        }
    }

}