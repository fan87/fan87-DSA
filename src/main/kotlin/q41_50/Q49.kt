package q41_50

class Q49 {

    // TODO: A better solution...?
    // Hint: It's a char array, not an object array
    // Hint: Only lowercase english letters!
    class Solution {
        fun summary(word: String): Map<Char, Int> {
            val out = HashMap<Char, Int>()
            for (c in word) {
                out[c] = (out[c]?:0) + 1
            }
            return out
        }

        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val out = ArrayList<MutableList<String>>()
            val words = ArrayList<Map<Char, Int>>()
            for (str in strs) {
                val summary = summary(str)
                val registry = words.indexOf(summary)
                if (registry != -1) {
                    val theList = out[registry]
                    theList.add(str)
                } else {
                    words.add(summary)
                    out.add(arrayListOf(str))
                }
            }
            return out
        }
    }

}

fun main() {
    println(Q49.Solution().groupAnagrams(arrayOf(
        "ddddddddddg","dgggggggggg"
    )))
}