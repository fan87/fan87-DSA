package q71_80

import java.util.Stack

class Q71 {

    class Solution {
        fun simplifyPath(path: String): String {
            val pathStack = Stack<String>()
            for (s in ArrayList<String>(path.split("/").filter { it.isNotEmpty() })) {
                if (s == ".") continue
                if (s == "..") {
                    if (pathStack.isNotEmpty()) {
                        pathStack.pop()
                    }
                    continue
                }
                pathStack.push(s)
            }
            return "/" + pathStack.joinToString("/")
        }
    }

}