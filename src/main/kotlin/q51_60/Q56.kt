package q51_60

class Q56 {

    // TODO: Make it faster by not using lastOrNull(), but post-save the end value
    class Solution {
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            val sorted = intervals.sortedBy { it[0] }.toTypedArray()
            val out = mutableListOf<IntArray>()
            var end = -1
            for (value in sorted) {
                if (value[0] > end) { // Could be merged
                    out.lastOrNull()?.set(1, end)
                    out.add(intArrayOf(value[0], value[1]))
                }
                if (value[1] > end) {
                    end = value[1]
                }
            }
            out.lastOrNull()?.set(1, end)
            return out.toTypedArray()
        }
    }

}

fun main() {
    println(Q56.Solution().merge(arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18),
    )).map { "(${it[0]},${it[1]})" }.joinToString(", "))
    println(Q56.Solution().merge(arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 4),
        intArrayOf(3, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18),
    )).map { "(${it[0]},${it[1]})" }.joinToString(", "))
    println(Q56.Solution().merge(arrayOf(
        intArrayOf(1, 10),
        intArrayOf(2, 3),
        intArrayOf(4, 5),
        intArrayOf(6, 7),
        intArrayOf(8, 9),
    )).map { "(${it[0]},${it[1]})" }.joinToString(", "))
    println(Q56.Solution().merge(arrayOf(
        intArrayOf(1, 4),
        intArrayOf(4, 5),
    )).map { "(${it[0]},${it[1]})" }.joinToString(", "))
}