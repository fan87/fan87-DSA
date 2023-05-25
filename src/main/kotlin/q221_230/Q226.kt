package q221_230

import TreeNode

class Q226 {

    class Solution {
        fun invertTree(root: TreeNode?): TreeNode? {
            if (root == null) return null
            invertTree(root.left)
            invertTree(root.right)
            val tmp = root.left
            root.left = root.right
            root.right = tmp
            return root
        }
    }

}