package Q31_40

class Q40 {

    // TODO: Practice
    class Solution {
        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            val result = HashSet<List<Int>>()
            candidates.sort()

            fun bfs(ignoreBefore: Int, path: MutableList<Int>, theTarget: Int) {
                if (0 >= theTarget) {
                    if (0 == theTarget) {
                        result.add(path.toList())
                    }
                    return
                }

                var previous: Int = Int.MIN_VALUE
                for (i in ignoreBefore until candidates.size) {
                    if (candidates[i] == previous) continue
                    path.add(candidates[i])
                    previous = candidates[i]
                    bfs(i + 1, path, theTarget - candidates[i])
                    path.removeAt(path.size - 1)
                }
            }
            bfs(0, arrayListOf(), target)
            return result.toList()
        }



    }

}

fun main() {
    println(Q40.Solution().combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))
    println(Q40.Solution().combinationSum2(intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), 30))
}