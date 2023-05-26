package q61_70

class Q64 {

    class Solution {
        fun minPathSum(grid: Array<IntArray>): Int {
            val height = grid.size
            val width = grid[0].size
            val row = IntArray(width) { -1 }
            var previous = 0

            for (y in height - 1 downTo 0) {
                previous = Int.MAX_VALUE
                for (x in width - 1 downTo 0) {
                    var evaluated = minOf(row[x], previous) + grid[y][x]
                    if (row[x] == -1) {
                        if (previous == Int.MAX_VALUE) previous = 0
                        evaluated = previous + grid[y][x]
                    }
                    row[x] = evaluated
                    previous = evaluated
                }
            }

            return previous
        }
    }

}