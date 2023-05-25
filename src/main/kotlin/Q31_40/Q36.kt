package Q31_40

class Q36 {

    class Solution {


        fun hasRepeated(array: Iterator<Char>): Boolean {
            val seen: BooleanArray = BooleanArray(10)
            for (c in array) {
                if (c == '.') continue
                if (seen[c.toInt() - 48]) {
                    return true
                }
                seen[c.toInt() - 48] = true
            }
            return false
        }

        fun isValidSudoku(board: Array<CharArray>): Boolean {
            for (x in 0 until 9) {
                if (hasRepeated(board[x].iterator())) return false
                if (hasRepeated(object : Iterator<Char> {
                        var currentRow = 0
                        override fun hasNext(): Boolean {
                            return currentRow < 9
                        }

                        override fun next(): Char {
                            return board[currentRow++][x]
                        }
                    })) return false
            }
            for (x in 0 until 3) {
                for (y in 0 until 3) {
                    if (hasRepeated(object : Iterator<Char> {
                            var currentIndex = 0
                            override fun hasNext(): Boolean {
                                return currentIndex < 9
                            }

                            override fun next(): Char {
                                return board[x*3 + currentIndex / 3][y*3 + currentIndex % 3].also { currentIndex++ }
                            }
                        })) return false
                }
            }
            return true
        }
    }

}