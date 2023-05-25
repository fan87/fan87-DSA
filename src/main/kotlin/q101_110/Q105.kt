package q101_110

import TreeNode

class Q105 {

    class Solution {
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            if (preorder.isEmpty()) return null
            if (inorder.isEmpty()) return null
            val mid = preorder[0]

            val leftSize = inorder.indexOf(mid)
            val out = TreeNode(mid)
            out.left = buildTree(
                preorder.toList().subList(1, leftSize + 1).toIntArray(),
                inorder.toList().subList(0, leftSize).toIntArray()
            )
            out.right = buildTree(
                preorder.toList().subList(leftSize + 1, preorder.size).toIntArray(),
                inorder.toList().subList(leftSize + 1, inorder.size).toIntArray()
            )
            return out
        }
    }

}