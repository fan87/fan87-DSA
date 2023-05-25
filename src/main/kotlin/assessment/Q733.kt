package assessment

class Q733 {

    class Solution {
        fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
            val visited = HashSet<Pair<Int, Int>>()
            visit(image, sr, sc, color, image[sr][sc], visited)
            return image
        }
        fun visit(image: Array<IntArray>, sr: Int, sc: Int, color: Int, colorCheck: Int, visited: MutableSet<Pair<Int, Int>>) {
            if (sr !in image.indices || sc !in image[sr].indices) return
            if (colorCheck == color) return
            if (image[sr][sc] != colorCheck) return

            image[sr][sc] = color

            visit(image, sr + 1, sc, color, colorCheck, visited)
            visit(image, sr - 1, sc, color, colorCheck, visited)
            visit(image, sr, sc + 1, color, colorCheck, visited)
            visit(image, sr, sc - 1, color, colorCheck, visited)

            return
        }
    }

}