package q21_30

import ListNode
import q21_30.Q21.Companion.toList
import q21_30.Q21.Companion.toListNode

class Q21 {
    class Solution {
        class ListNodeWriter(var first: ListNode?) {
            var latest: ListNode? = first
            fun add(value: Int) {
                val newNode = ListNode(value)
                if (first == null) {
                    first = newNode
                }
                latest?.next = newNode
                latest = newNode
            }
        }

        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            if (list1 == null) return list2
            if (list2 == null) return list1

            val out = ListNodeWriter(null)


            var currentList1: ListNode? = list1
            var currentList2: ListNode? = list2

            while (currentList1 != null) {
                while (currentList2 != null && currentList2.`val` <= currentList1.`val`) {
                    out.add(currentList2.`val`)
                    currentList2 = currentList2.next
                }
                out.add(currentList1.`val`)
                currentList1 = currentList1.next
            }
            if (out.latest != null) {
                out.latest!!.next = currentList2
            } else {
                out.first = currentList2
            }

            return out.first
        }
    }

    companion object {
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
    }
}
fun main() {
    println(Q21.Solution().mergeTwoLists(toListNode(arrayListOf(1, 2, 6, 10)), toListNode(arrayListOf(1, 4, 8, 6, 21)))?.toList())
}