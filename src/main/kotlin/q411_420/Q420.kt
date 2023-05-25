package q411_420

import __Serializer__
import testing.LeetTest

class Q420 {

    // Keep in mind that this algorithm is really unsafe, and un-tested
    // There are several ways to break this, and I won't be fixing it since this is just straight-up
    // to painful to code
    class Solution {

        fun strongPasswordChecker(password: String): Int {
            var operations = 0
            var lower = 0
            var upper = 0
            var digits = 0

            val repeating = IntArray(password.length)

            var currentCheckIndex = 0
            while (currentCheckIndex < password.length) {
                val targetCheckIndex = currentCheckIndex // For later repeating check use
                val targetChar = password[currentCheckIndex]

                while (currentCheckIndex < password.length && password[currentCheckIndex] == targetChar) {
                    repeating[targetCheckIndex]++
                    currentCheckIndex++
                }
            }
            println("Repeating: ${repeating.joinToString(", ")}")
            for (targetChar in password) {
                if (targetChar.isUpperCase()) upper+= 1
                if (targetChar.isLowerCase()) lower+= 1
                if (targetChar.isDigit()) digits += 1
            }
            val charTypeRequirementMetCount = lower.coerceAtMost(1) + upper.coerceAtMost(1) + digits.coerceAtMost(1)
            val missingRequirements = 3 - charTypeRequirementMetCount

            if (password.length <= 3) { // If length is less than 3, it will be able to fix the missing requirements no matter what
                return 6 - password.length
            } else if (password.length < 6) { // If the length is 4, 5, or 6, it will be maximum value of insertion count and missing requirements count
                // We don't need to worry about repeating chars since we can easily fix it by inserting char in a different location
                val insertionCount = 6 - password.length
                return maxOf(insertionCount, missingRequirements)
            } else {
                println("Lowercase: $lower")
                println("Uppercase: $upper")
                println("Digits: $digits")

                var extraLength = password.length - 20

                if (extraLength > 0) {
                    findMinimizedSumOfDivision(extraLength, repeating)
                    operations += extraLength
                }

                println("After operation: " + repeating.joinToString(", "))

                // After reducing the length, we want to now replace all the repeating stuff.
                // Replaced "random char amount" will be stored inside a variable (For later use)
                var modifiedCharAmount = 0
                for ((index, i) in repeating.withIndex()) {
                    if (i >= 3) {
                        operations += i / 3
                        modifiedCharAmount += i / 3
                        println("Modified ${i / 3} char(s) to eliminate repeating chars")
                    }
                }

                // At this point, "repeating" is trashed as it's in-accurate, and we don't need it in our last bit of code

                // Now we use the "random char amount" to decide if we have to do extra patch for char type requirements
                // If we don't need those (AKA we added enough random chars that will just fit those requirements), we ignore them
                // Otherwise, we add (requirements - random char amount) to operations count

                println("We are missing $missingRequirements requirements ($operations)")
                if (modifiedCharAmount < missingRequirements) {
                    operations += (missingRequirements - modifiedCharAmount)
                }

            }

            return operations
        }


        //   63927897
        // - 11100010
        // = 52827887
        // - 00002002
        // = 52825885
        // - 30303333
        // = 22522552
        // - 00300330
        // = 22222222

        // 15  20  3
        //  1   0  1
        // 14  20  2
        fun findMinimizedSumOfDivision(operationsLimitation: Int, nums: IntArray) {
            var operationsLeft = operationsLimitation
            var currentSubValue = 1
            var doneOperation: Boolean
            while (operationsLeft > 0) {
                doneOperation = false
                for ((i, num) in nums.withIndex()) {
                    if (num >= 3) {
                       if (num % 3 == currentSubValue - 1) {
                            doneOperation = true
                            var sub = currentSubValue
                            while (operationsLeft > 0 && sub > 0) {
                                operationsLeft--
                                nums[i] -= 1
                                sub--
                            }
                        }
                    }
                    if (operationsLeft == 0) return
                }
                if (currentSubValue == 3 && !doneOperation) break
                if (currentSubValue != 3) currentSubValue++
            }

        }
    }

}

fun main() {
//    val nums = intArrayOf(7, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 2, 0, 1)
//    Q420.Solution().findMinimizedSumOfDivision(11, nums)
//    println(nums.joinToString(", "))

    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"23", "FFFFFFFFFFFFFFF11111111111111111111AAA",)
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"4", "A1234567890aaabbbbccccc")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "aaaabbaaabbaaa123456A")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"13", "aaaaaaaAAAAAA6666bbbbaaaaaaABBC")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "abababababababababaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"7", "aaaaaaaaaaaaaaaaaaaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"6", "ABABABABABABABABABABABAB")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "1010101010aaaB10101010")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "...")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "1234567890123456Baaaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "aaa111")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"7", "..................!!!")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "1Abababcaaaabababababa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "aaaaabbbb1234567890ABA")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"4", "aaaaaa1234567890123Ubefg")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"6", "")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "a")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "A")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "1")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "aA1")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "aA123")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "aa123")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "aaa123")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "aaaB1")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "1111111111")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "ABABABABABABABABABAB1")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"10", "hoAISJDBVWD09232UHJEPODKNLADU1")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"4", "ABABABABABABABABABABAB3b")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "ababababababababababaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "abAbababababababaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "abAbabababababababaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"8", "bbaaaaaaaaaaaaaaacccccc")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "ssSsss")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "aaaaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "QQQQQ")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"5", "aaaaAAAAAA000000123456")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"1", "000aA")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"8", "aaaabbbbccccddeeddeeddeedd")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"6", "ppppppppppppppppppp")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "ababababababababaaaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "qqq123qqq")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "1020304050607080Baaaaa")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "10203040aaaaa50607080B")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "pppppp1020304050607080")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "ppppppppp")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"4", "AAAAAABBBBBB123456789a")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"3", "aaaabaaaaaa123456789F")
    LeetTest.assertReturn(Q420.Solution::strongPasswordChecker, __Serializer__::serialize,"2", "1234567890123456Baaaa")
}