package daily

import TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Q637 {

    class Solution {
        fun averageOfLevels(root: TreeNode?): DoubleArray {
            val queue = LinkedList<TreeNode>()
            if (root == null) return DoubleArray(0)
            val out = ArrayList<Double>()
            queue.add(root)
            while (queue.isNotEmpty()) {
                val previousQueueEnd = queue.size
                out.add(queue.map { it.`val`.toDouble() }.sum() / queue.size.toDouble())
                for (i in 0 until previousQueueEnd) {
                    val node = queue.poll()
                    node.left?.also { queue.add(it) }
                    node.right?.also { queue.add(it) }
                }
            }
            return out.toDoubleArray()
        }
    }

}