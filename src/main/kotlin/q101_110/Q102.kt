package q101_110

import TreeNode
import java.util.LinkedList

class Q102 {

    class Solution {
        fun levelOrder(root: TreeNode?): List<List<Int>> {
            val queue = LinkedList<TreeNode>()
            if (root == null) return emptyList()
            val out = ArrayList<List<Int>>()
            queue.add(root)
            while (queue.isNotEmpty()) {
                val previousQueueEnd = queue.size
                out.add(queue.map { it.`val` })
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