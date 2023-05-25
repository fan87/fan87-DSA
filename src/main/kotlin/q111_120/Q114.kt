package q111_120

import TreeNode

class Q114 {

    class Solution {
        fun flatten(root: TreeNode?) {
            if (root == null) return
            flatten(root.left)
            flatten(root.right)
            val oldRight = root.right
            root.right = root.left
            var currentNode: TreeNode? = root.left
            var leaf = currentNode
            while (currentNode != null) {
                leaf = currentNode
                currentNode = currentNode.right
            }
            if (leaf != null)
                leaf?.right = oldRight
            else
                root?.right = oldRight
            root.left = null
        }
    }

}