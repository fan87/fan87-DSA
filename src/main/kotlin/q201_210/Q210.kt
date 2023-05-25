package q201_210

import __Serializer__
import testing.LeetTest
import java.util.Stack

class Q210 {

    class Solution {

        fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
            val dependencies = HashMap<Int, HashSet<Int>>()
            for (prerequisite in prerequisites) {
                val theSet = dependencies[prerequisite[0]]?:HashSet<Int>().also { dependencies[prerequisite[0]] = it }
                theSet.add(prerequisite[1])
            }

            val finished = BooleanArray(numCourses)
            val path = ArrayList<Int>()
            val visited = BooleanArray(numCourses)
            val zeroVisited = BooleanArray(numCourses)
            fun tryFinish(course: Int): Boolean {
                if (finished[course]) return true
                if (visited[course]) return false
                visited[course] = true
                val dependenciesOfCourse = dependencies[course]
                if (dependenciesOfCourse?.isEmpty() != false) {
                    path.add(course)
                    finished[course] = true
                    return true
                }
                return dependenciesOfCourse.all { tryFinish(it) }.also {
                    if (it) {
                        path.add(course)
                        finished[course] = true
                    }
                }
            }

            for (i in 0 until numCourses) {
                if (!tryFinish(i)) {
                    return intArrayOf()
                }
                System.arraycopy(zeroVisited, 0, visited, 0, numCourses)
            }

            return path.toIntArray()
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q210.Solution::findOrder, __Serializer__::serialize, "[1,0]", "2", "[[0,1]]")
    LeetTest.assertReturn(Q210.Solution::findOrder, __Serializer__::serialize, "[0,1]", "2", "[[1,0]]")
}