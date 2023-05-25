package q1_10

import java.io.StringReader
import kotlin.math.pow

class Q8 {
    class Solution {
        fun charToInt(c: Char): Int? {
            return when (c) {
                '0' -> 0
                '1' -> 1
                '2' -> 2
                '3' -> 3
                '4' -> 4
                '5' -> 5
                '6' -> 6
                '7' -> 7
                '8' -> 8
                '9' -> 9
                else -> null
            }
        }

        // Really wish inline is a bit faster
        inline fun StringReader.readChar(): Char? = read().let { if (it == -1) null else it.toChar() }

        fun myAtoi(s: String): Int {
            if (s.isEmpty()) return 0
            val numbers = ArrayList<Int>()
            val reader = s.reader()
            var index = -1

            while (true) {
                index++
                if (index >= s.length) {
                    return 0
                }
                if (s[index] != ' ') {
                    break
                }
            }
            reader.skip(index.toLong())
            var numberMultiplier = 1L
            val negativeSign = reader.readChar()?:return 0

            if (negativeSign == '-') {
                numberMultiplier = -1
            } else {
                if (negativeSign != '+' && negativeSign != '0') {
                    val number = charToInt(negativeSign)
                    if (number != null) {
                        numbers.add(number)
                    } else {
                        return 0
                    }
                }
            }
            var clamp = false
            while (true) {
                val char = reader.readChar()?:break
                if (char == '0' && numbers.isEmpty()) {
                    continue
                }
                charToInt(char)?.also { numbers.add(it) }?:break
                if (numbers.size > 10) {
                    clamp = true
                    break
                }
            }
            var outNumber = 0L
            if (!clamp) {
                for ((index, number) in numbers.withIndex()) {
                    outNumber += number * 10.0.pow(((numbers.size - index - 1).toDouble())).toLong()
                }
            } else {
                return if (numberMultiplier < 0) Int.MIN_VALUE else Int.MAX_VALUE
            }

            return (outNumber * numberMultiplier).coerceAtMost(Int.MAX_VALUE.toLong()).coerceAtLeast(Int.MIN_VALUE.toLong()).toInt()
        }
    }
}

fun main() {
    println(Q8.Solution().myAtoi("   42"))
    println(Q8.Solution().myAtoi("42"))
    println(Q8.Solution().myAtoi("1"))
    println(Q8.Solution().myAtoi(""))
    println(Q8.Solution().myAtoi(" "))
    println(Q8.Solution().myAtoi("20000000000000000000"))
    println(Q8.Solution().myAtoi("  0000000000012345678"))
}