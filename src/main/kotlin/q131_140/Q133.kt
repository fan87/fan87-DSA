package q131_140

class Q133 {
    class Node(var `val`: Int) {
           var neighbors: ArrayList<Node?> = ArrayList()
    }
    class Solution {
        val cloneMap = HashMap<Node, Node>()

        fun cloneGraph(node: Node?): Node? {
            return node?.clone()
        }

        fun Node.clone(): Node {
            var theNode = cloneMap[this]
            if (theNode == null) {
                theNode = Node(this.`val`)
                cloneMap[this] = theNode
                theNode.neighbors.addAll(neighbors.map { neighbor -> neighbor?.clone() })
            }
            return theNode
        }
    }

}