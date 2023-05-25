package assessment

import TreeNode

class Q865 {

    class Solution {
        fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
            var depth = 0
            var deepest = 0
            val depthMap = HashMap<TreeNode, Int>()
            fun visit(node: TreeNode?): Int {
                if (node == null) return depth
                depth += 1
                deepest = maxOf(deepest, depth)
                val currentDepth = maxOf(visit(node.left), visit(node.right))
                depthMap[node] = currentDepth
                depth -= 1
                return currentDepth
            }

            var out: TreeNode? = null
            fun visit2(node: TreeNode?) {
                if (node == null) return
                val leftMaxDepth = depthMap[node.left]
                val rightMaxDepth = depthMap[node.right]
                if (out != null) return
                if (leftMaxDepth == rightMaxDepth) {
                    out = node
                } else {
                    if (leftMaxDepth != null && rightMaxDepth != null) {
                        if (leftMaxDepth > rightMaxDepth) {
                            visit2(node.left)
                        } else {
                            visit2(node.right)
                        }
                    } else {
                        visit2(node.left)
                        visit2(node.right)
                    }
                }
            }

            visit(root)
            visit2(root)
            return out
        }

    }

}