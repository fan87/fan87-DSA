package q381_390

class Q383 {

    class Solution {
        fun canConstruct(ransomNote: String, magazine: String): Boolean {
            val noteCount = IntArray(26)
            val magazineCount = IntArray(26)
            for (c in ransomNote) {
                noteCount[c.toInt() - 97]++
            }
            for (c in magazine) {
                magazineCount[c.toInt() - 97]++
            }
            for ((char, requiredAmount) in noteCount.withIndex()) {
                if (magazineCount[char] < requiredAmount) return false
            }
            return true
        }
    }

}