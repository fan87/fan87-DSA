package assessment

import TreeNode
import java.util.Stack

class Q1080 {

    class Solution {
        fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {

            var pathSum = 0
            fun visit(node: TreeNode?): Boolean {
                if (node == null) return false

                // If it's leaf
                // Check the sum
                // Return false if the sum is less than the limit, otherwise, true
                if (node.left == null && node.right == null) {
                    return pathSum + node.`val` > limit
                } else {
                    // If it's not leaf
                    // Check the left and right side
                    // If one of them is false, it's gonna cut that
                    // If two of them are both false, returns false
                    pathSum += node.`val`
                    val left = visit(node.left)
                    val right = visit(node.right)
                    pathSum -= node.`val`
                    if (!left) {
                        node.left = null
                    }
                    if (!right) {
                        node.right = null
                    }
                    return left || right
                }
            }

            visit(root)

            return root
        }
    }

}