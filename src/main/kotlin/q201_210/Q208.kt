package q201_210

class Q208 {

    class Trie() {

        abstract class AbstractTrieNode(val children: HashMap<Char, ChildTrieNode>) {
            fun getOrCreateChildren(char: Char): ChildTrieNode {
                var childTrieNode = children[char]
                if (childTrieNode == null) {
                    childTrieNode = ChildTrieNode(char)
                    children[char] = childTrieNode
                }
                return childTrieNode
            }
        }
        class RootTrieNode: AbstractTrieNode(hashMapOf())
        class ChildTrieNode(val prefix: Char, var endOfWord: Boolean = false): AbstractTrieNode(hashMapOf())

        val rootNode = RootTrieNode()

        fun insert(word: String) {
            var currentNode: AbstractTrieNode = rootNode
            for (c in word) {
                currentNode = currentNode.getOrCreateChildren(c)
            }
            if (currentNode is ChildTrieNode) {
                currentNode.endOfWord = true
            }
        }

        fun search(word: String): Boolean {
            var currentNode: AbstractTrieNode = rootNode
            for (char in word) {
                currentNode = currentNode.children[char]?:return false
            }
            return currentNode is ChildTrieNode && currentNode.endOfWord
        }

        fun startsWith(prefix: String): Boolean {
            var currentNode: AbstractTrieNode = rootNode
            for (prefixChar in prefix) {
                currentNode = currentNode.children[prefixChar]?:return false
            }
            return true
        }

    }

}