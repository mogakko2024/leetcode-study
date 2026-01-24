class Solution {
    fun minPairSum(nums: IntArray): Int {
        var result = 0
        var start = 0
        var end = nums.lastIndex

        nums.sort()

        while (start <= end) {
            result = maxOf(result, nums[start] + nums[end])

            start++
            end--
        }

        return result
    }
}
