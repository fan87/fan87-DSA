package daily

class Q832 {

    class Solution {
        fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
            return image.map {
                it.reversed().map { (it + 1) % 2 }.toTypedArray().toIntArray()
            }.toTypedArray()
        }
    }

}