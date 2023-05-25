package q91_100

import TreeNode

class Q98 {

    class Solution {
        fun isValidBST(root: TreeNode?, minValue: Int? = null, maxValue: Int? = null): Boolean {
            if (root == null) return true
            if (minValue != null && root.`val` <= minValue) return false
            if (maxValue != null && root.`val` >= maxValue) return false
            return isValidBST(root.left, minValue, root.`val`) && isValidBST(root.right, root.`val`, maxValue)
        }
    }

}