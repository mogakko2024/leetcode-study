class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var result = nums[0]

        for (i in 1 until nums.size) {
            max = maxOf(nums[i], max + nums[i])
            result = maxOf(result, max)
        }

        return result
    }
}
