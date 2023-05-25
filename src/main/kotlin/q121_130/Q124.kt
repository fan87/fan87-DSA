package q121_130

import TreeNode

class Q124 {

    // TODO: MaxPathSum - Skidded a little bit
    class Solution {
        fun maxPathSum(root: TreeNode?): Int {
            var maximum = Int.MIN_VALUE

            fun visit(node: TreeNode?): Int {
                if (node == null) return 0

                val leftSum = visit(node.left).coerceAtLeast(0)
                val rightSum = visit(node.right).coerceAtLeast(0)

                maximum = maxOf(leftSum + rightSum + node.`val`, maximum)
                maximum = maxOf(leftSum + rightSum, maximum)

                return leftSum + rightSum + node.`val`
            }

            visit(root)

            return maximum
        }
    }

}