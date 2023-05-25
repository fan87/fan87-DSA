package q191_200

class Q200 {

    class Solution {

        fun numIslands(grid: Array<CharArray>): Int {
            var out = 0
            for (y in grid.indices) {
                for (x in grid[y].indices)  {
                    if (visitIsland(grid, x, y)) {
                        out++
                    }
                }
            }
            return out
        }


        fun visitIsland(grid: Array<CharArray>, x: Int, y: Int): Boolean {
            if (y >= grid.size || y < 0 || x >= grid[y].size || x < 0) return false
            if (grid[y][x] != '1') return false
            grid[y][x] = '0'
            visitIsland(grid, x + 1, y)
            visitIsland(grid, x, y + 1)
            visitIsland(grid, x - 1, y)
            visitIsland(grid, x, y - 1)
            return true
        }
    }

}