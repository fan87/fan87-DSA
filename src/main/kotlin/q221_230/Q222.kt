package q221_230

import TreeNode

class Q222 {

    class Solution {
        fun countNodes(root: TreeNode?): Int {
            if (root == null) return 0
            return countNodes(root.left) + countNodes(root.right) + 1
        }
    }

}