package q231_240

import TreeNode
import __Serializer__
import testing.LeetTest

class Q236 {

    class Solution {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            if (root == null) return null
            if (p == null) return null
            if (q == null) return null

            var answer: TreeNode? = null

            fun visit(node: TreeNode?): Int {
                if (node == null) return 0
                val containsLeft = visit(node.left)
                val containsRight = visit(node.right)
                if (node.`val` == p.`val` || node.`val` == q.`val`) {
                    if (containsLeft + containsRight == 1) {
                        answer = node
                        return 0
                    }
                    return 1
                }
                if (answer != null) return 0
                if (containsLeft + containsRight == 2) {
                    answer = node
                    return 0
                } else if (containsLeft == 1 || containsRight == 1) {
                    return 1
                } else {
                    return 0
                }
            }

            visit(root)
            return answer
        }


    }

}

fun main() {
    LeetTest.assertReturn(Q236.Solution::lowestCommonAncestor, __Serializer__::serialize, "3", "[3,5,1,6,2,0,8,null,null,7,4]", "[5]", "[1]")
}