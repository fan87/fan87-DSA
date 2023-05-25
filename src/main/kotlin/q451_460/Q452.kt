package q451_460

import __Serializer__
import testing.LeetTest

class Q452 {

    class Solution {

        // TODO: I should re-code it one day (Min arrow shots)
        fun findMinArrowShots(points: Array<IntArray>): Int {
            val sortedPoints = points.sortedBy { it[0] }
            val pointsToShoot = ArrayList<Pair<Int, Int>>()

            for (point in sortedPoints) {
                val pointStart = point[0]
                val pointEnd = point[1]
                if (pointsToShoot.size > 0 && pointsToShoot.last().second >= pointStart) { // If it could merge
                    val toMerge = pointsToShoot.removeAt(pointsToShoot.lastIndex)
                    pointsToShoot.add(Pair(maxOf(pointStart, toMerge.first), minOf(pointEnd, toMerge.second)))
                } else { // Well, if it couldn't be merged, just add another component
                    pointsToShoot.add(Pair(pointStart, pointEnd))
                }
            }

            return pointsToShoot.size
        }
    }

}

fun main() {
    LeetTest.assertReturn(Q452.Solution::findMinArrowShots, __Serializer__::serialize, "2", "[[10,16],[2,8],[1,6],[7,12]]")
    LeetTest.assertReturn(Q452.Solution::findMinArrowShots, __Serializer__::serialize, "4", "[[1,2],[3,4],[5,6],[7,8]]")
    LeetTest.assertReturn(Q452.Solution::findMinArrowShots, __Serializer__::serialize, "2", "[[1,2],[2,3],[3,4],[4,5]]")
}