package q71_80

class Q73 {

    // TODO: (Check after June 10th) A better solution...?
    class Solution {

        fun setZeroes(matrix: Array<IntArray>) {
            val zeroYs = HashSet<Int>()
            val zeroXs = HashSet<Int>()
            val zeroRow = IntArray(matrix[0].size)

            for (y in matrix.indices) {
                for (x in matrix[y].indices) {
                    if (matrix[y][x] == 0) {
                        zeroXs.add(x)
                        zeroYs.add(y)
                    }
                }
            }

            for (y in zeroYs) {
                matrix[y] = zeroRow // Let's just do a little trolling
//                System.arraycopy(zeroRow, 0, matrix[y], 0, zeroRow.size)
            }
            for (x in zeroXs) {
                for (index in matrix.indices) {
                    matrix[index][x] = 0
                }
            }
        }
    }

}