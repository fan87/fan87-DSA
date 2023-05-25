package q11_20

class Q17 {
    class Solution {

        companion object {
            val numberMaps = HashMap<Int, CharArray>()

            init {
                numberMaps[2] = charArrayOf('a', 'b', 'c')
                numberMaps[3] = charArrayOf('d', 'e', 'f')
                numberMaps[4] = charArrayOf('g', 'h', 'i')
                numberMaps[5] = charArrayOf('j', 'k', 'l')
                numberMaps[6] = charArrayOf('m', 'n', 'o')
                numberMaps[7] = charArrayOf('p', 'q', 'r', 's')
                numberMaps[8] = charArrayOf('t', 'u', 'v')
                numberMaps[9] = charArrayOf('w', 'x', 'y', 'z')
            }
        }
        fun letterCombinations(digits: String): List<String> {

            val numbers = ArrayList<Int>()
            val out = ArrayList<String>()
            for (digit in digits) {
                numbers.add(digit.toString().toInt())
            }
            while (numbers.isNotEmpty()) {
                val key = numbers.removeAt(0)
                val value = numberMaps[key]!!
                val oldOut = ArrayList(out)
                out.clear()
                if (oldOut.isEmpty()) {
                    out.addAll(value.map { it.toString() })
                }
                for (s in oldOut) {
                    for (c in value) {
                        out.add(s + c)
                    }
                }
            }
            return out
        }
    }
}