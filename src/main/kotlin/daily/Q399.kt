package daily

import java.util.concurrent.Executors

class Q399 {

    // TODO: Improve the performance
    class Solution {
        companion object { // Sorry, mom
            // This is for performance I swear to god
            val solving = HashMap<String, String>()
            val map = HashMap<String, MutableMap<String, Double>>()
        }

        fun put(map: MutableMap<String, MutableMap<String, Double>>, first: String, second: String, value: Double) {
            if (fuckCaching) return
            map.getOrPut(first) { HashMap() }[second] = value
            map.getOrPut(second) { HashMap() }[first] = 1.0 / value
        }

        var fuckCaching = false


        fun solve(map: MutableMap<String, MutableMap<String, Double>>, first: String, second: String, assumeValid: Boolean = false): Double? {
            if (first !in map) { // Unknown Value
                return null
            }
            if (first == second) return 1.0

            map[first]?.get(second)?.also {
                return it
            }

            for (firstEntry in map[first]!!) { // Find something that starts with "first / "
                if (solving[firstEntry.key] != second) {
                    solving[firstEntry.key] = second
                    val secondAns = solve(map, firstEntry.key, second, true)?:continue
                    put(map, first, second, firstEntry.value * secondAns)
                    return firstEntry.value * secondAns
                }
            }

            return null
        }

        fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {

            for ((index, strings) in equations.withIndex()) {
                put(map, strings[0], strings[1], values[index])
            }

            val answers = DoubleArray(queries.size)
            for ((index, query) in queries.withIndex()) {
                if (index == query.size - 1) fuckCaching = true
                solving[query[0]] = query[1]
                answers[index] = solve(map, query[0], query[1])?:-1.0
                solving.clear()
            }
            map.clear()
            return answers
        }
    }

}

fun main() {
    println(
        Q399.Solution().calcEquation(listOf(listOf("x1", "x2"), listOf("x2", "x3"), listOf("x3", "x4"), listOf("x4", "x5")),
            doubleArrayOf(3.0, 4.0, 5.0, 6.0), listOf(listOf("x1", "x5"))).joinToString(", ")
    )
    println(
        Q399.Solution().calcEquation(listOf(listOf("a", "b"), listOf("b", "c")), doubleArrayOf(2.0, 3.0), listOf(listOf("a", "c"))).joinToString(", ")
    )
    println(
        Q399.Solution().calcEquation(listOf(listOf("a", "e"), listOf("b", "e")), doubleArrayOf(4.0, 3.0), listOf(listOf("a", "b"))).joinToString(", ")
    )
    val startTime = System.currentTimeMillis()
    repeat(100) {
        repeat (10000) {
            Q399.Solution().calcEquation(listOf(listOf("a", "b"), listOf("b", "c")), doubleArrayOf(2.0, 3.0), listOf(listOf("a", "c"))).joinToString(", ")
            Q399.Solution().calcEquation(listOf(
                listOf("a", "b"),
                listOf("b", "c"),
                listOf("c", "d")
            ),
                doubleArrayOf(1.0, 2.0, 3.0),
                listOf(listOf("a", "d"), listOf("a", "d"), listOf("a", "d"), listOf("a", "d"), listOf("a", "d"))).joinToString(", ")
        }
    }

    println("Took ${(System.currentTimeMillis() - startTime)/100} ms")
}