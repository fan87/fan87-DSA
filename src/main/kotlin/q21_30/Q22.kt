package q21_30

class Q22 {

    class Solution {
        fun generateParenthesis(n: Int): List<String> = solve(n, n)

        private fun solve(left: Int, right: Int, value: String = "", result: List<String> = listOf()) : List<String> {
            return when {
                left == 0 && right == 0 -> result + value
                left == right -> solve(left - 1, right, "$value(", result)
                left == 0 -> solve(left, right - 1, "$value)", result)
                else -> solve(left - 1, right, "$value(", result) + solve(left, right - 1, "$value)", result)
            }
        }

    }

}

fun main() {
    println(Q22.Solution().generateParenthesis(4))
}