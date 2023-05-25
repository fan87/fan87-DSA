package q171_180

import TreeNode
import java.util.Stack

class Q173 {

    class Iterative {
        // TODO: Do BinaryTree Iterative again
        class BSTIterator(root: TreeNode?) {

            val stack = Stack<TreeNode>()

            init {
                visitToLeft(root)
            }

            fun next(): Int {
                if (!hasNext()) throw IllegalStateException("The iterator does not has next element")
                val currentNode = stack.pop()
                if (currentNode.right != null) {
                    visitToLeft(currentNode.right)
                }
                return currentNode.`val`
            }

            fun hasNext(): Boolean {
                return stack.isNotEmpty()
            }

            fun visitToLeft(node: TreeNode?) {
                var currentNode = node
                while (currentNode != null) {
                    stack.push(currentNode)
                    currentNode = currentNode.left
                }
            }

        }
    }

    class PreCache_JavaIterator {
        class BSTIterator(root: TreeNode?) {

            val allTheNodes = ArrayList<Int>()

            init {
                visit(root)
            }
            val iterator = allTheNodes.iterator()

            fun next(): Int {
                return iterator.next()
            }

            fun hasNext(): Boolean {
                return iterator.hasNext()
            }

            private fun visit(node: TreeNode?) {
                if (node == null) return
                visit(node.left)
                allTheNodes.add(node.`val`)
                visit(node.right)
            }

        }
    }

    class PreCache_CustomIterator {
        class BSTIterator(root: TreeNode?) {
            val allTheNodes = ArrayList<Int>()
            var index = 0

            init {
                visit(root)
            }

            fun next(): Int {
                return allTheNodes[index++]
            }

            fun hasNext(): Boolean {
                return index < allTheNodes.size
            }

            private fun visit(node: TreeNode?) {
                if (node == null) return
                visit(node.left)
                allTheNodes.add(node.`val`)
                visit(node.right)
            }
        }
    }

}