package q201_210

import java.util.Stack

class Q207 {

    class Solution {

        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val dependencies = HashMap<Int, HashSet<Int>>()
            for (prerequisite in prerequisites) {
                val theSet = dependencies[prerequisite[0]]?:HashSet<Int>().also { dependencies[prerequisite[0]] = it }
                theSet.add(prerequisite[1])
            }

            val finished = BooleanArray(numCourses)
            val visited = BooleanArray(numCourses)
            fun tryFinish(course: Int): Boolean {
                if (finished[course]) return true
                if (visited[course]) return false
                val dependenciesOfCourse = dependencies[course]
                if (dependenciesOfCourse?.isEmpty() != false) {
                    finished[course] = true
                    return true
                }
                visited[course] = true
                try {
                    return dependenciesOfCourse.all { tryFinish(it) }.also { if (it) finished[course] = true }
                } finally {
                    visited[course] = false
                }
            }

            for (i in 0 until numCourses) {
                if (!tryFinish(i)) {
                    return false
                }
            }

            return true
        }
    }

}