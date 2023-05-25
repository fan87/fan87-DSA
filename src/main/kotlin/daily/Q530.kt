package daily

import TreeNode

class Q530 {

    class Solution {
        fun getMinimumDifference(root: TreeNode?): Int {
            if (root == null) return 0
            var out = Int.MAX_VALUE
            var previous = out

            fun visit(treeNode: TreeNode?) {
                if (treeNode == null) return
                visit(treeNode.left)
                if (previous != Int.MAX_VALUE) {
                    out = minOf(out, treeNode.`val` - previous)
                }
                previous = treeNode.`val`
                visit(treeNode.right)
            }

            visit(root)
            return out
        }
    }

}