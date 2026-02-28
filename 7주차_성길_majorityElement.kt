class Solution {
    fun majorityElement(nums: IntArray): Int {
        val n = nums.size
        val majority = n / 2
        val map = mutableMapOf<Int, Int>()

        for (i in 0 until n) {
            val current = map.getOrDefault(nums[i], 0)
            if (current >= majority) return nums[i]
            map[nums[i]] = current + 1
        }

        return -1
    }
}
