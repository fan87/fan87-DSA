package q11_20

import ListNode


class Q19 {
    class Solution {
        fun ListNode.toList(): List<Int> {
            val out = ArrayList<Int>()
            var current: ListNode? = this
            while (current != null) {
                out.add(current.`val`)
                current = current.next
            }
            return out
        }
        fun toListNode(list: List<Int>): ListNode? {
            if (list.isEmpty()) return null
            val head = ListNode(list.first())
            var current = head
            for ((index, value) in list.withIndex().filter { it.index != 0 }) {
                current.next = ListNode(value)
                current = current.next!!
            }
            return head
        }
        fun removeNthFromEnd(head: ListNode, n: Int): ListNode? {
            val list = ArrayList(head.toList())
            if (n > list.size) {
                return null
            }
            list.removeAt(list.size - n)
            return toListNode(list)
        }
    }
}