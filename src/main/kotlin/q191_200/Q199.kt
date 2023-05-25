package q191_200

import TreeNode
import q111_120.Q117
import java.util.LinkedList
import java.util.Queue

class Q199 {

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        fun rightSideView(root: TreeNode?): List<Int> {
            val queue = LinkedList<TreeNode>()
            if (root == null) return emptyList()
            val out = ArrayList<Int>()
            queue.add(root)
            while (queue.isNotEmpty()) {
                val previousQueueEnd = queue.size
                out.add(queue[queue.lastIndex].`val`)
                for (i in 0 until previousQueueEnd) {
                    val node = queue.poll()
                    node.left?.also { queue.add(it) }
                    node.right?.also { queue.add(it) }
                }
            }
            return out
        }
    }

}