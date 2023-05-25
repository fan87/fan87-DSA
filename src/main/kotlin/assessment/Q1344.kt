package assessment

import kotlin.math.abs

class Q1344 {

    class Solution {
        fun angleClock(hour: Int, minutes: Int): Double {
            val hourAngle = (hour % 12) * 30.0 + (minutes % 60) * (30/60.0)
            val minuteAngle = (minutes % 60) * 6
            val diff = abs(hourAngle - minuteAngle)
            if (diff >= 180) {
                return 360 - diff
            } else {
                return diff
            }
        }
    }

}