package q111_120

import TreeNode
import java.util.*
import kotlin.math.pow

class Q112 {

    class Solution {
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            var sum = 0
            var found = false

            fun visit(node: TreeNode?) {
                if (node == null) return
                if (found) return
                sum += node.`val`
                if (node.left == null && node.right == null) {
                    if (sum == targetSum) {
                        found = true
                        return
                    }
                } else {
                    visit(node.left)
                    visit(node.right)
                }
                sum -= node.`val`
            }
            visit(root)
            return found
        }
    }

}