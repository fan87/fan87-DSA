package daily

class Q1557 {

    class Solution {

        fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
            val hasSource = BooleanArray(n) { false }
            for (edge in edges) {
                hasSource[edge[1]] = true
            }
            return (0 until n).filter { !hasSource[it] }
        }

    }

}

fun main() {
    println(Q1557.Solution().findSmallestSetOfVertices(6, listOf(listOf(0,1),listOf(0,2),listOf(2,5),listOf(3,4),listOf(4,2))))
}