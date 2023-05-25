package q41_50

import java.util.Random

class Q43 {

    // TODO: Improve performance by not appending zeros on multiplication, but instead modify the addInt method to be able to accept the jump index
    class Solution {

        inline fun Char.convertToInt(): Int {
            return this.toInt() - 48
        }
        inline fun String.addInt(another: String): String {
            if (another == "0") return this
            if (this == "0") return another
            var fixedThis = this
            var fixedAnother = another
            var out = ""
            if (this.length < another.length) {
                fixedThis = "0".repeat(another.length - this.length) + fixedThis
            } else if (another.length < this.length) {
                fixedAnother = "0".repeat(this.length - another.length) + fixedAnother
            }
            val maxLength = fixedThis.length
            var carry = 0
            for (index in 0 until maxLength) {
                val a = fixedThis[maxLength - index - 1].convertToInt()
                val b = fixedAnother[maxLength - index - 1].convertToInt()

                out = "${(a + b + carry) % 10}$out"
                carry = (a + b + carry) / 10
            }
            if (carry != 0) {
                out = "$carry$out"
            }
            if (out.isEmpty()) return "0"
            return out
        }

        inline fun String.multiplyInt(another: Int): String {
            if (another == 0) return "0"
            if (this == "0") return "0"
            var out = ""
            val theLength = this.length
            var carry = 0
            for (index in 0 until theLength) {
                val a = this[theLength - index - 1].convertToInt()
                val b = another

                out = "${(a * b + carry) % 10}$out"
                carry = (a * b + carry) / 10
            }
            if (carry != 0) {
                out = "$carry$out"
            }
            if (out.isEmpty()) return "0"
            return out
        }

        fun multiply(num1: String, num2: String): String {
            val carries = ArrayList<String>()
            if (num2 == "0" || num1 == "0") {
                return "0"
            }
            if (num2.length == 1) {
                return num1.multiplyInt(num2[0].convertToInt())
            }
            if (num1.length == 1) {
                return num2.multiplyInt(num1[0].convertToInt())
            }
            for ((num1Index, num1Value) in num1.withIndex()) {
                val carry = num2.multiplyInt(num1Value.convertToInt())
                val element = carry + "0".repeat(num1.length - num1Index - 1)
                carries.add(element)
            }
            if (carries.isEmpty()) return "0"
            var out = carries.first()
            carries.removeAt(0)
            for (carry in carries) {
                out = out.addInt(carry)
            }
            return out
        }
    }

}

fun main() {
    val random = Random()
    println("Starting single digits test")
    repeat (100) {
        val nextInt = random.nextInt(10000)
        val nextInt2 = random.nextInt(10)

        val message = Q43.Solution().multiply(nextInt.toString(), nextInt2.toString()).toInt() == nextInt * nextInt2
        if (!message) {
            println("Test failed for $nextInt * $nextInt2")
            return
        }
    }
    println("Starting multiple digits test")
    repeat (100) {
        val nextInt = random.nextInt(10000)
        val nextInt2 = random.nextInt(10000)

        val found = Q43.Solution().multiply(nextInt.toString(), nextInt2.toString()).toInt()
        val message = found == nextInt * nextInt2
        if (!message) {
            println("Test failed for $nextInt * $nextInt2 (Expected: ${nextInt * nextInt2}, Found: $found)")
            return
        }
    }
}