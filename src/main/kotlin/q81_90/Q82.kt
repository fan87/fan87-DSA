package q81_90

import ListNode

class Q82 {

    class Solution {
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var currentNode = head
            var outputHead: ListNode? = null
            var outputCurrent: ListNode? = null
            while (currentNode != null) {
                var duplicated = false
                while (currentNode != null && currentNode.next?.`val` == currentNode.`val`) {
                    currentNode = currentNode.next
                    duplicated = true
                }
                if (currentNode == null) break
                if (!duplicated) {
                    if (outputHead == null) {
                        outputHead = ListNode(currentNode.`val`)
                        outputCurrent = outputHead
                    } else {
                        val newNode = ListNode(currentNode.`val`)
                        outputCurrent?.next = newNode
                        outputCurrent = newNode
                    }
                }
                currentNode = currentNode.next
            }
            return outputHead
        }
    }

}