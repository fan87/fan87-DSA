package q21_30

import ListNode

class Q23 {

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
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty()) return null
            if (lists.size == 1) return lists[0]
            val out = ListNodeWriter(null)

            val otherIterators = ArrayList<ListNode?>(lists.filterNotNull())

            while (otherIterators.isNotEmpty()) {
                var currentNode: ListNode? = otherIterators.removeAt(0)
                while (currentNode != null) {
                    val i = currentNode.`val`
                    val toAdd = ArrayList<Int>()

                    for ((index, listNode) in otherIterators.withIndex()) {
                        var otherNode: ListNode? = listNode
                        while (otherNode != null && otherNode.`val` <= i) {
                            toAdd.add(otherNode.`val`)
                            otherNode = otherNode.next
                        }
                        otherIterators[index] = otherNode
                    }
                    otherIterators.filterNotNull()

                    for (i1 in toAdd.sorted()) {
                        out.add(i1)
                    }
                    out.add(currentNode.`val`)
                    currentNode = currentNode.next
                }
            }

            return out.first
        }
    }

}

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

fun main() {
    println(Q23.Solution().mergeKLists(arrayOf(
        toListNode(listOf(1, 4, 5)),
        toListNode(listOf(1, 3, 4)),
        toListNode(listOf(2, 6)),
    ))?.toList())
}