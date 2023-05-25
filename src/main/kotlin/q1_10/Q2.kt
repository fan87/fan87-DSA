package q1_10

import ListNode

class Q2 {
    class Solution {
        class ListNodeWriter(val first: ListNode) {
            var latest: ListNode = first
            fun add(value: Int) {
                val newNode = ListNode(value)
                latest.next = newNode
                latest = newNode
            }
        }
        operator fun ListNode.iterator(): Iterator<Int> {
            val that = this
            return object : Iterator<Int> {
                var current: ListNode? = that
                override fun hasNext(): Boolean {
                    return current != null
                }

                override fun next(): Int {
                    if (!hasNext()) {
                       throw IllegalArgumentException("l2 does not match the length of l1")
                    }
                    return current!!.`val`.also {
                        current = current?.next
                    }
                }
            }
        }

        fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
            var currentNextValueAdd = 0
            var writer: ListNodeWriter? = null
            val firstList = l1.iterator()
            val secondList = l2.iterator()
            while (firstList.hasNext() || secondList.hasNext()) {
                val first = if (firstList.hasNext()) firstList.next() else 0
                val second = if (secondList.hasNext()) secondList.next() else 0
                println("Parsing - First $first  and second $second  current next value $currentNextValueAdd")

                val resultValue = second + first + currentNextValueAdd
                currentNextValueAdd = resultValue / 10
                if (writer == null) {
                    writer = ListNodeWriter(ListNode(resultValue % 10))
                } else {
                    writer.add(resultValue % 10)
                }
            }
            if (currentNextValueAdd != 0) {
                writer!!.add(currentNextValueAdd)
            }
            return writer?.first?:throw IllegalArgumentException("l1 or l2 is empty")
        }
    }
}