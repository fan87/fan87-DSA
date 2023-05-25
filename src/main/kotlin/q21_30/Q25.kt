package q21_30

import ListNode

class Q25 {

    class Solution {
        fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
            if (head == null) return null // Emtpy array
            if (k == 1) return head // 1 k array
            if (head.next == null) return head // Single entry array

            var newHead: ListNode? = null
            var previous: ListNode? = null
            var currentNode = head
            val toSwap = ArrayList<ListNode>()
            while (currentNode != null) {
                toSwap.add(currentNode)
                if (toSwap.size == k) {
                    if (newHead == null) newHead = toSwap.last()

                    // Swap currentNode & previous
                    currentNode = toSwap[0]
                    previous?.next = toSwap.last()

                    for ((index, value) in toSwap.withIndex()) {
                        if (index == 0) {
                            value.next = toSwap.last().next
                            continue
                        }
                        value.next = toSwap[index - 1]
                    }

                    previous = currentNode
                    toSwap.clear()
                }
                currentNode = currentNode.next
            }
            return newHead?:head
        }
    }

}

fun main() {
    println(Q25.Solution().reverseKGroup(toListNode(listOf(1, 2, 3, 4, 5)), 2)?.toList())
    println(Q25.Solution().reverseKGroup(toListNode(listOf(1, 2, 3, 4, 5)), 3)?.toList())
}
