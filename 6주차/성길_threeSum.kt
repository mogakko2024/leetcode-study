class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        val n = nums.size

        nums.sort()

        for (i in 0 until n) {
            if(i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = n - 1

            while (left < right) {
                val calculated = nums[i] + nums[left] + nums[right]
                if (calculated < 0) {
                    left++
                } else if (calculated > 0) {
                    right--
                } else {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                }
            }
        }

        return result.toList()
    }
}
