package q111_120

class Q117 {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }
    class Solution {
        fun connect(root: Node?): Node? {
            val queue = mutableListOf<Node>()
            if (root == null) return null
            queue.add(root)
            while (queue.isNotEmpty()) {
                val previousQueue = ArrayList(queue)
                queue.clear()
                for ((i, node) in previousQueue.withIndex()) {
                    node.next = if (i != previousQueue.lastIndex)
                                    previousQueue[i + 1]
                                else
                                    null

                    node.left?.also { queue.add(it) }
                    node.right?.also { queue.add(it) }
                }
            }
            return root
        }
    }

}