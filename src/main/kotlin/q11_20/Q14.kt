package q11_20

class Q14 {

    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            var currentPrefix = ""
            for (i in 0 until strs.map { it.length }.min()!!) { // Ignore the !!, something is wrong with IntelliJ or leetcode's kotlin version idk
                if (strs.map { it[i] }.let { it.all { content -> it[0] == content } }) {
                    currentPrefix += strs[0][i]
                } else {
                    break
                }
            }
            return currentPrefix
        }
    }

}