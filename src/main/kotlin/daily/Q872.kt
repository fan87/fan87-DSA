package daily

import TreeNode

class Q872 {

    class Solution {
        fun findLeave(node: TreeNode, leave: MutableList<Int>) {
            if (node.left == null && node.right == null) {
                leave.add(node.`val`)
            }
            if (node.left != null) {
                findLeave(node.left, leave)
            }
            if (node.right != null) {
                findLeave(node.right, leave)
            }

        }
        fun verifyLeave(node: TreeNode, verification: MutableList<Int>): Boolean {
            if (node.left == null && node.right == null) {
                if (verification.isEmpty()) return false
                return verification.removeAt(0) == node.`val`
            } else if (node.left != null && node.right == null) {
                return verifyLeave(node.left, verification)
            } else if (node.left == null && node.right != null) {
                return verifyLeave(node.right, verification)
            } else {
                return verifyLeave(node.left, verification) && verifyLeave(node.right, verification)
            }
        }

        fun leafSimilar(root1: TreeNode, root2: TreeNode): Boolean {
            val firstLeave = ArrayList<Int>()

            findLeave(root1, firstLeave)
            return verifyLeave(root2, firstLeave) && firstLeave.isEmpty()
        }
    }
}