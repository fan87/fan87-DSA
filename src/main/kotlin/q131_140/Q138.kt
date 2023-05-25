package q131_140

class Q138 {


    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    class Solution {
        fun copyRandomList(node: Node?): Node? {
            val nodesLookup = HashMap<Node, Node>()

            var currentNode = node
            while (currentNode != null) {
                nodesLookup[currentNode] = Node(currentNode.`val`)
                currentNode = currentNode.next
            }
            currentNode = node

            while (currentNode != null) {
                nodesLookup[currentNode]!!.next = currentNode.next?.let { nodesLookup[it] }
                nodesLookup[currentNode]!!.random = currentNode.random?.let { nodesLookup[it] }
                currentNode = currentNode.next
            }

            return nodesLookup[node]
        }
    }

}