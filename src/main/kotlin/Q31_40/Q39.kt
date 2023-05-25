package Q31_40

class Q39 {

    class Solution {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result = ArrayList<List<Int>>()


            bfs(result, 0, candidates, ArrayList(), target, 0)
            return result
        }


        fun bfs(result: MutableList<List<Int>>, ignoreBefore: Int, candidates: IntArray, path: MutableList<Int>, target: Int, bfsTarget: Int) {
            if (bfsTarget >= target) {
                if (bfsTarget == target) result.add(path.toList())
                return
            }

            for (i in ignoreBefore until candidates.size) {
                path.add(candidates[i])
                bfs(result, i, candidates, path, target, bfsTarget + candidates[i])
                path.removeAt(path.size - 1)
            }
        }
    }

}

fun main() {
    println(Q39.Solution().combinationSum(intArrayOf(2, 3, 6, 7), 7))
}