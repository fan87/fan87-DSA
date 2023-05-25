package daily

class Q785 {


    class Solution {
        fun isBipartite(graph: Array<IntArray>): Boolean {
            // Declare 2 sets
            val setA = HashSet<Int>()
            val setB = HashSet<Int>()

            fun check(debugName: String, nodesSet: MutableSet<Int>, anotherSet: MutableSet<Int>, int: Int): Boolean {
                if (int in nodesSet) {
                    println("Failed because the current value is connecting to $int (in $debugName) which is part of its own set ($debugName)")
                    return false
                } else {
                    if (int !in anotherSet) {
                        println("Detected $int should be in the opposite set of $debugName")
                        anotherSet.add(int)
                    }

                }
                return true
            }

            for ((currentNode, ints) in graph.withIndex()) {
                println("Looping $currentNode")
                if (currentNode in setA) {
                    for (int in ints) {
                        if (!check("setA", setA, setB, int)) {
                            println("Set A: $setA")
                            println("Set B: $setB")
                            return false
                        }
                    }
                } else if (currentNode in setB) {
                    for (int in ints) {
                        if (!check("setB", setB, setA, int)) {
                            println("Set A: $setA")
                            println("Set B: $setB")
                            return false
                        }
                    }
                } else {
                    if (setA.isEmpty()) {
                        println("Added $currentNode to setA as it's unknown")
                        setA.add(currentNode)
                        for (int in ints) {
                            if (!check("setA", setA, setB, int)) {
                                println("Set A: $setA")
                                println("Set B: $setB")
                                return false
                            }
                        }
                    } else if (setB.isEmpty()) {
                        println("Added $currentNode to setB as it's unknown")
                        setB.add(currentNode)
                        for (int in ints) {
                            if (!check("setB", setB, setA, int)) {
                                println("Set A: $setA")
                                println("Set B: $setB")
                                return false
                            }
                        }
                    } else {
                        println("Added $currentNode to setA as it's unknown")
                        setA.add(currentNode)
                        for (int in ints) {
                            if (!check("setA", setA, setB, int)) {
                                println("Set A: $setA")
                                println("Set B: $setB")
                                return false
                            }
                        }
                    }
                }
            }
            println("Set A: $setA")
            println("Set B: $setB")
            return setA.isNotEmpty() && setB.isNotEmpty()
        }
    }


}

fun main() {
    println(Q785.Solution().isBipartite(arrayOf(intArrayOf(1, 2, 3), intArrayOf(0, 2), intArrayOf(0, 1, 3), intArrayOf(0, 2))))
    println(Q785.Solution().isBipartite(arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(0, 2))))
}