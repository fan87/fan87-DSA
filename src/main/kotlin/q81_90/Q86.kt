package q81_90

import ListNode

class Q86 {


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


        fun partition(head: ListNode?, x: Int): ListNode? {
            val buf = ArrayList<Int>()
            val writer = ListNodeWriter(null)
            var currentNode = head
            while (currentNode != null) {
                if (currentNode.`val` >= x) {
                    buf.add(currentNode.`val`)
                } else {
                    writer.add(currentNode.`val`)
                }
                currentNode = currentNode.next
            }
            for (i in buf) {
                writer.add(i)
            }
            return writer.first
        }
    }


}