package q1_10

class Q6 {
    class Solution {
        fun getSkipSequence(numRows: Int, row: Int): Pair<Int, Int> {
            if (numRows == 1) return Pair(1, 1)
            // Row 0: Skips (numRows - 2 + numRows) then Skips 0
            // Row N: Skips (numRows - 2 + numRows) - 2 * N  then Skips  (numRows - 2 + numRows) - 2 * (numRows - N)
            // Row Last: Skips 0 then Skips (numRows - 2 + numRows)

            val first = (numRows - 1)*2  -  2*row
            val second  = (numRows)*2  -  2*(numRows - row)
            if (first == 0) return Pair(second, second)
            if (second == 0) return Pair(first, first)
            return Pair(second, first)
        }

        fun convert(s: String, numRows: Int): String {
            val skipSequences = HashMap<Int, Pair<Int, Int>>()
            for (i in 0 until numRows) {
                skipSequences[i] = getSkipSequence(numRows, i)
            }
            var out = ""
            for (row in 0 until numRows) {
                val skipSequence = skipSequences[row]!!
                var currentColumn = 0
                var currentIndex = row
                while (currentIndex < s.length) {
                    out += s[currentIndex]
                    println("Appending $currentIndex  at row $row and column $currentColumn   ($skipSequence)")
                    currentColumn++
                    currentIndex += if (currentColumn % 2 == 0) skipSequence.first else skipSequence.second
                }
            }
            return out
        }
    }
}

fun main() {
    println(Q6.Solution().convert("A", 1))
    println(Q6.Solution().convert("PAYPALISHIRING", 3))
}