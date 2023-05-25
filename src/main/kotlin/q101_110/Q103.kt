package q101_110

import TreeNode
import java.util.LinkedList

class Q103 {

    class Solution {
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            val queue = LinkedList<TreeNode>()
            if (root == null) return emptyList()
            val out = ArrayList<List<Int>>()
            var reversed = false
            queue.add(root)
            while (queue.isNotEmpty()) {
                val previousQueueEnd = queue.size
                if (reversed) {
                    out.add(queue.map { it.`val` }.reversed())
                } else {
                    out.add(queue.map { it.`val` })
                }
                reversed = !reversed
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