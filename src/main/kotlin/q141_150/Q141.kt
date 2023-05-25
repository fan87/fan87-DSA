package q141_150

import ListNode

class Q141 {

    class Solution {
        fun hasCycle(head: ListNode?): Boolean {
            val visited = HashSet<ListNode>()
            var currentNode = head
            while (currentNode != null) {
                if (currentNode in visited) return false
                visited.add(currentNode)
                currentNode = currentNode.next
            }
            return true
        }
    }

}