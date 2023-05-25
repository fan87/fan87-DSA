package q231_240

// TODO: WTF is product
// Oh it's just multiplication of all the other elements in the array
// oh wait is it idfk whatever just come back and solve it one day
class Q238 {

    fun productExceptSelf(nums: IntArray): IntArray {
        val out = IntArray(nums.size)
        var currentValue = 1
        for (i in 0 until nums.size) {
            out[i] = currentValue
            currentValue *= nums[i]
        }
        currentValue = 1
        for (i in nums.size - 1 downTo 0) {
            out[i] = currentValue * out[i]
            currentValue *= nums[i]
        }

        return out
    }

}