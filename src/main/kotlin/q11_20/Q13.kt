package q11_20
import java.util.*
import kotlin.collections.HashMap


class Q13 {



    class Solution {

        private val advancedThingyMap = HashMap<String, Int>()
        private val map = HashMap<String, Int>()

        init {
            map["M"] = 1000
            map["D"] = 500
            map["C"] = 100
            map["L"] = 50
            map["X"] = 10
            map["V"] = 5
            map["I"] = 1

            advancedThingyMap["CM"] = 900
            advancedThingyMap["CD"] = 400
            advancedThingyMap["XC"] = 90
            advancedThingyMap["XL"] = 40
            advancedThingyMap["IX"] = 9
            advancedThingyMap["IV"] = 4
            advancedThingyMap["I"] = 1


        }

        fun romanToInt(s: String): Int {
            var index = 0
            var result = 0
            while (index < s.length) {
                if (index + 1 < s.length) { // Potential of advanced thingy
                    val thingy = advancedThingyMap[s[index].toString() + s[index + 1]]
                    if (thingy != null) {
                        result += thingy
                        index += 2
                        continue
                    }
                }
                result += map[s[index].toString()]!!
                index++
            }
            return result
        }
    }
}