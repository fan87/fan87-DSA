package q21_30

import ListNode

class Q24 {

    class Solution {
        fun swapPairs(head: ListNode?): ListNode? {
            if (head == null) return null
            if (head.next == null) return head

            val newHead = head.next
            head.next = newHead?.next
            newHead?.next = head

            var previous = head
            var currentNode = previous.next

            while (currentNode?.next != null) {
                val first = currentNode
                val second = currentNode.next

                previous?.next = second
                first.next = second?.next
                second?.next = first

                previous = first
                currentNode = first.next
            }

            return newHead
        }
    }

}

fun main() {
    println(Q24.Solution().swapPairs(
        toListNode(listOf(1, 2, 3, 4))
    )?.toList())
}