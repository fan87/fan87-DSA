package q331_340

import java.util.Comparator
import java.util.PriorityQueue
import java.util.Stack

class Q332 {

    class Solution {
        fun findItinerary(tickets: List<List<String>>): List<String> {
            val map = HashMap<String, PriorityQueue<String>>()

            for (ticket in tickets) {
                val queue = map[ticket[0]] ?: PriorityQueue()
                queue.add(ticket[1])
                map[ticket[0]] = queue
            }

            val path = Stack<String>()
            var answer: List<String>? = null
            fun dfs(node: String) {
                if (answer != null) return

                path.push(node)

                if (path.size == tickets.size + 1) { // Has visited everything
                    answer = path.toList()
                    return
                }

                println(path)

                val queue = map[node] ?: PriorityQueue()
                while (queue.isNotEmpty()) {
                    val s = queue.poll()
                    dfs(s)
                    if (answer != null) return
                }
                path.pop()
            }
            dfs("JFK")
            return answer!!
        }
    }

}

fun main() {
    val queue = PriorityQueue<String>()
    queue.add("AUA")
    queue.add("EZE")
    queue.add("AXA")
    println(queue.poll())
}