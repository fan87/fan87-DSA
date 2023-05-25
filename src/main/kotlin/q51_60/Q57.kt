package q51_60

class Q57 {

    // TODO: Skidded, do Q57 (Interval Insert) blindly / from scratch
    class Solution {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val out = mutableListOf<IntArray>()
            var intervalMin = newInterval[0]
            var intervalMax = newInterval[1]
            var counter = 0

            while(counter < intervals.size && intervals[counter][1] < intervalMin) out.add(intervals[counter++])

            while(counter < intervals.size && intervals[counter][0] <= intervalMax){
                intervalMin = intervals[counter][0].coerceAtMost(intervalMin)
                intervalMax = intervals[counter++][1].coerceAtLeast(intervalMax)
            }
            out.add(intArrayOf(intervalMin,intervalMax))

            while(counter < intervals.size) out.add(intervals[counter++])
            return out.toTypedArray()
        }
    }

}

fun main() {
    println(Q57.Solution().insert(arrayOf(
        intArrayOf(1, 3),
        intArrayOf(6, 9),
    ), intArrayOf(2, 5)).map { "(${it[0]},${it[1]})" }.joinToString(", "))
    println(Q57.Solution().insert(arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 5),
        intArrayOf(6, 7),
        intArrayOf(8, 10),
        intArrayOf(12, 16),
    ), intArrayOf(4, 8)).map { "(${it[0]},${it[1]})" }.joinToString(", "))
    println(Q57.Solution().insert(arrayOf(
        intArrayOf(1, 5),
    ), intArrayOf(2, 3)).map { "(${it[0]},${it[1]})" }.joinToString(", "))
}