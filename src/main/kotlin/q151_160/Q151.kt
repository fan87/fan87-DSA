package q151_160

import java.lang.StringBuilder

class Q151 {

    class Solution {
        // Thanks, kotlin!
        fun reverseWords(s: String): String {
            return s.split(" ").filter { it.isNotEmpty() }.reversed().joinToString(" ")
        }
    }

}