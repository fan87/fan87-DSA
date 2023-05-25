package daily

class Q934 {

    // TODO: I think Q934 Shortest Bridge is worth practicing
    // I've got the trick (Expanding), but implemented in the wrong/opposite way, maybe re-learn it again
    // Took me 1 hour to write it the first time!
    class Solution {

        companion object {
            const val LAND_1_ID = 2
            const val LAND_2_ID = 1
            const val LAND_VISITED = 4
            val DIRECTIONS = arrayOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))
        }

        fun shortestBridge(grid: Array<IntArray>): Int {
            val size = grid.size

            val currentExpansion = ArrayList<Pair<Int, Int>>()

            landDiscovery@for (y in 0 until size) {
                for (x in 0 until size)  {
                    if (discoverLand(grid, x, y, currentExpansion)) {
                        break@landDiscovery
                    }
                }
            }


            var depth = 0
            while (currentExpansion.isNotEmpty()) {
                for (index in 0 until currentExpansion.size) {
                    val toVisit = currentExpansion.removeAt(0)
                    for (direction in DIRECTIONS) {
                        val neighborX = toVisit.first + direction.first
                        val neighborY = toVisit.second + direction.second
                        if (neighborX in 0 until size && neighborY in 0 until size) {
                            if (grid[neighborY][neighborX] == LAND_2_ID) {
                                return depth
                            }
                            if (grid[neighborY][neighborX] != LAND_VISITED) {
                                grid[neighborY][neighborX] = LAND_VISITED
                                currentExpansion.add(Pair(neighborX, neighborY))
                            }
                        }
                    }
                }
                depth += 1
            }


            return depth
        }


        fun discoverLand(grid: Array<IntArray>, x: Int, y: Int, visitingNeighbors: MutableList<Pair<Int, Int>>): Boolean {
            if (x >= grid.size || y >= grid.size || x < 0 || y < 0) return false
            if (grid[y][x] == LAND_2_ID) {
                visitingNeighbors.add(Pair(x, y))
                grid[y][x] = LAND_1_ID
                discoverLand(grid, x + 1, y, visitingNeighbors)
                discoverLand(grid, x, y + 1, visitingNeighbors)
                discoverLand(grid, x - 1, y, visitingNeighbors)
                discoverLand(grid, x, y - 1, visitingNeighbors)
                return true
            }
            return false
        }
    }

}

fun main() {
    println(Q934.Solution().shortestBridge(
        arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 0, 0),
        )
    ))

    println(Q934.Solution().shortestBridge(
        arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 1, 0),
        )
    ))
}