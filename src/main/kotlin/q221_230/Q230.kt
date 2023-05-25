package q221_230

import TreeNode

class Q230 {

    class Solution {
        fun kthSmallest(root: TreeNode?, k: Int): Int {
            if (root == null) return 0
            var out = Int.MAX_VALUE
            var mutableK = k

            fun visit(treeNode: TreeNode?) {
                if (treeNode == null) return
                if (out == Int.MAX_VALUE) {
                    return
                }
                visit(treeNode.left)
                mutableK--
                if (mutableK == 0 && out == Int.MAX_VALUE) {
                    out = treeNode.`val`
                    return
                }
                visit(treeNode.right)
            }

            visit(root)
            return out
        }
    }

}