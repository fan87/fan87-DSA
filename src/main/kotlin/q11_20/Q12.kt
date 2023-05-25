package q11_20
import java.util.*


class Q12 {



    class Solution {

        private val map = TreeMap<Int, String>()

        init {
            map[1000] = "M";
            map[900] = "CM";
            map[500] = "D";
            map[400] = "CD";
            map[100] = "C";
            map[90] = "XC";
            map[50] = "L";
            map[40] = "XL";
            map[10] = "X";
            map[9] = "IX";
            map[5] = "V";
            map[4] = "IV";
            map[1] = "I";
        }

        fun intToRoman(number: Int): String {
            if (number == 0) return ""
            val fk = map.floorKey(number)
            return if (number == fk) {
                map[number]!!
            } else map[fk] + intToRoman(number - fk)
        }
    }
}