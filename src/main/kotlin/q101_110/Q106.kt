package q101_110

import TreeNode

class Q106 {

    // TODO: Include startIndex and endIndex in parameters, so it will be much much faster
    class Solution {
        fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
            if (inorder.isEmpty()) return null
            if (postorder.isEmpty()) return null
            val mid = postorder[postorder.size - 1]

            val leftSize = inorder.indexOf(mid)
            val out = TreeNode(mid)
            out.left = buildTree(
                inorder.toList().subList(0, leftSize).toIntArray(),
                postorder.toList().subList(0, leftSize).toIntArray()
            )
            out.right = buildTree(
                inorder.toList().subList(leftSize + 1, inorder.size).toIntArray(),
                postorder.toList().subList(leftSize + 1, postorder.size - 1).toIntArray()
            )
            return out
        }
    }

}