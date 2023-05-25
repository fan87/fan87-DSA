package q411_420

import __Serializer__
import testing.LeetTest

class Q420_COMMENTLESS {

    class Solution {

        fun strongPasswordChecker(password: String): Int {

            // Initialize basic stuff required for the entire code
            var operations = 0
            var lower = 0
            var upper = 0
            var digits = 0

            val repeating = IntArray(password.length)

            var currentCheckIndex = 0
            while (currentCheckIndex < password.length) {
                val targetCheckIndex = currentCheckIndex
                val targetChar = password[currentCheckIndex]

                if (targetChar.isUpperCase()) upper = 1
                if (targetChar.isLowerCase()) lower = 1
                if (targetChar.isDigit()) digits = 1
                while (currentCheckIndex < password.length && password[currentCheckIndex] == targetChar) {
                    repeating[targetCheckIndex]++
                    currentCheckIndex++
                }
            }

            val missingRequirements = 3 - lower - upper - digits

            if (password.length < 6) {
                return maxOf(6 - password.length, if (password.length <= 3) 0 else missingRequirements)
            } else {
                var extraLength = (password.length - 20).coerceAtLeast(0)

                var currentSubValue = 1
                var doneOperation: Boolean
                operations += extraLength
                outer@while (extraLength > 0) {
                    doneOperation = false
                    for ((i, num) in repeating.withIndex()) {
                        if (num >= 3) {
                            if (num % 3 == currentSubValue - 1) {
                                doneOperation = true
                                var sub = currentSubValue
                                while (extraLength > 0 && sub > 0) {
                                    extraLength--
                                    repeating[i] -= 1
                                    sub--
                                }
                            }
                        }
                        if (extraLength == 0) break@outer
                    }
                    if (currentSubValue == 3 && !doneOperation) break
                    if (currentSubValue != 3) currentSubValue++
                }

                var modifiedCharAmount = 0
                for (i in repeating) {
                    if (i >= 3) {
                        operations += i / 3
                        modifiedCharAmount += i / 3
                    }
                }

                operations += (missingRequirements - modifiedCharAmount).coerceAtLeast(0)
            }

            return operations
        }
    }

}

fun main() {
//    val nums = intArrayOf(7, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 2, 0, 1)
//    Q420_COMMENTLESS.Solution().findMinimizedSumOfDivision(11, nums)
//    println(nums.joinToString(", "))

    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"23", "FFFFFFFFFFFFFFF11111111111111111111AAA",)
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"4", "A1234567890aaabbbbccccc")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "aaaabbaaabbaaa123456A")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"13", "aaaaaaaAAAAAA6666bbbbaaaaaaABBC")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "abababababababababaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"7", "aaaaaaaaaaaaaaaaaaaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"6", "ABABABABABABABABABABABAB")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "1010101010aaaB10101010")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "...")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "1234567890123456Baaaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "aaa111")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"7", "..................!!!")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "1Abababcaaaabababababa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "aaaaabbbb1234567890ABA")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"4", "aaaaaa1234567890123Ubefg")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"6", "")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "a")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "A")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "1")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "aA1")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "aA123")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "aa123")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "aaa123")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "aaaB1")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "1111111111")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "ABABABABABABABABABAB1")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"10", "hoAISJDBVWD09232UHJEPODKNLADU1")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"4", "ABABABABABABABABABABAB3b")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "ababababababababababaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "abAbababababababaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "abAbabababababababaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"8", "bbaaaaaaaaaaaaaaacccccc")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "ssSsss")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "aaaaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "QQQQQ")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "aaaaAAAAAA000000123456")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "000aA")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"8", "aaaabbbbccccddeeddeeddeedd")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"6", "ppppppppppppppppppp")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "ababababababababaaaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "qqq123qqq")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "1020304050607080Baaaaa")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "10203040aaaaa50607080B")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "pppppp1020304050607080")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "ppppppppp")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"4", "AAAAAABBBBBB123456789a")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "aaaabaaaaaa123456789F")
    LeetTest.assertReturn(Q420_COMMENTLESS.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "1234567890123456Baaaa")
}