package q11_20

class Q20 {

    class Solution {
        fun isValid(s: String): Boolean {
            if (s.isEmpty()) return true
            val simplify = s.replace("()", "").replace("{}", "").replace("[]", "")
            if (simplify == s) return false
            return isValid(simplify)
        }
    }

}