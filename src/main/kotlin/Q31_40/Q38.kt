package Q31_40

class Q38 {

    class Solution {

        companion object {
            val cache = HashMap<Int, String>()
        }
        fun countAndSay(n: Int): String {
            if (n == 1) return "1"
            return countAndSayText(cache[n]?:countAndSay(n - 1).also { cache[n] = it })
        }

        inline fun countAndSayText(text: String): String {
            var out = ""
            var count = 0
            var previous: Char? = null
            for (c in text) {
                if (c != previous) {
                    if (previous != null) {
                        out += "$count$previous"
                    }
                    previous = c
                    count = 1
                } else {
                    count += 1
                }
            }
            if (previous != null && count != 0) {
                out += "$count$previous"
            }
            return out
        }
    }

}

fun main() {
    println(Q38.Solution().countAndSay(5))
}